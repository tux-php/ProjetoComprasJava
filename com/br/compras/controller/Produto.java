package com.br.compras.controller;

public class Produto implements Comparable<Produto> {
    private String descricao;
    private double valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
