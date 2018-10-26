package com.inovaufrpe.makeparty.testes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.inovaufrpe.makeparty.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//TESTE GET COM OKHTTP, SIM, RETORNOU, MAS N RETRANSFORMEI OS DADOS OBTIDOS EM OBJETOS DNV, SÓ VEIO OS COD JSON
public class HttpRequestExampleActivity extends AppCompatActivity {
    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_request_example);
        mTextViewResult = findViewById(R.id.text_view_result);
        requisicaoMetodoOkHttp();

    }
    //Metodo GET
    private void requisicaoMetodoOkHttp(){
        OkHttpClient client = new OkHttpClient();
        String url = "https://makepartyserver.herokuapp.com/ads";
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    final String myResponse = response.body().string();
                    HttpRequestExampleActivity.this.runOnUiThread(new Runnable(){
                        @Override
                        public void run(){
                            mTextViewResult.setText(myResponse);
                        }
                    });

                }

            }
        });

    }
}
