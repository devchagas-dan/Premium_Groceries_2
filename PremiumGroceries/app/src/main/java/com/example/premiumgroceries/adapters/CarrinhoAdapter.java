package com.example.premiumgroceries.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.premiumgroceries.R;
import com.example.premiumgroceries.models.ProductsModel;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoViewHolder> {

    Context context;

    private List<ProductsModel> itens = new ArrayList<>();

    public void addItem (ProductsModel novositens){
        itens.add(novositens);
        notifyDataSetChanged();
    }
    private AdapterView.OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(ProductsModel itens);
    }
    public CarrinhoAdapter(){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CarrinhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarrinhoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.carrinho_cardview,parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull CarrinhoViewHolder holder, int position) {


        holder.nome.setText(itens.get(position).getNome());
        holder.foto.setImageResource(itens.get(position).getFoto());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(itens);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
