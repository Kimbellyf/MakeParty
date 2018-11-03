package com.inovaufrpe.makeparty.usuario.dominio;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String _id;
    private String email;
    private String password;


    public Usuario(){}
    public Usuario(String email, String senha){
        setEmail(email);
        setPassword(senha);
    }
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
