package com.example.premiumgroceries.ui.carrinho;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.premiumgroceries.R;
import com.example.premiumgroceries.adapters.CarrinhoAdapter;
import com.example.premiumgroceries.adapters.ProdutosAdapter;
import com.example.premiumgroceries.models.ProductsModel;

public class CarrinhoFragment extends Fragment {

    private ProdutosAdapter produtosAdapter;
    private CarrinhoAdapter carrinhoAdapter;

    public CarrinhoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carrinho, container, false);

        produtosAdapter = new ProdutosAdapter(new ProdutosAdapter.OnItemClickListener(){

            public void onItemClick(ProductsModel itens){
                carrinhoAdapter.addItem(itens);

            }
        });

        carrinhoAdapter = new CarrinhoAdapter();
        RecyclerView produtosRecyclerview = view.findViewById(R.id.carrinhoRecyclerView);
        RecyclerView carrinhoRecyclerView = view.findViewById(R.id.carrinhoRecyclerView);

        produtosRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        produtosRecyclerview.setAdapter(produtosAdapter);
        carrinhoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        carrinhoRecyclerView.setAdapter(carrinhoAdapter);

        return view;
    }
}