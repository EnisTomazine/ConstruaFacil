package devcalc;

import java.util.Scanner;

public class Calc {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args){
        //Exibe o menu da calculadora
        System.out.println(">>>Calculadora<<<<");
        System.out.println(">>>(1) Somar<<<<");
        System.out.println(">>>(2) Subtrair<<<<");
        System.out.println(">>>(3) Multiplicar<<<<");
        System.out.println(">>>(4) Dividir<<<<");
        System.out.println(">>>Escolhao Calculo Desejado<<<<");

        //Recebe a Opção desejada
        int opcao =  entrada.nextInt();

        //Pergunta os valores a serem usado no calculo
        int num1 = 0;
        int num2 = 0;

        if(opcao >=1  && opcao <= 4) {
            System.out.print("Entre com o primeiro numero: ");
            num1 = entrada.nextInt();
            System.out.print("Entre com o segundo numero: ");
            num2 = entrada.nextInt();
            System.out.print("O resultado é: ");
        }

        //Chama a função desejada
        switch (opcao){
            case 1:
                System.out.println(somarDoisNumeros(num1, num2));
                break;
            case 2:
                System.out.println(subtrairDoisNumeros(num1, num2));
                break;
            case 3:
                System.out.println(multiplicarDoisNumeros(num1, num2));
                break;
            case 4:

                if(opcao == 4 && num2 == 0){
                    System.out.println("O divisor não pode ser zero! Informe um numero diferente de zero");
                } else {
                    System.out.println(dividirDoisNumeros(num1, num2));
                }

                //System.out.println(dividirDoisNumeros(num1, num2));
                break;
            default:
                System.out.println("Opcao Invalida");
        }

    }

    public static int somarDoisNumeros(int num1, int num2){
        return (num1 + num2);
    }

    public static int subtrairDoisNumeros(int num1, int num2){
        return (num1 - num2);
    }

    public static int dividirDoisNumeros(int num1, int num2){
        if (num2 == 0) {
            return 0;
        }else {
            return (num1 / num2);
        }
    }
    public static int multiplicarDoisNumeros(int num1, int num2){
        return (num1 * num2);
    }


}
