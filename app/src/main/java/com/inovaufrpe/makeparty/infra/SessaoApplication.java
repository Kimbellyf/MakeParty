package com.inovaufrpe.makeparty.infra;

import android.app.Application;
import android.util.Log;

import com.inovaufrpe.makeparty.usuario.dominio.Usuario;
import com.squareup.otto.Bus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SessaoApplication extends Application {

    private static final String TAG = " SessaoApplication";
    public static SessaoApplication instance = null;
    private final Map<String, Object> values = new HashMap<>();
    private Bus bus = new Bus();
    private String tipoDeUserLogado;
    private String token;
    private String _id;
    private Usuario user;
    private Date horaRecebidoToken;

    public static SessaoApplication getInstance() {
        return instance; // Singleton
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, " SessaoApplication.onCreate()");
        // Salva a instância para termos acesso como Singleton
        instance = this;
    }

    private void setValor(String chave, Object valor) {
        values.put(chave, valor);
    }

    public void setResposta(String resposta) {
        setValor("sessao.resposta", resposta);
    }

    public String getResposta(){
        return (String) values.get("sessao.resposta");
    }

    public String getTipoDeUserLogado(){
        return tipoDeUserLogado;
    }
    public void setTipoDeUserLogado(String tipoDeUserLogado) {
        this.tipoDeUserLogado = tipoDeUserLogado;
    }

    public String get_id_user() {
        return _id;
    }

    public void set_id_user(String _id) {
        this._id = _id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getTokenUser() {
        return token;
    }

    public void setTokenUser(String token) {
        this.token = token;
    }

    public void setHoraRecebidoToken(Date horaRecebidoToken){
        this.horaRecebidoToken = horaRecebidoToken;
    }
    public Date getHoraRecebidoToken() {
        return horaRecebidoToken;
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, " SessaoApplication.onTerminate()");
    }

    public Bus getBus() {
        return bus;
    }


}
