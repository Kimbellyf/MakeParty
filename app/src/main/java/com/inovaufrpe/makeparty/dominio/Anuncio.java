package com.inovaufrpe.makeparty.dominio;

import java.util.Date;

public class Anuncio {
    private long id;
    private String titulo;
    private Date dataPublicao;
    private String descricao;
    private double preco;
    private String endereco;
    private String telefone;
    private String tipoDeAnuncio;
    private PessoaJuridica pessoaJuridica;
    private byte[] fotoPrincipal;

    public byte[] getFotoPrincipal() {
        return fotoPrincipal;
    }

    public void setFotoPrincipal(byte[] fotoPrincipal) {
        this.fotoPrincipal = fotoPrincipal;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataPublicao() {
        return dataPublicao;
    }

    public void setDataPublicao(Date dataPublicao) {
        this.dataPublicao = dataPublicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoDeAnuncio() {
        return tipoDeAnuncio;
    }

    public void setTipoDeAnuncio(String tipoDeAnuncio) {
        this.tipoDeAnuncio = tipoDeAnuncio;
    }



}
