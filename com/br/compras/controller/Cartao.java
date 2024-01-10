package com.br.compras.controller;

public class Cartao {
    private String agencia;
    private String conta;

    public Cartao(String agencia, String conta) {
        this.agencia = agencia;
        this.conta = conta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }
}
