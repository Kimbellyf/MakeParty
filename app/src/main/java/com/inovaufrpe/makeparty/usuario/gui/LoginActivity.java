package com.inovaufrpe.makeparty.usuario.gui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.cliente.gui.TelaInicialClienteActivity;
import com.inovaufrpe.makeparty.fornecedor.gui.TelaInicialFornecedorActivity;
import com.inovaufrpe.makeparty.infra.SessaoApplication;
import com.inovaufrpe.makeparty.usuario.dominio.Usuario;
import com.inovaufrpe.makeparty.infra.ConectarServidor;
import com.inovaufrpe.makeparty.infra.ServicoDownload;
import com.inovaufrpe.makeparty.usuario.servico.ValidacaoGuiRapida;

public class LoginActivity extends AppCompatActivity{
    private EditText edtEmail, edtSenha;
    private ProgressDialog dialog;
    private ValidacaoGuiRapida validacaoGuiRapida = new ValidacaoGuiRapida();
    private String tipoUserLogou ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        encontrandoElementosView();
    }
    private void encontrandoElementosView(){
        edtEmail= findViewById(R.id.editTextEmail);
        edtSenha= findViewById(R.id.editTextSenha);

    }
    //Por enq só pegando os dados e transf em string, sem chamar o serviço
    public void onClickLogar(View view){
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();
        dialog = new ProgressDialog(LoginActivity.this);
        dialog.setTitle("Verficando dados...");
        try {
            login();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private void login() throws InterruptedException {
        if (this.verificarCampos()) {
            if(isOnline()){
                String usuario = setarUsuario(edtEmail.getText().toString().trim(), edtSenha.getText().toString().trim());
                logar(usuario);
                //Toast.makeText(this, Sessao.instance.getResposta(), Toast.LENGTH_SHORT).show();
                if(SessaoApplication.instance.getResposta().contains("E-mail ou senha incorretos")){
                    dialog.dismiss();
                    Toast.makeText(this, "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show();
                } else {
                    //getSessaoApi();
                    dialog.dismiss();
                    String[] parts = SessaoApplication.instance.getResposta().split(",");
                    String token = parts[0].substring(9,parts[0].length()); //FALTA  setar o usuario logado
                    tipoUserLogou = parts[1].substring(8,parts[1].length()-2);
                    SessaoApplication.instance.setTokenUser(token);
                    SessaoApplication.instance.setTipoDeUserLogado(tipoUserLogou);
                    //Toast.makeText(this, tipoUserLogou, Toast.LENGTH_SHORT).show();

                    Toast.makeText(this, "Logado", Toast.LENGTH_SHORT).show();
                    if (tipoUserLogou.equals("customer")){
                        irParaTelaInicialCliente();
                    }else{
                        irParaTelaInicialFornecedor();
                    }
                }
            } else {
                Toast.makeText(this, "Sem conexão com a internet", Toast.LENGTH_SHORT).show();
            }

        }

    }

    private void getSessaoApi() throws InterruptedException {
        Gson gson = new Gson();
        //SessionApi sessionApi = gson.fromJson(Sessao.instance.getResposta(), SessionApi.class);
        //Sessao.instance.setSession(sessionApi);
       // setMApi(sessionApi.getUser());
    }

    /*private void setMApi(final Usuario usuario) throws InterruptedException {
        final ServicoHttpM servicoHttpM = new ServicoHttpM();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                M m = servicoHttpM.getMByUser(usuario);
                Sessao.instance.setM(m);
            }
        });
        thread.start();
        thread.join();
    }*/


    private void logar(String jason)  throws InterruptedException {
        callServer(jason);

    }

    private void callServer(final String data) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SessaoApplication.instance.setResposta(ConectarServidor.post("https://makepartyserver.herokuapp.com/users/authenticate", data));
                Log.i("Script", "OLHAAA: "+ SessaoApplication.instance
                        .getResposta());
            }
        });
        thread.start();
        thread.join();
        dialog.cancel();
    }
    private boolean verificarCampos() {
        String email = this.edtEmail.getText().toString().trim();
        String senha = this.edtSenha.getText().toString().trim();
        if (!validacaoGuiRapida.isEmailValido(email)) {
            this.edtEmail.setError("Email Inválido");
            return false;
        } else if (validacaoGuiRapida.isCampoVazio(senha)) {
            this.edtSenha.setError("Senha Inválida");
            return false;
        } else {
            return true;
        }
    }

    private String setarUsuario(String email, String senha){
        Usuario usuario = new Usuario();
        usuario.setPassword(senha);
        usuario.setEmail(email);
        Gson gson = new Gson();
        String user = gson.toJson(usuario);

        return user;
    }

    private boolean isOnline() {
        if(ServicoDownload.isNetworkAvailable(getApplicationContext()))
        {
            return true;
        }else{
            return false;
        }
    }
    private void mudarTela(Class tela){
        Intent intent=new Intent(this, tela);
        startActivity(intent);
        finish();
    }
    public void irParaTelaInicialCliente(){
        this.mudarTela(TelaInicialClienteActivity.class);
    }
    public void irParaTelaInicialFornecedor(){
        this.mudarTela(TelaInicialFornecedorActivity.class);
    }
    @Override
    public void onBackPressed(){
        this.mudarTela(EntrarOuCadastrarActivity.class);

    }
}
