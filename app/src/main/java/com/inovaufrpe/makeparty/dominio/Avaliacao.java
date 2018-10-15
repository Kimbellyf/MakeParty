package com.inovaufrpe.makeparty.dominio;

import java.util.Date;

public class Avaliacao {
    private Pessoa pessoa;
    private Anuncio anuncio;
    private String descricaoComentario;
    private Double avaliacaoUsuario;
    private Date dataComentario;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(Date dataComentario) {
        this.dataComentario = dataComentario;
    }


    public String getDescricaoComentario() {
        return descricaoComentario;
    }

    public void setDescricaoComentario(String descricaoComentario) {
        this.descricaoComentario = descricaoComentario;
    }

    public Double getAvaliacaoUsuario() {
        return avaliacaoUsuario;
    }

    public void setAvaliacaoUsuario(Double avaliacaoUsuario) {
        this.avaliacaoUsuario = avaliacaoUsuario;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }


}
