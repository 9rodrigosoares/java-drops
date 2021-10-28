package Testes;

import java.util.Scanner;

public class descubra_seu_signo {
    public static void main(String[] args) {

        int dia, mes;

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o dia que você nasceu");
        dia=input.nextInt();

        if (dia <= 0 || dia >= 32) {
            System.out.println("Digite um dia válido");
            return;
        }

        System.out.println("Digite o mês que você nasceu");
        mes=input.nextInt();

        switch (mes) {

            case 1:
                if (dia >= 1 && dia <= 20)
                    System.out.println("Capricornio");
                else if (dia >= 21 && dia <= 31)
                    System.out.println("Aquário");
                break;

            case 2:
                if (dia >= 1 && dia <= 18)
                    System.out.println("Aquário");
                else if (dia >= 19 && dia <= 28)
                    System.out.println("Peixes");
                else if (dia >= 29)
                    System.out.println("Digite um dia válido");
                break;

            case 3:
                if (dia >= 1 && dia <= 20)
                    System.out.println("Peixes");
                else if (dia >= 21 && dia <= 31)
                    System.out.println("Áries");
                break;

            case 4:
                if (dia >= 1 && dia <= 20)
                    System.out.println("Áries");
                else if (dia >= 21 && dia < 31)
                    System.out.println("Touro");
                break;

            case 5:
                if (dia >= 1 && dia <= 20)
                    System.out.println("Touro");
                else if (dia >= 21 && dia <= 31)
                    System.out.println("Gêmeos");
                break;

            case 6:
                if (dia >= 1 && dia <= 20)
                    System.out.println("Gêmeos");
                else if (dia >= 21 && dia < 31)
                    System.out.println("Câncer");
                break;

            case 7:
                if (dia >= 1 && dia <= 22)
                    System.out.println("Câncer");
                else if (dia >= 23 && dia <= 31)
                    System.out.println("Leão");
                break;

            case 8:
                if (dia >= 1 && dia <= 22)
                    System.out.println("Leão");
                else if (dia >= 23 && dia <= 31)
                    System.out.println("Virgem");
                break;

            case 9:
                if (dia >= 1 && dia <= 22)
                    System.out.println("Virgem");
                else if (dia >= 23 && dia < 31)
                    System.out.println("Libra");
                break;

            case 10:
                if (dia >= 1 && dia <= 22)
                    System.out.println("Libra");
                else if (dia >= 23 && dia <= 31)
                    System.out.println("Escorpião");
                break;

            case 11:
                if (dia >= 1 && dia <= 21)
                    System.out.println("Escorpião");
                else if (dia >= 22 && dia < 31)
                    System.out.println("Sagitário");
                break;

            case 12:
                if (dia >= 1 && dia <= 21)
                    System.out.println("Sagitário");
                else if (dia >= 22 && dia <= 31)
                    System.out.println("Capricórnio");
                break;

            default:
                System.out.println("Digite um mês válido");
                break;
            }

        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
            System.out.println("Digite um dia válido");
        }
    }
}
