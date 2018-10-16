package com.inovaufrpe.makeparty.servico;

import android.os.AsyncTask;
import java.net.HttpURLConnection;


import com.google.android.gms.common.images.WebImage;
import com.inovaufrpe.makeparty.servico.UsuarioService;

public class ConexaoServidor extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... strings) {
        return null;
    }

    public String criarJsonObjeto(Object objeto){
        return gson.toJson(objeto);
    }


}
