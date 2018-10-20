package com.inovaufrpe.makeparty.servico;

import com.google.gson.Gson;

import java.util.Map;


public class UsuarioService {

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
        String novoJson = criarJson(objeto) ;
        conexaoServidor.execute(novoJson);

    }
    //Metodo que quebra o json e pega a 2 }== token que é preciso para identificar o user nas requisicoes para n ter q ficar pedindo direto o id/token que o identifica
    // eu uso esse metodo , pegando o token e salvando no SharedPreferens
    public String pegandoTokenNoJson(String json){
        Map<String,Object> jsonNodes = gson.fromJson(json, Map.class);
        String resultado = jsonNodes.get("token").toString();
        return resultado;
    }



}