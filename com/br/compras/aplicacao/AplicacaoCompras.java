package com.br.compras.aplicacao;

import com.br.compras.controller.CartaoCredito;
import com.br.compras.controller.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AplicacaoCompras {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CartaoCredito cc = new CartaoCredito("2825-8", "7.281-X");
        ArrayList<Produto> carrinhoDeCompras = new ArrayList<>();
        double totalDeCompras = 0;
        double saldoConta = 0;
        int contador = 1;
        boolean sair = false;


        System.out.println("Digite o limite do cartão: ");
        double limite = scan.nextDouble();
        cc.setLimite(limite);

        while (!sair) {

            Produto[] p = new Produto[20];

            System.out.println("Digite a descrição da compra " + contador + " : ");
            String descProduto = scan.next();

            p[contador] = new Produto();
            p[contador].setDescricao(descProduto);

            System.out.println("Digite o valor da compra " + contador + " : ");
            double vl = scan.nextDouble();

            p[contador].setValor(vl);
            totalDeCompras += p[contador].getValor();

            if (cc.getLimite() >= totalDeCompras) {
                carrinhoDeCompras.add(p[contador]);
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                saldoConta = cc.getLimite() - totalDeCompras;
                int flag = scan.nextInt();
                if (flag == 0) {
                    extratoConta(carrinhoDeCompras, saldoConta);
                    sair = true;
                } else if (flag == 1) {
                    contador++;
                } else {
                    System.out.println("Tecla errada.");
                }
            } else {
                System.out.println("Saldo Insuficiente!");
                extratoConta(carrinhoDeCompras, saldoConta);
                sair = true;
            }
        }
    }

    private static void extratoConta(ArrayList<Produto> carrinhoDeCompras, double saldoConta) {
        System.out.println("COMPRAS REALIZADAS:");
        //Collections.sort(carrinhoDeCompras);
        carrinhoDeCompras.sort(Comparator.comparing(Produto::getValor));
        for (Produto compra : carrinhoDeCompras) {
            System.out.println(compra);
        }
        System.out.println("Saldo do cartão: " + saldoConta);
    }
}
