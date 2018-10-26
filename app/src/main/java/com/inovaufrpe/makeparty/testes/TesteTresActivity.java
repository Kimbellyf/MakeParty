package com.inovaufrpe.makeparty.testes;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.inovaufrpe.makeparty.R;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//TESTE NUMBER 3, COM OKHTTP, POST/PUT, REFERENCIA:
// https://pt.stackoverflow.com/questions/104369/como-recuperar-dados-json-de-uma-url-utilizando-http-post-no-android
public class TesteTresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_tres);
    }
    private final class Send extends AsyncTask<Void, Void, Void>
    {

        final Context mContext;
        Send(final Context mContext)
        {
            this.mContext = mContext;
        }
        @Override
        protected Void doInBackground(Void... params) {

            final OkHttpClient mClient = new OkHttpClient();
            RequestBody body = null;
            Request.Builder requestBuilder = new Request.Builder();
            requestBuilder.url("www.url.com.br/send");
            final HashMap<String, String> mParams = new HashMap<>(0);

            mParams.put("param1", "Valo1" );
            mParams.put("param4", "Valor2" );
            mParams.put("param3", "Valor3" );

            final JSONObject jsonObject = new JSONObject(mParams);
            body = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
            requestBuilder.post(body);
            //OkHttpModel.loadHeaders(requestBuilder, mContext);

            try{
                final Response response = mClient.newCall(requestBuilder.build()).execute();
                final String txtResult = response.body().string();

              //  MeuObjeto meuObjeto = new Gson().fromJson(txtResult, MeuObjeto.class);


            }catch (final IOException e){
                e.printStackTrace();
            }


            return null;
        }
    }

}
