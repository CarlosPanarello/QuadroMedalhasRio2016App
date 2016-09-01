package com.carlospanarello.quadromedalhasrio2016;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.carlospanarello.quadromedalhasrio2016.adapter.QuadroMedalhasAdapter;
import com.carlospanarello.quadromedalhasrio2016.model.ItemQuadroMedalha;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class QuadroMedalhas extends AppCompatActivity {

    ListView mainListView;
    QuadroMedalhasAdapter adapter;
    ModelHelper db;
    boolean executouPesquisa;

    private static final int REQUEST_CODE = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadro_medalhas);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        db = new ModelHelper(this);
        executouPesquisa=false;
        new HttpRequestTask().execute();
        populaLista();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_lista_quiz, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode){
            case Constantes.RETURN_CODE_RESPONDER:
                populaLista();
                break;
            case Constantes.RETURN_CODE_CRIAR:
                //populaLista();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void populaLista(){

        List<ItemQuadroMedalha> listaMedalhas =  db.getQuadroMedalhas();

        if((listaMedalhas == null || listaMedalhas.size() <=0) && executouPesquisa){

            AlertDialog alertDialog = new AlertDialog.Builder(QuadroMedalhas.this).create();
            alertDialog.setTitle("Erro");
            alertDialog.setMessage("Não foi possivel obter os dados sobre o quandro de medalhas, verifique sua conexão com rede.");
            // Alert dialog button
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Alert dialog action goes here
                            // onClick button code here
                            dialog.dismiss();
                            QuadroMedalhas.this.finish();
                            //dialog.dismiss();// use dismiss to cancel alert dialog
                        }
                    });
            alertDialog.show();


            return;
        }

        mainListView = (ListView) findViewById(R.id.listView_Medalhas);

        adapter = new QuadroMedalhasAdapter(this, R.layout.item_quadro_medalha, listaMedalhas);

        mainListView.setAdapter(adapter);
        mainListView.setItemsCanFocus(false);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemQuadroMedalha item = (ItemQuadroMedalha) parent.getItemAtPosition(position);
                Intent i = new Intent(QuadroMedalhas.this, MedalhasPais.class);

                i.putExtra(Constantes.CODIGO_PAIS, item.getId_country());
                i.putExtra(Constantes.NOME_PAIS, item.getName_country());

                startActivityForResult(i, REQUEST_CODE);

            }
        });
    }


    private class HttpRequestTask extends AsyncTask<Void, Void, ItemQuadroMedalha[]> {
        @Override
        protected  ItemQuadroMedalha[] doInBackground(Void... params) {
            try {
                final String url = Constantes.END_BUSCA_MEDALHAS;
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ItemQuadroMedalha[] m = restTemplate.getForObject(url, ItemQuadroMedalha[].class);
                executouPesquisa = true;
                return m;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(ItemQuadroMedalha[] mrVO) {
            if(mrVO != null && mrVO.length > 0 ) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
                db.deleteAllAtualizacao();
                db.incluiDataUltimaAtualizacao(sdf.format(new Date()));
                db.deleteAllQuadro();
                db.popularQuadro(mrVO);
            }

            populaLista();
        }

    }


}
