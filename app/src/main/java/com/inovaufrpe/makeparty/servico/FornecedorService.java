package com.inovaufrpe.makeparty.servico;

import com.google.gson.Gson;

import java.util.Map;

public class FornecedorService {

    private static final String TAG = "FornecedorService";
    private static final boolean LOG_ON = false;
    private static final String URL_BASE = "https://makepartyserver.herokuapp.com/";
    private static final String URL_CADASTRO_PJ = URL_BASE + "users/signup/advertiser";
    private static final String URL_ATUALIZAR_PJ = URL_BASE + "advertisers";
    private static final String URL_ATUALIZAR_TOKEN = URL_BASE + "users/refresh-token";
    private static final String URL_AUTENTICAR_USUARIO = URL_BASE + "/users/authenticate";
    private static final String URL_PESQUISAR_PJ_PELO_ID = URL_BASE + "advertisers/:id";
    private static final String URL_LISTAR_PJS = URL_BASE + "advertisers";
    private static final String URL_LISTAR_USUARIOS = URL_BASE +"users";
    private Gson gson = new Gson();
    private String respostaServidor;
    private ConexaoServidor conexaoServidor = new ConexaoServidor();

    public FornecedorService() {
    } //CONSTRUTOR

    //converte um objeto para json
    public String criarJson(Object objeto) {
        return gson.toJson(objeto);
    }

    //método que usa a requisição http implementada em conexaoServidor para criar usuário
    public void criarFornecedor(Object objeto) {
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

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public static String getUrlAtualizarToken() {
        return URL_ATUALIZAR_TOKEN;
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

    public static String getUrlCadastroPj() {
        return URL_CADASTRO_PJ;
    }

    public static String getUrlAtualizarPj() {
        return URL_ATUALIZAR_PJ;
    }

    public static String getUrlAutenticarUsuario() {
        return URL_AUTENTICAR_USUARIO;
    }

    public static String getUrlPesquisarPjPeloId() {
        return URL_PESQUISAR_PJ_PELO_ID;
    }

    public static String getUrlListarPjs() {
        return URL_LISTAR_PJS;
    }

    public static String getUrlListarUsuarios() {
        return URL_LISTAR_USUARIOS;
    }
}
