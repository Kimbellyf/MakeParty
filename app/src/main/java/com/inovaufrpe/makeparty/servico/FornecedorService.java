package com.inovaufrpe.makeparty.servico;

public class FornecedorService {

    private static final String TAG = "FornecedorService";
    private static final boolean LOG_ON = false;
    private static final String URL_BASE = "https://makepartyserver.herokuapp.com/";
    private static final String URL_ATUALIZAR_PJ = URL_BASE + "advertisers";
    private static final String URL_ATUALIZAR_TOKEN = URL_BASE + "users/refresh-token";
    private static final String URL_AUTENTICAR_USUARIO = URL_BASE + "/users/authenticate";
    private static final String URL_PESQUISAR_PJ_PELO_ID = URL_BASE + "advertisers/:id";
    private static final String URL_LISTAR_PJS = URL_BASE + "advertisers";
    private static final String URL_LISTAR_USUARIOS = URL_BASE +"users";
}
