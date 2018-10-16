package com.inovaufrpe.makeparty.dominio;

public class Usuario {
    private String email;
    private String password;


    public Usuario(){}
    public Usuario(String email, String senha){
        setEmail(email);
        setSenha(senha);
    }

    public String getEmail(){

        return this.email;
    }

    public void setEmail(String novoEmail){

        this.email = novoEmail;
    }

    public String getSenha(){
        return this.password;
    }

    public void setSenha(String novaSenha){

        this.password = novaSenha;
    }

}
