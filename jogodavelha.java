package Testes;

import java.util.Scanner;

public class jogodavelha {

    public static int lerLinha() {
        Scanner input = new Scanner(System.in);
        int linha = 0;

        do {
            System.out.print("informe a linha: ");
            linha = input.nextInt();

            if (linha < 0 || linha > 2) {
                System.out.println("Digite uma linha válida");
            }
        } while (linha < 0 || linha > 2);

        return linha;
    }

    public static int lerColuna() {
        Scanner input = new Scanner(System.in);
        int coluna = 0;

        do {
            System.out.print("informe a coluna: ");
            coluna = input.nextInt();

            if (coluna < 0 || coluna > 2) {
                System.out.println("Digite uma coluna válida");
            }

        } while (coluna < 0 || coluna > 2);

        return coluna;
    }

    public static boolean validaPosicao(String[][] m, int linha, int coluna) {
        boolean valido = false;
        if (m[linha][coluna] == " ") {
            valido = true;
        } else {
            System.out.println("Espaço preenchido, escolha outro");
        }
        return valido;
    }

    public static boolean verificaGanhadorHorizontal(String[][] m) {
        boolean ganhou = false;
        int contX = 0, contY = 0;

        for (int i = 0; i < 3; i++) {
            contX = 0;
            contY = 0;
            for (int j = 0; j < 3; j++) {
                if (m[i][j].equals("X")) {
                    contX++;
                    if (contX == 3) {
                        ganhou = true;
                        break;
                    }

                } else if (m[i][j].equals("O")) {
                    contY++;
                    if (contY == 3) {
                        ganhou = true;
                        break;
                    }
                }
            }
        }
        return ganhou;
    }

    public static boolean verificaGanhadorVertical(String[][] m) {
        boolean ganhou = false;
        int contX = 0, contY = 0;

        for (int i = 0; i < 3; i++) {
            contX = 0;
            contY = 0;
            for (int j = 0; j < 3; j++) {
                if (m[j][i].equals("X")) {
                    contX++;
                    if (contX == 3) {
                        ganhou = true;
                        break;
                    }

                } else if (m[j][i].equals("O")) {
                    contY++;
                    if (contY == 3) {
                        ganhou = true;
                        break;
                    }
                }
            }
        }
        return ganhou;
    }

    public static boolean verificaGanhadorDiagonal(String[][] m) {
        boolean ganhou = false;
        int contX = 0, contY = 0;

        for (int i = 0; i < m.length; i++) {
            if (m[i][i].equals("X")) {
                contX++;
                if (contX == 3) {
                    ganhou = true;
                    break;
                } else if (m[i][i].equals("O")) {
                    contY++;
                    if (contY == 3) {
                        ganhou = true;
                        break;
                    }
                }
            }
        }
        return ganhou;
    }

    public static boolean verificaGanhadorDiagonalSecundaria(String[][] m) {
        boolean ganhou = false;
        int contX = 0, contY = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i][m.length - 1 - i].equals("X"))
                contX++;
            if (contX == 3) {
                ganhou = true;
                break;
            } else if (m[i][m.length - 1 - i].equals("O")) {
                contY++;
                if (contY == 3) {
                    ganhou = true;
                    break;
                }
            }
        }
        return ganhou;
    }

    public static boolean verificaEmpate(String[][] m) {
        boolean empate = true;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if (m[i][j].equals(" ")) {
                    empate = false;
                }
            }
        }
        return empate;
    }

    public static void zeraMatriz(String[][] m) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = " ";
            }
        }
    }

    public static void desenhoJogo(String[][] m) {

        for (int i = 0; i < 3; i++) {
            System.out.println(m[i][0] + " | " + m[i][1] + " | " + m[i][2]);
            if (i >= 0 && i <= 1) {
                System.out.println("──────────");
            }
        }
    }

    public static void main(String[] args) {

        int linha, coluna;
        int jogadas = 0;

        String[][] matriz = new String[3][3];

        zeraMatriz(matriz);

        while (!verificaEmpate(matriz)) {

            linha = lerLinha();
            coluna = lerColuna();

            while (!validaPosicao(matriz, linha, coluna)) {
                linha = lerLinha();
                coluna = lerColuna();
            }

            if (jogadas % 2 == 0) {
                matriz[linha][coluna] = "X";
            } else {
                matriz[linha][coluna] = "O";
            }

            desenhoJogo(matriz);

            boolean ganhouVertical = verificaGanhadorVertical(matriz);
            boolean ganhouHorizontal = verificaGanhadorHorizontal(matriz);
            boolean ganhouDiagonal = verificaGanhadorDiagonal(matriz);
            boolean ganhouDiagonalSecundaria = verificaGanhadorDiagonalSecundaria(matriz);

            if (ganhouVertical || ganhouDiagonal || ganhouHorizontal || ganhouDiagonalSecundaria) {
                if (jogadas % 2 == 0) {
                    System.out.println("O jogador 1 ganhou!");
                    break;
                } else {
                    System.out.println("O jogador 2 ganhou!");
                    break;
                }
            }
            jogadas++;
        }

        if (verificaEmpate(matriz)) {
            System.out.println("Empate");
        }
        System.out.println("Fim de jogo");
    }
}
