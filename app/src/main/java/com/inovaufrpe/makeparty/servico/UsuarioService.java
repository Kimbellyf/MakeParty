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

    private Gson gson = new Gson();


    private String respostaServidor;
    private ConexaoServidor conexaoServidor = new ConexaoServidor();


    public UsuarioService() {
    } //CONSTRUTOR
    public static String getTAG() {
        return TAG;
    }

    public static boolean isLogOn() {
        return LOG_ON;
    }

    public static String getUrlBase() {
        return URL_BASE;
    }

    public static String getUrlCadastrarPf() {
        return URL_CADASTRAR_PF;
    }

    public static String getUrlCadastroPj() {
        return URL_CADASTRO_PJ;
    }

    public static String getUrlAtualizarPf() {
        return URL_ATUALIZAR_PF;
    }

    public static String getUrlAtualizarPj() {
        return URL_ATUALIZAR_PJ;
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

    public static String getUrlListarUsuarios() {
        return URL_LISTAR_USUARIOS;
    }

    public static String getUrlPesquisarPfPeloId() {
        return URL_PESQUISAR_PF_PELO_ID;
    }

    public static String getUrlPesquisarPjPeloId() {
        return URL_PESQUISAR_PJ_PELO_ID;
    }

    public static String getUrlListarPjs() {
        return URL_LISTAR_PJS;
    }

    public static String getROTALOGAR() {
        return ROTALOGAR;
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