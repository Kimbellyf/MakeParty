package com.inovaufrpe.makeparty.dominio;

import java.util.ArrayList;
import java.util.Date;

public class Anuncio {

    private String titulo;
    private Date dataAnuncio;
    private String descricao;
    private double preco;
    private String endereco;
    private String telefone;
    private String tipoDeAnuncio;
    private PessoaJuridica pessoaJuridica;
    private byte[] fotoPrincipal;
    private ArrayList fotos;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public Date getDataPublicao() {
        return dataAnuncio;
    }

    public void setDataPublicao(Date dataPublicao) {
        this.dataAnuncio = dataPublicao;
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

    public byte[] getFotoPrincipal() {
        return fotoPrincipal;
    }

    public void setFotoPrincipal(byte[] fotoPrincipal) {
        this.fotoPrincipal = fotoPrincipal;
    }


}
