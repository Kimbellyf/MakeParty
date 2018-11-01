package com.inovaufrpe.makeparty.fornecedor.gui;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.inovaufrpe.makeparty.R;

public class TelaInicialFornecedorActivity extends AppCompatActivity {
    private ImageView notificacoes;
    private ImageView calendar;
    private ImageView configuracoes;
    //private ImageView solicitacoes;

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
                startActivity(new Intent(TelaInicialFornecedorActivity.this,ConfiguracoesActivity.class));
            }
        });
    }
    private void setView() {
        notificacoes = findViewById(R.id.notificacoesId);
        calendar = findViewById(R.id.calendarId);
        configuracoes = findViewById(R.id.configuracoesId);
        //solicitacoes = findViewById(R.id.solicitacoesId);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
