package com.inovaufrpe.makeparty.fornecedor.gui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.cliente.gui.adapter.AnuncioAdapter;
import com.inovaufrpe.makeparty.fornecedor.dominio.Anuncio;

import java.util.List;

public class AnuncioFornecedorAdapter extends RecyclerView.Adapter<AnuncioFornecedorAdapter.AnuncioFornecedorViewHolder> {
    private final List<Anuncio> anuncios;
    private final Context context;
    private final AnuncioOnClickListener onClickListener;

    public AnuncioFornecedorAdapter (Context context, List<Anuncio> anuncios, AnuncioAdapter.AnuncioOnClickListener onClickListener) {
        this.context = context;
        this.anuncios = anuncios;
        this.onClickListener = onClickListener;
    }
    public interface AnuncioOnClickListener{
        void onClickAnuncioFornecedor(AnuncioFornecedorViewHolder holder, int indexAnuncio);
        void onLongClickAnuncioFornecedor(AnuncioFornecedorViewHolder holder, int indexAnuncio);
    }
    @Override
    public AnuncioFornecedorViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_anuncio, viewGroup, false);
        AnuncioFornecedorViewHolder holder = new AnuncioAdapter.AnunciosViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final AnuncioFornecedorViewHolder holder, final int position) {
        Anuncio c = anuncios.get(position);
        holder.title.setText(c.getTitle());
        holder.tDesc.setText(c.getDescription());
        if (onClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClickAnuncioFornecedor(holder, position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onClickListener.onLongClickAnuncioFornecedor(holder, position);
                    return true;
                }
            });
        }
        int corFundo = context.getResources().getColor(c.selected ? R.color.colorBlue : R.color.colorWhite);
        holder.cardView.setCardBackgroundColor(corFundo);
    }
    public static class AnuncioFornecedorViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        public ImageView img;
        public TextView title;
        public TextView tDesc;
        private ProgressBar progress;
        public View view;

        public AnuncioFornecedorViewHolder(View view) {
            super(view);
            this.view = view;
            cardView = view.findViewById(R.id.card_view);
            img = view.findViewById(R.id.img);
            title = view.findViewById(R.id.textViewTitleAnuncio);
            tDesc = view.findViewById(R.id.textViewRazaoSocialFornecedor);
            progress = view.findViewById(R.id.progress);
            cardView = view.findViewById(R.id.card_view);

        }

    }
