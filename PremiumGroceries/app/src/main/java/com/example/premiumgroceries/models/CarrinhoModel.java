package com.example.premiumgroceries.models;

public class CarrinhoModel {
    private String nome;
    private int foto, deletar;
    private int quantidade;
    private OnCarrinhoModelChangeListener listener;

    public interface OnCarrinhoModelChangeListener {
        void onQuantidadeChanged();
        void onItemExcluido();
    }

    public CarrinhoModel(String nome, int foto, int deletar, int quantidade) {
        this.nome = nome;
        this.foto = foto;
        this.deletar = deletar;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getFoto() {
        return foto;
    }

    public int getDeletar() {
        return deletar;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void somar_quant() {
        quantidade++;
        if (listener != null) {
            listener.onQuantidadeChanged();
        }
    }
    public void subtrair_quant() {
        if (quantidade > 1) {
            quantidade--;
            if (listener != null) {
                listener.onQuantidadeChanged();
            }
        }
    }
    public void excluir_item() {
        if (listener != null) {
            listener.onItemExcluido();
        }
    }

}
