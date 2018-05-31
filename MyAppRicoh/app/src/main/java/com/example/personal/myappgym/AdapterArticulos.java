package com.example.personal.myappgym;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterArticulos extends RecyclerView.Adapter <AdapterArticulos.ArticuloViewHolder>{

    public List<Articulo> articulosList;
    public Context context;
    String idioma;

    public AdapterArticulos(List<Articulo> articulosList, Context context) {
        this.articulosList = articulosList;
        this.context = context;
        this.idioma = idioma;
        idioma = context.getResources().getString(R.string.prefijo_idioma);
    }

    @Override
    public ArticuloViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cardview = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_articulo, parent, false);
        AdapterArticulos.ArticuloViewHolder articuloViewHolder = new AdapterArticulos.ArticuloViewHolder(cardview);
        return articuloViewHolder;
    }

    @Override
    public void onBindViewHolder(ArticuloViewHolder holder, int position) {
        holder.Cv_Referencia.setText(articulosList.get(position).getReferencia());

        if(idioma.equals("es")){
            holder.Cv_Descripcion.setText(articulosList.get(position).getDescripcion_es());
        }else {
            holder.Cv_Descripcion.setText(articulosList.get(position).getDescripcion_en());
        }

        CAFData data = CAFData.dataWithContentsOfFile(articulosList.get(position).getUrl());

        if(data != null){
            Bitmap bitmap = data.toImage();
            if(bitmap != null){
                holder.Cv_imagen.setImageBitmap(bitmap);
            }
        }
    }

    @Override
    public int getItemCount() {
        return articulosList.size();
    }

    public class ArticuloViewHolder extends RecyclerView.ViewHolder {
        ImageView Cv_imagen;
        TextView Cv_Referencia;
        TextView Cv_Descripcion;
        public ArticuloViewHolder(View item) {
            super(item);
            Cv_imagen = (ImageView) item.findViewById(R.id.Cv_imagen);
            Cv_Referencia = (TextView) item.findViewById(R.id.Cv_Referencia);
            Cv_Descripcion = (TextView) item.findViewById(R.id.Cv_Descripcion);
        }
    }
}
