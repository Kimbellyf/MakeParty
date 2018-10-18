package com.inovaufrpe.makeparty.servico;

import android.os.AsyncTask;
import java.net.HttpURLConnection;


import com.google.android.gms.common.images.WebImage;
import com.inovaufrpe.makeparty.servico.UsuarioService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;


public class ConexaoServidor extends AsyncTask<String, String, String> {


    private UsuarioService usuarioService = new UsuarioService();


    @Override
    protected String doInBackground(String... strings) {
        // Este método é usado para exibir qualquer forma de progresso na interface do usuário,
        // enquanto a tarefa ainda está em execução.
        return null;
    }

    @Override
    protected void onPreExecute(){
        // Este passo é usado para configurar a tarefa, por exemplo, mostrando uma barra de progresso na interface do usuário.
    }

    @Override
    protected void onProgressUpdate () {
        // Este método é usado para exibir qualquer forma de progresso na interface do usuário, enquanto a tarefa ainda está em execução.
    }

    @Override
    protected void onPostExecute(){
        // // O resultado da execução em background é passado para este passo como um parâmetro.

    }

}
