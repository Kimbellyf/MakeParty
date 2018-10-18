package com.inovaufrpe.makeparty.dominio;

import java.util.Date;

public class Reuniao {

    private PessoaFisica pessoaFisica;
    private PessoaJuridica pessoaJuridica;
    private Date dataReuniao;
    private String tipoDeSolicitacao;



    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public Date getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(Date dataReuniao) {
        this.dataReuniao = dataReuniao;
    }

    public String getTipoDeSolicitacao() {
        return tipoDeSolicitacao;
    }

    public void setTipoDeSolicitacao(String tipoDeSolicitacao) {
        this.tipoDeSolicitacao = tipoDeSolicitacao;
    }







}
