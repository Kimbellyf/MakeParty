package com.inovaufrpe.makeparty.fornecedor.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.fornecedor.dominio.Anuncio;
import com.inovaufrpe.makeparty.fornecedor.gui.adapter.AnuncioFornecedorAdapter;

import java.util.ArrayList;


public class AnunciosFornecedorActivity extends AppCompatActivity {
    private ArrayList<Anuncio> lista;
    private Button cadstarAnuncio;
    private ListView listaAnuncios;
    private Button cadstarAnuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios_fornecedor);

    }

    private void criarAnuncio(){
        startActivity(new Intent(AnunciosFornecedorActivity.this, CriarAnuncio.class))
        AnunciosFornecedorActivity.this.finish();
    }
    //checar os Ids
    private void setTela(){
        cadstarAnuncio = findViewById(R.id.cadstarAnuncioId);
        listaAnuncios = findViewById(R.id.listaAnunciosId);
        lista = findViewById(R.id.listaId);
    }

}
