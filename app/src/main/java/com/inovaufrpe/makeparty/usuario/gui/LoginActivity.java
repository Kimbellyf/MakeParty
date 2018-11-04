package com.inovaufrpe.makeparty.usuario.gui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.infra.Sessao;
import com.inovaufrpe.makeparty.infra.SessionApi;
import com.inovaufrpe.makeparty.usuario.dominio.Usuario;
import com.inovaufrpe.makeparty.usuario.servico.HttpConnection;
import com.inovaufrpe.makeparty.usuario.servico.ServicoDownload;
import com.inovaufrpe.makeparty.usuario.servico.ValidacaoGuiRapida;

public class LoginActivity extends AppCompatActivity{
    private EditText edtEmail, edtSenha;
    private ProgressDialog dialog;
    private ValidacaoGuiRapida validacaoGuiRapida = new ValidacaoGuiRapida();

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
                if(Sessao.instance.getResposta().contains("E-mail ou senha incorretos")){
                    dialog.dismiss();
                    Toast.makeText(this, "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show();
                } else {
                    getSessaoApi();
                    dialog.dismiss();
                    String token = Sessao.instance.getResposta();
                    //Intent intent = new Intent(getApplicationContext(), BottomNavigation.class);
                    //startActivity(intent);
                    Toast.makeText(this, "Logado", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Sem conexão com a internet", Toast.LENGTH_SHORT).show();
            }

        }

    }

    private void getSessaoApi() throws InterruptedException {
        Gson gson = new Gson();
        SessionApi sessionApi = gson.fromJson(Sessao.instance.getResposta(), SessionApi.class);
        Sessao.instance.setSession(sessionApi);
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
                Sessao.instance.setResposta(HttpConnection.post("https://makepartyserver.herokuapp.com/users/authenticate", data));
                Log.i("Script", "OLHAAA: "+ Sessao.instance
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
}
