package com.inovaufrpe.makeparty.dominio;

public class Fornecedor {
    private Pessoa pessoa;
    private String cnpj;
    private String verifAluguelParaCasaDeFesta;


    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getVerifAluguelParaCasaDeFesta() {
        return verifAluguelParaCasaDeFesta;
    }

    public void setVerifAluguelParaCasaDeFesta(String verifAluguelParaCasaDeFesta) {
        this.verifAluguelParaCasaDeFesta = verifAluguelParaCasaDeFesta;
    }

    public Fornecedor(String cnpj, String verifAluguelParaCasaDeFesta){
        setCnpj(cnpj);
        setVerifAluguelParaCasaDeFesta(verifAluguelParaCasaDeFesta);
    }
}

