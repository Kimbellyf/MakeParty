package com.inovaufrpe.makeparty.fornecedor.gui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.usuario.gui.EscolhaTipoUserActivity;
import com.inovaufrpe.makeparty.usuario.gui.LoginActivity;

public class ConfiguracoesFornecedorActivity extends AppCompatActivity {

    private ImageView fotoAvatarFornecedor;
    private FloatingActionButton mudarFoto;
    private Button mudarNome, mudarCnpj,mudarSenha,mudarEmail,mudarPlano,mandarMensagem;
    private Button apagarConta,sair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes_fornecedor);
    }

    private void procurandoViews() {
        fotoAvatarFornecedor = findViewById(R.id.ImageViewAvatarFornecedor);
        mudarFoto = findViewById(R.id.floatingMudarFotoPerfilFornecedor);
        mudarNome = findViewById(R.id.button_modificar_nome_fornecedor);
        mudarEmail= findViewById(R.id.button_modificar_email_fornecedor);
        mudarSenha = findViewById(R.id.button_modificar_senha_fornecedor);
        mudarCnpj = findViewById(R.id.button_modificar_cnpj_fornecedor);
        mudarPlano = findViewById(R.id.button_mudar_plano_fornecedor);
        mandarMensagem = findViewById(R.id.button_modificar_mandar_mensagem_fornecedor);
        apagarConta = findViewById(R.id.button_modificar_apagar_conta_fornecedor);
        sair = findViewById(R.id.button_modificar_sair_fornecedor);

    }

    public void mudarTela(Class tela){
        Intent intent=new Intent(this, tela);
        startActivity(intent);
        finish();
    }

    public void telaMudarFotoFornecedor(View view) {
        // this.mudarTela();
    }

    public void telaMudarNomeFornecedor(View view) {
        // this.mudarTela();
    }

    public void telaMudarEmailFornecedor(View view) {
        //this.mudarTela();
    }

    public void telaMudarSenhaFornecedor(View view) {
        //this.mudarTela();
    }

    public void telaMudarCnpjFornecedor(View view) {
        //this.mudarTela();
    }

    public void telaMudarPlanoFornecedor(View view) {
        //this.mudarTela();
    }

    public void telaMandarMensagemFornecedor(View view) {
        //this.mudarTela();
    }

    public void telaApagarContaFornecedor(View view) {
        //this.mudarTela();
    }

    public void telaSairFornecedor(View view) {
        //this.mudarTela();
    }

    @Override // por enq dando o back e só fechando
    public void onBackPressed() {
        this.mudarTela(TelaInicialFornecedorActivity.class);

    }


}
