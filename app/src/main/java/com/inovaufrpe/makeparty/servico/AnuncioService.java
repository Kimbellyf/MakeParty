package com.inovaufrpe.makeparty.servico;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.dominio.Anuncio;
import com.inovaufrpe.makeparty.utils.bibliotecalivroandroid.utils.FileUtils;
import com.inovaufrpe.makeparty.utils.bibliotecalivroandroid.utils.HttpHelper;
import com.inovaufrpe.makeparty.utils.bibliotecalivroandroid.utils.IOUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnuncioService {

    private static final String TAG = "AnuncioService";
    private static final boolean LOG_ON = false;
    private static final String URL_BASE = "https://makepartyserver.herokuapp.com/";
    //POST, PUT, DELETE E GET
    private static final String URL_COLOCAR_ANUNCIO = URL_BASE + "ads";
    private static final String URL_LISTAR_ANUNCIOS = URL_BASE + "ads";
    //GET ANÚNCIOS
    private static final String URL_LISTAR_ANUNCIOS_PELA_TAG = URL_BASE + "ads/tags/:tag";
    private static final String URL_LISTAR_ANUNCIOS_PELO_TIPO = URL_BASE + "ads/types/:type";
    private static final String URL_PESQUISAR_PJ_PELO_ID = URL_BASE + "advertisers/:id";
    private static final String URL_LISTAR_PJS = URL_BASE + "advertisers";
    private Gson gson = new Gson();
    private String respostaServidor;
    private ConexaoServidor conexaoServidor = new ConexaoServidor();

    public AnuncioService() {
    } //CONSTRUTOR

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
    public static List<Anuncio> getAnunciosFromWebService(Context context, int tipo) throws IOException {
        String tipoString = getTipo(tipo);
        String url = URL_LISTAR_ANUNCIOS_PELO_TIPO.replace(":type", tipoString);
        Log.d(TAG, "URL: " + url);
        HttpHelper http = new HttpHelper();
        String json = http.doGet(url);
        List<Anuncio> anuncios = parserJSON(context, json);
        salvaArquivoNaMemoriaInterna(context, url, json);
        // Depois de buscar salva os anuncios
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
                anuncio.setTitle(jsonAnuncio.optString("title"));
                anuncio.setDescription(jsonAnuncio.optString("description"));
                //anuncio.seturlFoto = jsonAnuncio.optString("url_foto");
                //anuncio.urlInfo = jsonAnuncio.optString("url_info");
                if (LOG_ON) {
                    Log.d(TAG, "Anuncio " + anuncio.getTitle() + " > " );//+ anuncio.urlFoto);
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
    }

    private static void salvaArquivoNaMemoriaInterna(Context context, String url, String json) {
        String fileName = url.substring(url.lastIndexOf("/") + 1);
        File f = FileUtils.getFile(context, fileName);
        IOUtils.writeString(f, json);
        Log.d(TAG, "Arquivo salvo: " + f);

    }

    public static List<Anuncio> getAnunciosFromRaw(Context context, int tipo) throws IOException {
        //String json = readFile(context, tipo);
        //List<Anuncio> anuncios = parserJSON(context, json);

        //return anuncios;
        return null;
    }
    // Abre o arquivo salvo, se existir, e cria a lista de anuncios
    public static List<Anuncio> getAnunciosFromArquivo(Context context, int tipo) throws IOException {
        String tipoString = getTipo(tipo);
        String fileName = String.format("anuncios_%s.json", tipoString);
        Log.d(TAG, "Abrindo arquivo: " + fileName);
        // Lê o arquivo da memória interna
        String json = FileUtils.readFile(context, fileName, "UTF-8");
        if (json == null) {
            Log.d(TAG, "Arquivo " + fileName + " não encontrado.");
            return null;
        }
        List<Anuncio> anuncios = parserJSON(context, json);
        Log.d(TAG, "Retornando anuncios do arquivo " + fileName + ".");
        return anuncios;
    }

    //converte um objeto para json
    public String criarJson(Object objeto) {
        return gson.toJson(objeto);
    }

    //método que usa a requisição http implementada em conexaoServidor para criar usuário
    public void criarAnuncio(Object objeto) {
        String novoJson = criarJson(objeto);
        conexaoServidor.execute(novoJson);

    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public ConexaoServidor getConexaoServidor() {
        return conexaoServidor;
    }

    public void setConexaoServidor(ConexaoServidor conexaoServidor) {
        this.conexaoServidor = conexaoServidor;
    }

    public String getRespostaServidor() {
        return respostaServidor;
    }

    public void setRespostaServidor(String respostaServidor) {
        this.respostaServidor = respostaServidor;
    }


    public static String getTAG() {
        return TAG;
    }

    public static boolean isLogOn() {
        return LOG_ON;
    }

    public static String getUrlBase() {
        return URL_BASE;
    }

    public static String getUrlColocarAnuncio() {
        return URL_COLOCAR_ANUNCIO;
    }

    public static String getUrlListarAnuncios() {
        return URL_LISTAR_ANUNCIOS;
    }

    public static String getUrlListarAnunciosPelaTag() {
        return URL_LISTAR_ANUNCIOS_PELA_TAG;
    }

    public static String getUrlListarAnunciosPeloTipo() {
        return URL_LISTAR_ANUNCIOS_PELO_TIPO;
    }

    public static String getUrlPesquisarPjPeloId() {
        return URL_PESQUISAR_PJ_PELO_ID;
    }

    public static String getUrlListarPjs() {
        return URL_LISTAR_PJS;
    }



}
