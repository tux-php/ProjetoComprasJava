package com.br.compras.controller;

public class CartaoCredito extends Cartao{
    private double limite;
    private String bandeira;

    public CartaoCredito(String agencia, String conta ) {
        super(agencia, conta);
    }
    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    public void verificaSaldo(){

    }

}
