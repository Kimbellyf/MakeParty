package com.inovaufrpe.makeparty.fornecedor.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.inovaufrpe.makeparty.R;


public class AnunciosFornecedorActivity extends AppCompatActivity {
    private ListView listaAnuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios_fornecedor);
    }
}
