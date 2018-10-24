package com.inovaufrpe.makeparty.dominio;

import java.util.Date;

public class PessoaFisica {

    private String name;
    private String cpf;
    private String birthdate;
    private String phone;
    private Usuario user;
    //private Byte photo;
    //private String photo;

    public PessoaFisica(Usuario user,String name, String cpf, String birthdate, String phone) {
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
        this.phone = phone;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    //public String getPhoto() {
      //  return photo;
    //}

    //public void setPhoto(String photo) {
      //  this.photo = photo;
    //}



}
