package com.example.premiumgroceries.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.premiumgroceries.R;

public class CarrinhoViewHolder extends RecyclerView.ViewHolder {
    ImageView foto, somar, subtrair, deletar;
    TextView nome, quantidade;

    public CarrinhoViewHolder(@NonNull View itemView) {
        super(itemView);

        nome = itemView.findViewById(R.id.nomeProduto);
        quantidade = itemView.findViewById(R.id.numero);
        foto = itemView.findViewById(R.id.cardViewCart);
        somar = itemView.findViewById(R.id.plusicon);
        subtrair = itemView.findViewById(R.id.iconminus);
        deletar = itemView.findViewById(R.id.lixeira);

    }
}
