import java.util.Scanner;

public class Questao02 {

	public static void main(String[] args) {
		System.out.println("Digite uma senha para ser validada:");

		Scanner entrada = new Scanner(System.in);
		String senha = entrada.next();

		Questao02 questao02 = new Questao02();

		System.out.println("Para a sua senha ser segura falta essa quantidade de caracteres:");
		System.out.println(questao02.quantoFaltaParaSerSeguro(senha));

		entrada.close();
	}

	public int quantoFaltaParaSerSeguro(String senha) {
		int tamanho = quantoFaltaDeTamanho(senha);
		boolean digito = temDigito(senha);
		boolean minusculo = temMinusculo(senha);
		boolean maiusculo = temMaiusculo(senha);
		boolean caractereEspecial = temCaractereEspecial(senha);

		if (tamanho == 0 && digito && minusculo && maiusculo && caractereEspecial) {
			return 0;
		} else {
			int cont = 0;

			if (!digito) {
				cont++;
			}

			if (!minusculo) {
				cont++;
			}

			if (!maiusculo) {
				cont++;
			}

			if (!caractereEspecial) {
				cont++;
			}

			if (tamanho < cont) {
				return cont;
			} else {
				return tamanho;
			}
		}
	}

	public int quantoFaltaDeTamanho(String senha) {
		return (senha.length() >= 6) ? 0 : (6 - senha.length());
	}

	public boolean temDigito(String senha) {
		return senha.matches(".*\\d.*");
	}

	public boolean temMinusculo(String senha) {
		return senha.matches(".*[a-z].*");
	}

	public boolean temMaiusculo(String senha) {
		return senha.matches(".*[A-Z].*");
	}

	public boolean temCaractereEspecial(String senha) {
		return senha.matches(".*[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\+].*");
	}
}
