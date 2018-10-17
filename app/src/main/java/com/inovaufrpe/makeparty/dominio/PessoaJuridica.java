package com.inovaufrpe.makeparty.dominio;

public class PessoaJuridica {

    private String nomePessoaJuridica;
    private String cnpj;
    private String autorizacaoAluguelCasa;
    private byte[] foto;
    private Usuario usuario;
    private Plano plano;
    private String telefone;


    public PessoaJuridica(String cnpj, String autorizacaoAluguelCasa){
        setCnpj(cnpj);
        setVerifAluguelParaCasaDeFesta(autorizacaoAluguelCasa);
    }

    public String getNomePessoaJuridica() {
        return nomePessoaJuridica;
    }

    public void setNomePessoaJuridica(String nomePessoaJuridica) {
        this.nomePessoaJuridica = nomePessoaJuridica;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getVerifAluguelParaCasaDeFesta() {
        return autorizacaoAluguelCasa;
    }

    public void setVerifAluguelParaCasaDeFesta(String verifAluguelParaCasaDeFesta) {
        this.autorizacaoAluguelCasa = verifAluguelParaCasaDeFesta;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



}

