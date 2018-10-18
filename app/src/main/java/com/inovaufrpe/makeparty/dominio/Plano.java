package com.inovaufrpe.makeparty.dominio;

class Plano {

    private String tipoDePlano;
    private int numeroAnunciosAtivos;
    private int numeroDeFotos;


    public String getTipoDePlano() {
        return tipoDePlano;
    }

    public void setTipoDePlano(String tipoDePlano) {
        this.tipoDePlano = tipoDePlano;
    }

    public int getNumeroAnunciosAtivos() {
        return numeroAnunciosAtivos;
    }

    public void setNumeroAnunciosAtivos(int numeroAnunciosAtivos) {
        this.numeroAnunciosAtivos = numeroAnunciosAtivos;
    }

    public int getNumeroDeFotos() {
        return numeroDeFotos;
    }

    public void setNumeroDeFotos(int numeroFotos) {
        this.numeroDeFotos = numeroFotos;
    }




}
