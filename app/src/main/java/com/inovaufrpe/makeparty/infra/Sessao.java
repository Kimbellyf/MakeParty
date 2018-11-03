package com.inovaufrpe.makeparty.infra;

import java.util.HashMap;
import java.util.Map;


public class Sessao {
    public static final Sessao instance = new Sessao();
    private final Map<String, Object> values = new HashMap<>();

    private void setValor(String chave, Object valor) {
        values.put(chave, valor);
    }

    public void setResposta(String resposta) {
        setValor("sessao.resposta", resposta);
    }

    public String getResposta(){
        return (String) values.get("sessao.resposta");
    }

    public void setSession(Object valor) {
        values.put("sessao.Session", valor);
    }

    public SessionApi getSession(){
        return (SessionApi) values.get("sessao.Session");
    }

    public void setMuver(Object valor){
        values.put("sessao.muver", valor);
    }

    //public Forne getMuver(){
        //return (Muver) values.get("sessao.muver");
    //}


}

