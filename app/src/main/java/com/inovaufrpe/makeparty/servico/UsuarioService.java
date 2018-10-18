package com.inovaufrpe.makeparty.servico;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UsuarioService {

    private static final String URL_BASE = "https://makepartyserver.herokuapp.com/";
    private static final String CRIAR_USUARIO = URL_BASE + "users";
    private static final String AUTENTICAR_USUARIO = URL_BASE + "users/authenticate";
    private static final String ATUALIZAR_TOKEN = URL_BASE + "users/refresh-token";
    private static final String METODO_GET = "GET";
    private static final String METODO_POST = "POST";
    private static final String METODO_PUT = "PUT";
    private static final String METODO_DELETAR = "DELETE";
    private Gson gson = new Gson();
    private String respostaServidor;


    public UsuarioService() {
    }

    public static String getCriarUsuario() {
        return CRIAR_USUARIO;
    }

    public static String getAutenticarUsuario() {
        return AUTENTICAR_USUARIO;
    }

    public static String getAtualizarToken() {
        return ATUALIZAR_TOKEN;
    }

    public String getRespostaServidor() {
        return respostaServidor;
    }

    public void setRespostaServidor(String respostaServidor) {
        this.respostaServidor = respostaServidor;
    }

    public String criarJsonObjeto(Object objeto) {
        return gson.toJson(objeto);
    }


    public void criarUsuario(String nome, String email, String senha, ConexaoServidor conexaoServidor) {
        String jsonName = criarJsonObjeto(nome);
        String jsonEmail = criarJsonObjeto(email);
        String jsonPassword = criarJsonObjeto(senha);
        String novoJson = jsonName + jsonEmail + jsonPassword ;
        conexaoServidor.execute(novoJson, CRIAR_USUARIO, METODO_POST);


    }
}