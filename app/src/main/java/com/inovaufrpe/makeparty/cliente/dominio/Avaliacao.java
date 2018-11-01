package com.inovaufrpe.makeparty.cliente.dominio;

import com.inovaufrpe.makeparty.fornecedor.dominio.Anuncio;

import java.util.Date;

public class Avaliacao {

    private PessoaFisica socialname;
    private Anuncio ad;
    private String descriptionComment;
    private Double ratingUser;
    private Date dateComment;

    public PessoaFisica getSocialname() {
        return socialname;
    }

    public void setSocialname(PessoaFisica socialname) {
        this.socialname = socialname;
    }

    public Anuncio getAd() {
        return ad;
    }

    public void setAd(Anuncio ad) {
        this.ad = ad;
    }

    public String getDescriptionComment() {
        return descriptionComment;
    }

    public void setDescriptionComment(String descriptionComment) {
        this.descriptionComment = descriptionComment;
    }

    public Double getRatingUser() {
        return ratingUser;
    }

    public void setRatingUser(Double ratingUser) {
        this.ratingUser = ratingUser;
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }

}
