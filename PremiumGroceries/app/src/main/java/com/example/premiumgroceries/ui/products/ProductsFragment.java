package com.example.premiumgroceries.ui.products;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.premiumgroceries.R;
import com.example.premiumgroceries.adapters.ProdutosAdapter;
import com.example.premiumgroceries.models.ProductsModel;

import java.util.ArrayList;
import java.util.List;

public class ProductsFragment extends Fragment {

    public ProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("ProductsFragment", "onCreateView: Inflando layout");
        View view = inflater.inflate(R.layout.fragment_produto, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.produtosRecyclerView);

        List<ProductsModel> itens = new ArrayList<>();
        itens.add(new ProductsModel("água", R.drawable.agua));
        itens.add(new ProductsModel("água sanitária", R.drawable.agua_sanitaria));
        itens.add(new ProductsModel("batata Inglesa", R.drawable.batata));
        itens.add(new ProductsModel("berinjela", R.drawable.berinjela));
        itens.add(new ProductsModel("beterraba", R.drawable.beterraba));
        itens.add(new ProductsModel("blueberry", R.drawable.blueberry));
        itens.add(new ProductsModel("bolacha", R.drawable.bolacha));
        itens.add(new ProductsModel("café", R.drawable.cafe));
        itens.add(new ProductsModel("carne", R.drawable.carne));
        itens.add(new ProductsModel("cebola", R.drawable.cebola));
        itens.add(new ProductsModel("cenoura", R.drawable.cenoura));
        itens.add(new ProductsModel("cerveja", R.drawable.cerveja));
        itens.add(new ProductsModel("cotonete", R.drawable.cotonete));
        itens.add(new ProductsModel("detergente", R.drawable.detergente));
        itens.add(new ProductsModel("esfregão", R.drawable.esfregao));
        itens.add(new ProductsModel("farinha", R.drawable.farinha));
        itens.add(new ProductsModel("leite", R.drawable.leite));
        itens.add(new ProductsModel("macarrão", R.drawable.macarrao));
        itens.add(new ProductsModel("manteiga de amendoim", R.drawable.manteiga_amendoim));
        itens.add(new ProductsModel("morango", R.drawable.morango));
        itens.add(new ProductsModel("refrigerante", R.drawable.refri));
        itens.add(new ProductsModel("shampoo", R.drawable.shampoo));
        itens.add(new ProductsModel("sorvete", R.drawable.sorvete));
        itens.add(new ProductsModel("suco", R.drawable.suco));
        itens.add(new ProductsModel("tomate", R.drawable.tomate));
        itens.add(new ProductsModel("yogurte", R.drawable.yogurt));

        Log.d("ProductsFragment", "onCreateView: Criando adapter");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new ProdutosAdapter(getActivity(), itens));

        Log.d("ProductsFragment", "onCreateView: Retornando layout");
        return view;

    }
}
