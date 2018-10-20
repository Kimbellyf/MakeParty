package com.inovaufrpe.makeparty.dominio;

import java.util.Date;

public class PessoaFisica {

    private String name;
    private String cpf;
    private Date birthdate;
    private String phone;
    private Usuario user;
    //private String photo;

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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
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
