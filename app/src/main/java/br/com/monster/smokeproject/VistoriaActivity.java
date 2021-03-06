package br.com.monster.smokeproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class VistoriaActivity extends AppCompatActivity {

    private String posicao = "";

    private Button btnNovaVistoria;
    private Button btnApoio;
    private TextView tvEscolhaAcao;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_vistoria_realizada);
        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Vistoria");
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            position = extras.getInt("posicao");
            EstacoesElevatoriasActivity.estacao.finish();
        }

        //Fontes.ttf
        Typeface RalewayBold = Typeface.createFromAsset(getResources().getAssets(), "Raleway-Bold.ttf");
        Typeface RalewayMedium = Typeface.createFromAsset(getResources().getAssets(), "Raleway-Medium.ttf");
        Typeface RalewayRegular = Typeface.createFromAsset(getResources().getAssets(), "Raleway-Regular.ttf");
        Typeface Odebrecht = Typeface.createFromAsset(getResources().getAssets(), "odebrecht-slab-webfont.ttf");

        tvEscolhaAcao = (TextView) findViewById(R.id.tvEscolhaAcao);
        tvEscolhaAcao.setTypeface(RalewayBold);

        btnNovaVistoria=(Button) findViewById(R.id.btnNovaVistoria);
        btnNovaVistoria.setTypeface(RalewayBold);
        btnNovaVistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), NovaVistoriaActivity.class);
                it.putExtra("posicao", position);
                it.putExtra("modo", "new");
                startActivity(it);
                finish();
            }
        });

        btnApoio=(Button) findViewById(R.id.btnApoio);
        btnApoio.setTypeface(RalewayBold);
        btnApoio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), ApoioActivity.class);
                it.putExtra("posicao", position);
                startActivity(it);
                finish();
            }
        });


    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent it = new Intent(getBaseContext(), EstacoesElevatoriasActivity.class);
                startActivity(it);
                finish();
                return true;
            case R.id.action_home:
                Intent iti = new Intent(getBaseContext(), EstacoesElevatoriasActivity.class);
                startActivity(iti);
                finish();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Intent it = new Intent(getBaseContext(), EstacoesElevatoriasActivity.class);
        startActivity(it);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.homee, menu);
        return true;
    }
}
