package br.com.monster.smokeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import adapter.NovaVistoriaAdapter;
import adapter.VistoriaAdapter;
import model.Lista;
import pojo.Auth;
import util.DividerItemDecoration;
import util.RecyclerItemClickListener;

public class VistoriaRealizadaActivity extends AppCompatActivity {

    private RecyclerView rvVistoria;
    private LinearLayoutManager llm;
    private List<Lista> lista;
    private Auth auth = Auth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistoria_realizada_interna);

        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Vistorias realizadas");
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvVistoria = (RecyclerView) findViewById(R.id.rvVistoria);
        llm = new LinearLayoutManager(this);
        rvVistoria.setLayoutManager(llm);
        rvVistoria.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        rvVistoria.addItemDecoration(itemDecoration);
        VistoriaAdapter adapter = new VistoriaAdapter(getApplicationContext(), auth.getVistoriasArrayList());
        rvVistoria.setAdapter(adapter);

        rvVistoria.addOnItemTouchListener(
                new RecyclerItemClickListener(this, rvVistoria ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        //Toast.makeText(VistoriaRealizadaActivity.this, "Posição " + position,
                        //        Toast.LENGTH_LONG).show();
                        Intent it = new Intent(getBaseContext(), NovaVistoriaActivity.class);
                        it.putExtra("posicao", position);
                        it.putExtra("modo", "view");
                        startActivity(it);
                        finish();

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent it = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(it);
                finish();
                return true;
            case R.id.action_home:
                Intent iti = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(iti);
                finish();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.homee, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
    }
}
