package com.inovaufrpe.makeparty.cliente.gui.adapter;


import com.inovaufrpe.makeparty.fornecedor.dominio.Anuncio;

//classe que ficará responsável por guardar se o item Anuncio esta selecionado ou n na Gui, na lista que aparece e qual anuncio é
public class AnuncioView {
    private Anuncio anuncio;
    private Boolean selecionado = false;

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public Boolean getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Boolean selecionado) {
        this.selecionado = selecionado;
    }


}
