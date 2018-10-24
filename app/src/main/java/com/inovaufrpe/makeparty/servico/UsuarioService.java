package com.inovaufrpe.makeparty.servico;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.inovaufrpe.makeparty.dominio.Anuncio;
import com.inovaufrpe.makeparty.utils.bibliotecalivroandroid.utils.HttpHelper;

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
    private static final boolean LOG_ON = false;
    private static final String URL_BASE = "https://makepartyserver.herokuapp.com/";

    //URLS com cadastro, autenticar e atualizar token == POST
    private static final String URL_CRIAR_USUARIO = URL_BASE + "users";
    private static final String URL_CADASTRAR_PF = URL_BASE + "users/signup/customer";
    private static final String URL_CADASTRO_PJ = URL_BASE + "users/signup/advertiser";
    private static final String URL_AUTENTICAR_USUARIO = URL_BASE + "/users/authenticate";
    private static final String URL_ATUALIZAR_TOKEN = URL_BASE + "users/refresh-token";

    // Os que possuem url somente URLBASE + "customers" ou "advertisers" podem ser usados PUT,DELETE E GET
    private static final String URL_ATUALIZAR_PF = URL_BASE + "customers";
    private static final String URL_ATUALIZAR_PJ = URL_BASE + "advertisers";

    //POST, PUT, DELETE E GET
    private static final String URL_COLOCAR_ANUNCIO = URL_BASE + "ads";
    private static final String URL_LISTAR_ANUNCIOS = URL_BASE + "ads";

    //GET ANÚNCIOS
    private  static final String URL_LISTAR_ANUNCIOS_PELA_TAG = URL_BASE + "tags/:tag";
    private  static final String URL_LISTAR_ANUNCIOS_PELO_TIPO = URL_BASE + "/types/:type";

    //GET
    private static final String URL_LISTAR_USUARIOS = URL_BASE +"users";
    private static final String URL_PESQUISAR_PF_PELO_ID = URL_BASE + "customers/:id";
    private static final String URL_PESQUISAR_PJ_PELO_ID = URL_BASE + "advertisers/:id";
    private static final String URL_LISTAR_PJS = URL_BASE + "advertisers";





    private static final String ROTALOGAR = URL_BASE + "auth/login";
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

}