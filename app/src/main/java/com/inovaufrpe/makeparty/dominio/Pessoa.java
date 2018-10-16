package com.inovaufrpe.makeparty.dominio;

import java.util.Date;

public class Pessoa {
    private long id;
    private String nome;
    private Usuario usuario;
    private byte[] fotoPessoa;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getFotoPessoa() {
        return fotoPessoa;
    }

    public void setFotoPessoa(byte[] fotoPessoa) {
        this.fotoPessoa = fotoPessoa;
    }


}
