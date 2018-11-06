package com.inovaufrpe.makeparty.fornecedor.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.inovaufrpe.makeparty.R;

public class TelaInicialFornecedorActivity extends AppCompatActivity {
    private ImageView notificacoes;
    private ImageView calendar;
    private ImageView configuracoes;
    private ImageView anuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_fornecedor);
        setView();
        notificacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaInicialFornecedorActivity.this, NotificacoesActivity.class));
            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaInicialFornecedorActivity.this,CalendarActivity.class));
            }
        });
        configuracoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaInicialFornecedorActivity.this,ConfiguracoesFornecedorActivity.class));
            }
        });
        anuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaInicialFornecedorActivity.this, AnunciosFornecedorActivity.class));
            }
        });
    }
    private void setView() {
        notificacoes = findViewById(R.id.notificacoesId);
        calendar = findViewById(R.id.calendarId);
        configuracoes = findViewById(R.id.configuracoesId);
        anuncios = findViewById(R.id.anunciosId);
    }

    @Override // por enq dando o back e só fechando
    public void onBackPressed() {
        finish();
        //super.onBackPressed();
    }


}
