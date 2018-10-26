package com.inovaufrpe.makeparty.servico;

public class ClienteService {

    private static final String TAG = "ClienteService";
    private static final boolean LOG_ON = false;
    private static final String URL_BASE = "https://makepartyserver.herokuapp.com/";
    private static final String URL_ATUALIZAR_PF = URL_BASE + "customers";
    private static final String URL_ATUALIZAR_TOKEN = URL_BASE + "users/refresh-token";
    private static final String URL_AUTENTICAR_USUARIO = URL_BASE + "/users/authenticate";
    private static final String URL_PESQUISAR_PF_PELO_ID = URL_BASE + "customers/:id";
    private static final String URL_LISTAR_USUARIOS = URL_BASE +"users";
}
