package com.inovaufrpe.makeparty.cliente.dominio;

import com.inovaufrpe.makeparty.fornecedor.dominio.Anuncio;

import java.util.ArrayList;

public class ListaDesejos {

    private ArrayList<Anuncio> ad;
    private PessoaFisica nomesocial;

    public ArrayList<Anuncio> getAd() {
        return ad;
    }

    public void setAd(ArrayList<Anuncio> ad) {
        this.ad = ad;
    }

    public PessoaFisica getNomesocial() {
        return nomesocial;
    }

    public void setNomesocial(PessoaFisica nomesocial) {
        this.nomesocial = nomesocial;
    }







}
