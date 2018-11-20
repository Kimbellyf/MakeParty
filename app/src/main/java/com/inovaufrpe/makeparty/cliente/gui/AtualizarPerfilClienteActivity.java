package com.inovaufrpe.makeparty.cliente.gui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.fornecedor.gui.TelaInicialFornecedorActivity;

public class AtualizarPerfilClienteActivity extends AppCompatActivity {

    private ImageView fotoAvatarCliente;
    private FloatingActionButton mudarFoto;
    private Button mudarNome,mudarEmail,mudarSenha,apagarConta,sair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_perfil_cliente);
    }

    private void procurandoViews(){

        this.fotoAvatarCliente = findViewById(R.id.ImageViewAvatarCliente);
        this.mudarFoto = findViewById(R.id.floatingMudarFotoPerfilCliente);
        this.mudarNome = findViewById(R.id.button_modificar_nome_cliente);
        this.mudarEmail = findViewById(R.id.button_modificar_email_cliente);
        this.mudarSenha = findViewById(R.id.button_modificar_senha_cliente);
        this.apagarConta = findViewById(R.id.button_modificar_apagar_conta_cliente);
        this.sair = findViewById(R.id.button_modificar_sair_cliente);

    }

    public void mudarTela(Class tela){
        Intent intent=new Intent(this, tela);
        startActivity(intent);
        finish();
    }

    public void telaMudarFotoCliente(View view) {
        // this.mudarTela();
    }

    public void telaMudarNomeCliente(View view) {
        // this.mudarTela();
    }

    public void telaMudarEmailCliente(View view) {
        //this.mudarTela();
    }

    public void telaMudarSenhaCliente(View view) {
        //this.mudarTela();
    }

    public void telaApagarContaCliente(View view) {
        //this.mudarTela();
    }

    public void telaSairCliente(View view) {
        this.onBackPressed();
    }

    @Override // por enq dando o back e só fechando
    public void onBackPressed() {
        this.mudarTela(TelaInicialClienteActivity.class);

    }
}
