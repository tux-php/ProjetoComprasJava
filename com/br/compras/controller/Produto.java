package com.br.compras.controller;

public class Produto implements Comparable<Produto> {
    private String descricao;
    private double valor;

    public Produto(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
    @Override
    public int compareTo(Produto produto) {
        return Double.compare(getValor(),produto.getValor());
    }

    @Override
    public String toString() {
        return getDescricao() + " - " + getValor();
    }
}
