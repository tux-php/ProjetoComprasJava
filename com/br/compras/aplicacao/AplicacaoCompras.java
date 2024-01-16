package com.br.compras.aplicacao;

import com.br.compras.controller.CartaoCredito;
import com.br.compras.controller.Produto;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AplicacaoCompras {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limite = scan.nextDouble();
        CartaoCredito cc = new CartaoCredito("8888-8", "9.999-X", limite);

        double totalDeCompras = 0;
        int contador = 1;
        boolean sair = false;

        while (!sair) {

            Produto[] p = new Produto[20];

            System.out.println("Digite a descrição da compra " + contador + " : ");
            String descProduto = scan.next();

            System.out.println("Digite o valor da compra " + contador + " : ");
            double vl = scan.nextDouble();

            p[contador] = new Produto(descProduto, vl);
            totalDeCompras += p[contador].getValor();

            if (cc.getLimite() >= totalDeCompras) {
                cc.lancaCompra(p[contador]);
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                int flag = scan.nextInt();
                if (flag == 0) {
                    extratoConta(cc);
                    sair = true;
                } else if (flag == 1) {
                    contador++;
                } else {
                    System.out.println("Tecla errada.");
                }
            } else {
                System.out.println("Saldo Insuficiente!");
                extratoConta(cc);
                sair = true;
            }
        }
    }

    private static void extratoConta(CartaoCredito cc) {
        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:");
        //cc.getCompras().sort(Comparator.comparing(Produto::getValor));
        Collections.sort(cc.getCompras());
        for (Produto compras: cc.getCompras()) {
            System.out.println(compras);
        }
        System.out.println("***********************");
        System.out.println("Saldo do cartão: " + cc.getSaldo());
    }
}



