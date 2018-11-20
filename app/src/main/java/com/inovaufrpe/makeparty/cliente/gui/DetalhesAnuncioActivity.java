package com.inovaufrpe.makeparty.cliente.gui;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.inovaufrpe.makeparty.R;

public class DetalhesAnuncioActivity extends AppCompatActivity {
    private ViewPager galeriaPhotos;
    private TextView titleAds,nomeFornecedor,adsMediaGeral,descriptionAds,avaliacaoAds,phoneAds;
    private TextView priceAds, adsTags, addressAds;
    private RatingBar ratingMediaTipoAnuncio;
    private Button botaoDispAds;
    private FloatingActionButton floatingAddListaDesejo;
    private FrameLayout containerComentarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_anuncio);
        encontrandoItensViews();
        //setarInfoView();
    }
    public void encontrandoItensViews(){
        this.galeriaPhotos = findViewById(R.id.viewPager);
        this.titleAds = findViewById(R.id.textViewTitleAds);
        this.nomeFornecedor = findViewById(R.id.textViewNomeFornecedor);
        this.floatingAddListaDesejo = findViewById(R.id.floatingButtonAddListDesejo);
        this.adsMediaGeral = findViewById(R.id.textViewAnuncioMediaGeral);
        this.ratingMediaTipoAnuncio = findViewById(R.id.ratingBarMediaTipoAnuncioFornecedor);
        this.descriptionAds = findViewById(R.id.textViewDescription);
        this.avaliacaoAds = findViewById(R.id.textViewAvaliacao);
        this.phoneAds = findViewById(R.id.textViewTelefoneAds);
        this.priceAds = findViewById(R.id.textViewPriceAds);
        this.adsTags = findViewById(R.id.textViewTags);
        this.addressAds = findViewById(R.id.textViewAddressAds);
        this.botaoDispAds = findViewById(R.id.buttonVerifDispAnuncio);
        this.containerComentarios = findViewById(R.id.containerComentariosAnuncio);


    }
    public void setarInfoView(){

    }
    public void onClickVerificarDisponibilidade(View view){

    }
    public void onClickAddDesejo(View view){

    }
    public void avaliarAnuncio(){

    }
}
