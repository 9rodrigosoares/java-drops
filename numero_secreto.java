import java.util.Random;
import java.util.Scanner;

public class numero_secreto {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        Random random = new Random();


        boolean acertou = false;
        int tentativas = 10, chute = 0;
        int numeroSecreto = random.nextInt(1000);

        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║  Tente acertar o número secreto!   ║");
        System.out.println("║ # O número secreto é de 0 a 1000 # ║");
        System.out.println("║     Você tem 10 tentativas!        ║");
        System.out.println("╚════════════════════════════════════╝");

        while (tentativas > 0 && acertou == false) {

            System.out.println("\nQual seu chute?");
            chute = input.nextInt();

            if (numeroSecreto == chute) {
                System.out.println("Acertou!!!");
                acertou = true;
            }
            if (chute < numeroSecreto && chute >= 0) {
                tentativas--;
                System.out.println("Tente um número MAIOR! " + tentativas + " tentativas restantes.");
            }
            if (chute > numeroSecreto && chute <= 1000) {
                tentativas--;
                System.out.println("Tente um número MENOR! " + tentativas + " tentativas restantes.");
            }
            if (chute < 0 || chute > 1000) {
                System.out.println("#### Digite um valor entre 0 e 1000");
                System.out.println("A tentativa não foi considerada. "+tentativas+" tentativas restantes.");

            } else if (tentativas == 0) {
                System.out.println("\nQue pena!");
                System.out.println("O número secreto era: " + numeroSecreto);
            }
        }
    }
}
