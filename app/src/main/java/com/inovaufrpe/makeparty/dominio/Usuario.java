package com.inovaufrpe.makeparty.dominio;

public class Usuario {

    private String email;
    private String password;


    public Usuario(){}
    public Usuario(String email, String senha){
        setEmail(email);
        setPassword(senha);
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
