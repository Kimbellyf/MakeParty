package com.inovaufrpe.makeparty.servico;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.inovaufrpe.makeparty.dominio.Anuncio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class UsuarioService {

    private static final String TAG = "UsuarioService";
    private static final String URL_BASE = "https://makepartyserver.herokuapp.com/";
    private static final String URL_CRIAR_USUARIO = URL_BASE + "users";
    private static final String URL_AUTENTICAR_USUARIO = URL_BASE + "users/authenticate";
    private static final String URL_ATUALIZAR_TOKEN = URL_BASE + "users/refresh-token";
    private Gson gson = new Gson();


    private String respostaServidor;
    private ConexaoServidor conexaoServidor = new ConexaoServidor();


    public UsuarioService() {
    } //CONSTRUTOR

    public static String getUrlCriarUsuario() {
        return URL_CRIAR_USUARIO;
    }

    public static String getUrlAutenticarUsuario() {
        return URL_AUTENTICAR_USUARIO;
    }

    public static String getUrlAtualizarToken() {
        return URL_ATUALIZAR_TOKEN;
    }

    public String getRespostaServidor() {
        return respostaServidor;
    }

    public void setRespostaServidor(String respostaServidor) {
        this.respostaServidor = respostaServidor;
    }

    //converte um objeto para json
    public String criarJson(Object objeto) {
        return gson.toJson(objeto);
    }

    //método que usa a requisição http implementada em conexaoServidor para criar usuário
    public void criarUsuario(Object objeto) {
        String novoJson = criarJson(objeto);
        conexaoServidor.execute(novoJson);

    }

    //Metodo que quebra o json e pega a 2 }== token que é preciso para identificar o user nas requisicoes para n ter q ficar pedindo direto o id/token que o identifica
    // eu uso esse metodo , pegando o token e salvando no SharedPreferens
    public String pegandoTokenNoJson(String json) {
        Map<String, Object> jsonNodes = gson.fromJson(json, Map.class);
        String resultado = jsonNodes.get("token").toString();
        return resultado;
    }
    // Faz a requisição HTTP, cria a lista de carros e salva o JSON em arquivo
    /*public static List<Anuncio> getAnunciosFromWebService(Context context, int tipo) throws IOException {
        String tipoString = getTipo(tipo);
        String url = URL.replace("{tipo}", tipoString);
        Log.d(TAG, "URL: " + url);
        HttpHelper http = new HttpHelper();
        String json = http.doGet(url);
        List<Anuncio> anuncios = parserJSON(context, json);
//        salvaArquivoNaMemoriaInterna(context, url, json);
        // Depois de buscar salva os carros
        salvarAnuncios(context, tipo, anuncios);
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
                Anuncio c = new Anuncio();
                // Lê as informações de cada anuncio
                c.nome = jsonAnuncio.optString("nome");
                c.desc = jsonAnuncio.optString("desc");
                c.urlFoto = jsonAnuncio.optString("url_foto");
                c.urlInfo = jsonAnuncio.optString("url_info");
                c.urlVideo = jsonAnuncio.optString("url_video");
                c.latitude = jsonAnuncio.optString("latitude");
                c.longitude = jsonAnuncio.optString("longitude");
                if (LOG_ON) {
                    Log.d(TAG, "Anuncio " + c.nome + " > " + c.urlFoto);
                }
                anuncios.add(c);
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