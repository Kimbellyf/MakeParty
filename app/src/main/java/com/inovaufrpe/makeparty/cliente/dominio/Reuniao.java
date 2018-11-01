package com.inovaufrpe.makeparty.cliente.dominio;

import com.inovaufrpe.makeparty.cliente.dominio.PessoaFisica;
import com.inovaufrpe.makeparty.fornecedor.dominio.PessoaJuridica;

import java.util.Date;

public class Reuniao {

    private PessoaFisica name;
    private PessoaJuridica socialname;
    private Date date;
    private String typeSolicitation;

    public PessoaFisica getName() {
        return name;
    }

    public void setName(PessoaFisica name) {
        this.name = name;
    }

    public PessoaJuridica getSocialname() {
        return socialname;
    }

    public void setSocialname(PessoaJuridica socialname) {
        this.socialname = socialname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTypeSolicitation() {
        return typeSolicitation;
    }

    public void setTypeSolicitation(String typeSolicitation) {
        this.typeSolicitation = typeSolicitation;
    }









}
