package com.inovaufrpe.makeparty.usuario.gui;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.inovaufrpe.makeparty.R;

public class EntrarOuCadastrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar_ou_cadastrar);
    }
    private void mudarTela(Class proximaTela){
        Intent intent = new Intent( EntrarOuCadastrarActivity.this, proximaTela);
        startActivity(intent);
        finish();
    }

    public void irParaTelaEntrar(View view) {
        this.mudarTela(LoginActivity.class);
    }

    public void irParaTelaCriarConta(View view) {
        this.mudarTela(CadastroActivity.class);
    }
    @Override
    public void onBackPressed() {
        this.mudarTela(EscolhaTipoUserActivity.class);
    }
}
