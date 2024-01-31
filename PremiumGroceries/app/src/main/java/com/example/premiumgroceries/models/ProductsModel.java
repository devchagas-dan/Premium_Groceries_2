package com.example.premiumgroceries.models;

public class ProductsModel {
    String nome;
    int foto;

    public ProductsModel(String nome, int foto) {
        this.nome = nome;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void add(ProductsModel itens) {
    }
}
