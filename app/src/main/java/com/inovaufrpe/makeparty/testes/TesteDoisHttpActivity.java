package com.inovaufrpe.makeparty.testes;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.servico.ConexaoServidor;
import com.inovaufrpe.makeparty.servico.ClienteService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//Teste com video do youtube, n é com OKHTTP - TESTE POST
public class TesteDoisHttpActivity extends AppCompatActivity {

    ConexaoServidor conexaoServidor;
    ClienteService clienteService = new ClienteService();
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_dois_http);
        text = findViewById(R.id.textView2);
        //new CheckConnectionStatus().execute();

    }
    class CheckConnectionStatus extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            text.setText("");
        }

        @Override
        protected String doInBackground(String... params) {
            URL url = null;
            try{
                url = new URL(params[0]);
            }catch (MalformedURLException e){
                e.printStackTrace();

            }try{
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoOutput(true);

                Uri.Builder builder = new Uri.Builder()
                        //.appendQueryParameter("email","kimlinda@gmail.com")
                        //.appendQueryParameter("password","1234567")
                        .appendQueryParameter("name","KimLinda")
                        .appendQueryParameter("cpf","11111111111")
                        .appendQueryParameter("birthdate","15051997")
                        .appendQueryParameter("phone","81998912935");

                OutputStream outputStream = urlConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                bufferedWriter.write(builder.build().getEncodedQuery());
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String s = bufferedReader.readLine();
                bufferedReader.close();

                return s;
                //return String.valueOf(urlConnection.getResponseCode());
            }catch (IOException e) {
                Log.e("Error: ", e.getMessage(), e);

            }
            return null;
        }
        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            text.setText(s);

        }
    }
}
