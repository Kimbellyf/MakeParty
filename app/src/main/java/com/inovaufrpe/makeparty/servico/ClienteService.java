package com.inovaufrpe.makeparty.servico;

import com.google.gson.Gson;
import com.inovaufrpe.makeparty.dominio.PessoaFisica;

import java.util.Map;

public class ClienteService {

    private static final String TAG = "ClienteService";
    private static final boolean LOG_ON = false;
    private static final String URL_BASE = "https://makepartyserver.herokuapp.com/";
    private static final String URL_CADASTRAR_PF = URL_BASE + "users/signup/customer";
    private static final String URL_ATUALIZAR_PF = URL_BASE + "customers";
    private static final String URL_ATUALIZAR_TOKEN = URL_BASE + "users/refresh-token";
    private static final String URL_AUTENTICAR_USUARIO = URL_BASE + "/users/authenticate";
    private static final String URL_PESQUISAR_PF_PELO_ID = URL_BASE + "customers/:id";
    private static final String URL_LISTAR_USUARIOS = URL_BASE +"users";
    private Gson gson = new Gson();
    private String respostaServidor;
    private ConexaoServidor conexaoServidor = new ConexaoServidor();


    public ClienteService() {
    } //CONSTRUTOR

    //converte um objeto para json
    public String criarJson(Object objeto) {
        return gson.toJson(objeto);
    }

    //converte um json para objeto
    public PessoaFisica criarObjeto(String json) {
        return gson.fromJson(json,PessoaFisica.class);
    }


    //método que usa a requisição http implementada em conexaoServidor para criar usuário
    public void criarCliente(Object objeto) {
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

    public static String getUrlCadastrarPf() {
        return URL_CADASTRAR_PF;
    }

    public static String getUrlAtualizarPf() {
        return URL_ATUALIZAR_PF;
    }

    public static String getUrlAutenticarUsuario() {
        return URL_AUTENTICAR_USUARIO;
    }

    public static String getUrlPesquisarPfPeloId() {
        return URL_PESQUISAR_PF_PELO_ID;
    }

    public static String getUrlListarUsuarios() {
        return URL_LISTAR_USUARIOS;
    }
}
