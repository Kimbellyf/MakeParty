package com.inovaufrpe.makeparty.dominio;

import java.util.ArrayList;
import java.util.Date;

public class Anuncio {

    private String title;
    private Date dataAd;
    private String description;
    private double price;
    private Endereco address;
    private String phone;
    private String type;
    private String tags;
    private PessoaJuridica socialname;
    private PessoaJuridica owner;
    private String photo;
    //private ArrayList<> photos;                  ARRAYLIST<OBJETO???>

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDataAd() {
        return dataAd;
    }

    public void setDataAd(Date dataAnuncio) {
        this.dataAd = dataAnuncio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Endereco getAddress() {
        return address;
    }

    public void setAddress(Endereco endereco) {
        this.address = endereco;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public PessoaJuridica getSocialname() {
        return socialname;
    }

    public void setSocialname(PessoaJuridica socialname) {
        this.socialname = socialname;
    }

    public PessoaJuridica getOwner() {
        return owner;
    }

    public void setOwner(PessoaJuridica owner) {
        this.owner = owner;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    //public ArrayList getFotos() {
        //return fotos;
    //}

    //public void setFotos(ArrayList fotos) {
        //this.fotos = fotos;
    //}


}
