package com.inovaufrpe.makeparty.servico;

import android.content.Context;
import android.util.Log;

import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.dominio.Anuncio;
import com.inovaufrpe.makeparty.utils.bibliotecalivroandroid.utils.HttpHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AnuncioService {

    private static final String TAG = "AnuncioService";
    private static final boolean LOG_ON = false;
    private static final String URL_BASE = "https://makepartyserver.herokuapp.com/";
    //POST, PUT, DELETE E GET
    private static final String URL_COLOCAR_ANUNCIO = URL_BASE + "ads";
    private static final String URL_LISTAR_ANUNCIOS = URL_BASE + "ads";

    //GET ANÚNCIOS
    private static final String URL_LISTAR_ANUNCIOS_PELA_TAG = URL_BASE + "tags/:tag";
    private static final String URL_LISTAR_ANUNCIOS_PELO_TIPO = URL_BASE + "/types/:type";
    private static final String URL_PESQUISAR_PJ_PELO_ID = URL_BASE + "advertisers/:id";
    private static final String URL_LISTAR_PJS = URL_BASE + "advertisers";


    private static String getTipo(int tipo) {
        if (tipo == R.string.text_pacotes) {
            return "pacotes";
        } else if (tipo == R.string.text_casas_de_festas) {
            return "casas";
        } else if (tipo == R.string.text_buffet) {
            return "buffet";
        } else if (tipo == R.string.text_decoracao) {
            return "decoracao";
        }
        return "animacao";
    }

    // Faz a requisição HTTP, cria a lista de anuncios e salva o JSON em arquivo
    /*public static List<Anuncio> getAnunciosFromWebService(Context context, int tipo) throws IOException {
        String tipoString = getTipo(tipo);
        String url = URL_LISTAR_ANUNCIOS_PELO_TIPO.replace(":type}", tipoString);
        Log.d(TAG, "URL: " + url);
        HttpHelper http = new HttpHelper();
        String json = http.doGet(url);
        List<Anuncio> anuncios = parserJSON(context, json);
        //salvaArquivoNaMemoriaInterna(context, url, json);
        // Depois de buscar salva os carros
        //salvarAnuncios(context, tipo, anuncios);
        return anuncios;
    }

    private static List<Anuncio> parserJSON(Context context, String json) throws IOException {
        List<Anuncio> anuncios = new ArrayList<Anuncio>();
        try {
            JSONObject root = new JSONObject(json);
            JSONObject obj = root.getJSONObject("anuncios");
            JSONArray jsonAnuncios = obj.getJSONArray("anuncio");
            // Insere cada anuncio na lista
            for (int i = 0; i < jsonAnuncios.length(); i++) {
                JSONObject jsonAnuncio = jsonAnuncios.getJSONObject(i);
                Anuncio anuncio = new Anuncio();
                // Lê as informações de cada anuncio
                anuncio.nome = jsonAnuncio.optString("nome");
                anuncio.desc = jsonAnuncio.optString("desc");
                anuncio.urlFoto = jsonAnuncio.optString("url_foto");
                anuncio.urlInfo = jsonAnuncio.optString("url_info");
                anuncio.urlVideo = jsonAnuncio.optString("url_video");
                anuncio.latitude = jsonAnuncio.optString("latitude");
                anuncio.longitude = jsonAnuncio.optString("longitude");
                if (LOG_ON) {
                    Log.d(TAG, "Anuncio " + anuncio.nome + " > " + anuncio.urlFoto);
                }
                anuncios.add(anuncio);
            }
            if (LOG_ON) {
                Log.d(TAG, anuncios.size() + " encontrados.");
            }
        } catch (JSONException e) {
            throw new IOException(e.getMessage(), e);
        }
        return anuncios;
    }*/
}
