package com.inovaufrpe.makeparty.fornecedor.gui;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.cliente.gui.TelaInicialClienteActivity;
import com.inovaufrpe.makeparty.cliente.gui.dialog.SimOuNaoDialog;
import com.inovaufrpe.makeparty.infra.SessaoApplication;
import com.inovaufrpe.makeparty.infra.utils.Permissoes;
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
        procurandoViews();
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
    //Metodos da foto ainda falta setar e enviar para a API, fora retornar a img da API(CASO LOGADO) no icone do user
    public void telaMudarFotoFornecedor(View view) {
        // this.mudarTela();
        Boolean resultadopermissao =permissoesParaCamera();
        if (resultadopermissao){
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,0);
        }
    }
    //Metodo ainda ta dando erros
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (data !=null) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                //Recupera o bitmap retornado pela câmera
                Bitmap bitmap = (Bitmap) bundle.get("data");
                //Atualiza a imagem na tela
                fotoAvatarFornecedor.setImageBitmap(bitmap);
            }
        }

    }
    //lista de permissoes para a camera e chamada se a permissao foi ok ou n
    public boolean permissoesParaCamera(){
        String permissions[] = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
        };
        boolean ok = Permissoes.validate(this, 0, permissions);
        return ok;
    }
    @Override
    //Mensagem para a caso a lista de permissões seja negada por exemplo
    public void onRequestPermissionsResult(int requestCode, String permissions[],
                                           int[] grantResults){
        for (int result : grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "É preciso autorizar o uso da camera para tirar a sua foto", Toast.LENGTH_SHORT).show();
                finish();
                return;
            }
        }
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
        SimOuNaoDialog.show(getSupportFragmentManager(),"Deseja mesmo apagar sua conta?", new SimOuNaoDialog.Callback() {
            @Override
            public void metodoSimAoDialog() {

            }
        });
    }

    public void telaSairFornecedor(View view) {
        SimOuNaoDialog.show(getSupportFragmentManager(),"Deseja mesmo sair da sua conta?", new SimOuNaoDialog.Callback() {
            @Override
            public void metodoSimAoDialog() {
                SessaoApplication.instance.onTerminate();
                finish();

            }
        });
    }

    public void callDialog(String message,String tipo){

    }

    @Override // por enq dando o back e só fechando
    public void onBackPressed() {
        this.mudarTela(TelaInicialFornecedorActivity.class);

    }



}
