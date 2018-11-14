package com.inovaufrpe.makeparty.usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.cliente.gui.TelaInicialClienteActivity;

public class EscolhaTipoUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_tipo_user);
    }
    private void mudarTela(Class proximaTela){
        Intent intent = new Intent( EscolhaTipoUserActivity.this, proximaTela);
        startActivity(intent);
        finish();
    }
    public void irParaEscolhaEntrarOuCadastrar(View view) {
        this.mudarTela(EntrarOuCadastrarActivity.class);
    }
    public void irParaTelaCliente(View view){
        this.mudarTela(TelaInicialClienteActivity.class);
    }
    @Override
    public void onBackPressed() {
        finish();
    }

}
