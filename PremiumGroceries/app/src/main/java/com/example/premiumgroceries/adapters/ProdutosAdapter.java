package com.example.premiumgroceries.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.premiumgroceries.R;
import com.example.premiumgroceries.models.ProductsModel;

import java.util.ArrayList;
import java.util.List;

public class ProdutosAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<ProductsModel> itens = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public ProdutosAdapter(Context context, List<ProductsModel> itens) {
        this.context = context;
        this.itens = itens;
    }

    public interface OnItemClickListener {
        void onItemClick(ProductsModel item);
    }
    public ProdutosAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.produto_cardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ProductsModel item = itens.get(position);

        holder.nome.setText(item.getNome());
        holder.foto.setImageResource(item.getFoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
    public void setItens(List<ProductsModel> itens) {
        this.itens = itens;
        notifyDataSetChanged();
    }
}
