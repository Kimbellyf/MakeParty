package com.inovaufrpe.makeparty.testes;

import com.inovaufrpe.makeparty.dominio.Usuario;

public class SessionApi {
    private String token;
    private String _id;
    private Usuario user;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
