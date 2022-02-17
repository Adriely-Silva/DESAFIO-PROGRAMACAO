import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Questao03 {

	public static void main(String[] args) {
		System.out.println("Digite uma palavra:");

		Scanner entrada = new Scanner(System.in);
		String palavra = entrada.next();
		
		Questao03 questao03 = new Questao03();
		System.out.println("A quantidade de anagramas existentes dentro da palavra são:");
		System.out.println(questao03.quantasLetrasRepetidas(palavra));
	
		entrada.close();
	}

	public boolean temAnagrama(String palavra1, String palavra2) {
		char[] letras1 = palavra1.toCharArray();
		char[] letras2 = palavra2.toCharArray();

		Arrays.sort(letras1);
		Arrays.sort(letras2);

		return Arrays.equals(letras1, letras2);
	}
	
	public int quantidadeAnagrama(String palavra, String expressao) {
        int tamanhoPalavra = palavra.length();
        int tamanhoExpressao = expressao.length();
        int cont = 0;

        for (int i = 0; i <= tamanhoPalavra - tamanhoExpressao; i++) {
            String partePalavra = palavra.substring(i, i + tamanhoExpressao);
            if (temAnagrama(expressao, partePalavra)) {
            	cont++;
            }
        }

        return cont;
    }
	
	public int quantasLetrasRepetidas(String palavra) {
		int tamanhoPalavra = palavra.length();
		char[] letras = palavra.toCharArray();
		String expressao = "";
		int cont = 0;
		Set<String> anagramas = new HashSet<String>();

		for (int i = 0;i < tamanhoPalavra;i++) {
			for (int j = 0; j < tamanhoPalavra-i;j++) {
				expressao = String.copyValueOf(letras, i, j+1);

				cont = quantidadeAnagrama(palavra, expressao);
				if (cont > 1) {
					char[] letrasExpressao = expressao.toCharArray();
					Arrays.sort(letrasExpressao);
					anagramas.add(String.copyValueOf(letrasExpressao));
				}
			}
		}
		
		return anagramas.size();
	}
}
