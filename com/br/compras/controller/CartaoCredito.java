package com.br.compras.controller;

import java.util.ArrayList;
import java.util.List;

public class CartaoCredito extends Cartao{
    private double limite;
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    private String bandeira;

    private List<Produto> compras;

    public List<Produto> getCompras() {
        return compras;
    }

    public CartaoCredito(String agencia, String conta, double limite ) {
        super(agencia, conta);
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();

    }
    public String getBandeira() {
        return bandeira;
    }


    public double getLimite() {
        return limite;
    }

    public boolean lancaCompra(Produto compra){
        if(getSaldo() > compra.getValor()){
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            return true;
        }
        return false;
    }

}
