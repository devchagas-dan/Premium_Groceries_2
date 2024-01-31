package com.example.premiumgroceries.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.premiumgroceries.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView foto;
    TextView nome;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        foto = itemView.findViewById( R.id.cardView);
        nome = itemView.findViewById(R.id.nomeItem);
    }
}
