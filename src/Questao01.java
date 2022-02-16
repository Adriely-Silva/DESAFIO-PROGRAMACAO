import java.util.Scanner;

public class Questao01 {

	public static void main(String[] args) {
		System.out.println("Digite um valor para o tamanho da escada:");

		Scanner entrada = new Scanner(System.in);
		int n = entrada.nextInt();

		Questao01 questao01 = new Questao01();
		questao01.imprimirEscada(n);

		entrada.close();
	}

	public void imprimirEscada(int n) {
		for(int i = 1; i <= n ;i++) {
			for(int j = 1; j <= n ;j++) {
				if (j > (n - i)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
