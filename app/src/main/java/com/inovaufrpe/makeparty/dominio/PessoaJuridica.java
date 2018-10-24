package com.inovaufrpe.makeparty.dominio;

public class PessoaJuridica {

    private String socialname;
    private String cnpj;
    private String authorization;
    private String photo;
    //private Byte photo;
    private Usuario user;
    private String phone;
    private Plano plan;
    private Agenda schedule;


    public PessoaJuridica() {
    }
    public PessoaJuridica(Usuario user, String socialname, String cnpj, String phone) {
        this.socialname = socialname;
        this.cnpj = cnpj;
        this.user = user;
        this.phone = phone;
    }

    public String getSocialname() {
        return socialname;
    }

    public void setSocialname(String socialname) {
        this.socialname = socialname;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Plano getPlan() {
        return plan;
    }

    public void setPlan(Plano plan) {
        this.plan = plan;
    }

    public Agenda getSchedule() {
        return schedule;
    }

    public void setSchedule(Agenda schedule) {
        this.schedule = schedule;
    }


}

