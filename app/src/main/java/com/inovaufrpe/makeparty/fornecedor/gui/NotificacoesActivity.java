package com.inovaufrpe.makeparty.fornecedor.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.inovaufrpe.makeparty.R;

public class NotificacoesActivity extends AppCompatActivity {
    private ListView listaNotificacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacoes);
    }
}
