package com.inovaufrpe.makeparty.cliente.gui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.cliente.gui.dialog.SimOuNaoDialog;
import com.inovaufrpe.makeparty.fornecedor.gui.TelaInicialFornecedorActivity;
import com.inovaufrpe.makeparty.infra.SessaoApplication;

public class AtualizarPerfilClienteActivity extends AppCompatActivity {

    private ImageView fotoAvatarCliente;
    private FloatingActionButton mudarFoto;
    private Button mudarNome,mudarEmail,mudarSenha,apagarConta,sair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_perfil_cliente);
        procurandoViews();
    }

    private void procurandoViews(){

        fotoAvatarCliente = findViewById(R.id.ImageViewAvatarCliente);
        mudarFoto = findViewById(R.id.floatingMudarFotoPerfilCliente);
        mudarNome = findViewById(R.id.button_modificar_nome_cliente);
        mudarEmail = findViewById(R.id.button_modificar_email_cliente);
        mudarSenha = findViewById(R.id.button_modificar_senha_cliente);
        apagarConta = findViewById(R.id.button_modificar_apagar_conta_cliente);
        sair = findViewById(R.id.button_modificar_sair_cliente);

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
        SimOuNaoDialog.show(getSupportFragmentManager(),"Deseja mesmo apagar sua conta?", new SimOuNaoDialog.Callback() {
            @Override
            public void metodoSimAoDialog() {

            }
        });
    }

    public void telaSairCliente(View view) {
        SimOuNaoDialog.show(getSupportFragmentManager(),"Deseja mesmo sair da sua conta?", new SimOuNaoDialog.Callback() {
            @Override
            public void metodoSimAoDialog() {
                SessaoApplication.instance.onTerminate();
                finish();

            }
        });
    }

    @Override // por enq dando o back e só fechando
    public void onBackPressed() {
        this.mudarTela(TelaInicialClienteActivity.class);

    }
}
