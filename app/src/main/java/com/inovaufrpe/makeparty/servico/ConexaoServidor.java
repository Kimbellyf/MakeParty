package com.inovaufrpe.makeparty.servico;

import android.os.AsyncTask;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

// CLASSE DE REQUISIÇÃO CLIENTE HTTP
public class ConexaoServidor{

        //POST HTTP - RECEBE 2 PARÂMETROS - 0BJETO JSON(JA CONVERTIDO) E ROTA (URL)
        public String postHttp (String json, String rota) throws IOException {

            OkHttpClient client = new OkHttpClient();
            String url = rota;
            Request.Builder builder = new Request.Builder();
            builder.url(url);

            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            RequestBody body = RequestBody.create(mediaType, json);
            builder.post(body); // AQUI ELE TEM UM FUNÇÃO DO PRÓPRIO OBJETO PARA POST
            Request request = builder.build();

            Response response = client.newCall(request).execute();
            String jsonDeResposta = response.body().string();
            return jsonDeResposta;


        }

        //GET HTTP 1 PARÂMETRO É A ROTA
        public String getHttp (String rota) throws IOException {

            String url = rota;
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder().url(url).build(); // AQUI NÃO PRECISAR CHAMAR BUILD.GET()
            Response response = client.newCall(request).execute();

            String jsonDeResposta = response.body().string();
            return jsonDeResposta;
        }
    }






