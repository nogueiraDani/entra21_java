package vetores.aula_01_04_25.desafios;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {

		// Com o objetivo de determinar o índice de afinidade entre um rapaz e uma moça
		// cada um
		// respondeu um questionário com 5 perguntas:
		// - Gosta de música sertaneja?
		// - Gosta de futebol?
		// - Gosta de seriados?
		// - Gosta de redes sociais?
		// - Gosta da Oktoberfest?
		// A resposta a cada pergunta pode ser: SIM, NÃO ou IND (indiferente). O índice
		// de afinidade é
		// medido da seguinte maneira:
		// - se ambos deram a mesma resposta soma-se 3 pontos ao índice;
		// - se um respondeu IND e o outro SIM ou NÃO soma-se 1;
		// - se um respondeu SIM e o outro NÃO subtrai-se 2 ao índice.
		// Crie um vetor para armazenar as respostas do rapaz e outro para armazenar as
		// respostas
		// da moça. Por fim, escreva a afinidade considerando os seguintes intervalos:
		// | Afinidade | Mensagem |
		// |-----------|-----------------------------------|
		// | 15 | “Casem! |
		// | 10 a 14 | “Vocês têm muita coisa em comum!” |
		// | 5 a 9 | “Talvez não dê certo :(” |
		// | 0 a 4 | “Vale um encontro.” |
		// | -1 a -9 | “Melhor não perder tempo” |
		// | -10 | “Vocês se odeiam!” |

		Scanner scanner = new Scanner(System.in);

		String perguntas[] = { "Gosta de música sertaneja?", "Gosta de futebol?", "Gosta de seriados?",
				"Gosta de redes sociais?", "Gosta de Oktoberfest?" };
		String respostasRapaz[] = new String[5];
		String respostasMoca[] = new String[5];
		boolean questionarioRapazRespondido = false;
		boolean questionarioMocaRespondido = false;

		int indiceAfinidade = 0;
		int opcaoMenu = 0;
		
		System.out.printf("""
				----------------------------------------				
				---- Bem vindo ao app da afinidade: ----
				----------------------------------------
					""");

		// mostrando menu principal
		while (opcaoMenu == 0) {
			System.out.printf("""
					--------------- Menu -------------------
					1 - Responder questionario:-------------
					2 - Mostrar resultado:------------------
					3 - Sair:-------------------------------
					""");
			opcaoMenu = scanner.nextInt();

			// mostrando menu da opçcao de responder questionario
			while (opcaoMenu == 1) {
				// pergunta o sexo
				System.out.println("Vamos lá, primeiro digite o seu genero: F ou M");
				String opcaoGenero = scanner.next();
				// entra no questionario feminino
				if (opcaoGenero.equalsIgnoreCase("f")) {
					// valida se o questionario já nao foi preenchido antes.
					if (!questionarioMocaRespondido) {

						System.out.printf("""
								A seguir você respondera algumas perguntas, 
								as respostas devem estar entre as opçoes:
								----------------------------------------
								-- Sim ---------------------------------
								-- Não ---------------------------------
								-- Indiferente -------------------------
								----------------------------------------
								""");
						for (int i = 0; i < respostasMoca.length; i++) {
							System.out.println(perguntas[i]);
							String resposta = scanner.next();
							respostasMoca[i] = resposta.toLowerCase();
							if (!(resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("não")
									|| resposta.equalsIgnoreCase("nao") || resposta.equalsIgnoreCase("indiferente"))) {
								System.out.printf(
										"A resposta --> %s está fora das opçoes existentes, digite novamente:\n",
										resposta);
								i--;
							}
							questionarioMocaRespondido = true;
						}
						// mostra as opççoes caso o questionario da moca já foi preenchido
					} else {
						System.out.printf("""
								O questionario da moca já foi respondido.
								----------------------------------------
								Digite o que deseja fazer:--------------
								1 - Responder questionario:-------------
								2 - Mostrar resultado:------------------
								3 - Sair:-------------------------------
								""");
						opcaoMenu = scanner.nextInt();
						continue;
					}
					// entra no questionario masculino
				} else if (opcaoGenero.equalsIgnoreCase("m")) {
					// valida se o questionario já nao foi preenchido antes.
					if (!questionarioRapazRespondido) {
						System.out.printf("""
								A seguir você respondera algumas perguntas, 
								as respostas devem estar entre as opçoes:
								----------------------------------------
								-- Sim ---------------------------------
								-- Não ---------------------------------
								-- Indiferente -------------------------
								----------------------------------------
								""");
						for (int i = 0; i < respostasMoca.length; i++) {
							System.out.println(perguntas[i]);
							String resposta = scanner.next();
							respostasRapaz[i] = resposta.toLowerCase();
							if (!(resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("não")
									|| resposta.equalsIgnoreCase("nao") || resposta.equalsIgnoreCase("indiferente"))) {
								System.out.printf(
										"A resposta --> %s está fora das opçoes existentes, digite novamente:\n",
										resposta);
								i--;
							}
							questionarioRapazRespondido = true;
						}
						// mostra as opççoes caso o questionario da moca já foi preenchido
					} else {
						System.out.printf("""
								O questionario da moca já foi respondido.
								----------------------------------------
								Digite o que deseja fazer:--------------
								1 - Responder questionario:-------------
								2 - Mostrar resultado:------------------
								3 - Sair:-------------------------------
								""");
						opcaoMenu = scanner.nextInt();
						continue;
					}
				} else {
					System.out.println("Valor para o genero inválido, digite F ou M");
				}

				if (questionarioMocaRespondido && questionarioRapazRespondido) {
					opcaoMenu = 0;
				}
			}

			if (opcaoMenu == 2) {
								
				for (int i = 0; i < respostasMoca.length; i++) {
					if(respostasMoca[i].equals(respostasRapaz[i])) {
						indiceAfinidade +=3;
					} else if(respostasMoca[i].equals("sim") && (respostasRapaz[i].equals("não") || respostasRapaz[i].equals("nao"))){
						indiceAfinidade -=2;
					} else {
						indiceAfinidade +=1;
					}
				}
			
				System.out.printf("""
						|-----------|-----------------------------------|
						| Afinidade | Mensagem -------------------------|
						| 15 ------ | Casem ----------------------------|
						| 10 a 14 - | Vocês têm muita coisa em comum! --|
						| 5 a 9 --- | Talvez não dê certo :( -----------|
						| 0 a 4 --- | Vale um encontro. ----------------|
						| -1 a -9 - | Melhor não perder tempo ----------|
						| -10 ----- | Vocês se odeiam! -----------------|
						|-----------|-----------------------------------|\n
						""");
				System.out.printf("Baseado na tabela abaixo, vocês tem -- %d -- pontos de afinidade.\n", indiceAfinidade);
				System.out.printf("""
						Queres fazer o questionario novamente?
						1 - sim ------------------------------
						2 - não ------------------------------
						""");
				System.out.println("");
				System.out.println("");
				int opcaoFinal = scanner.nextInt();
				if(opcaoFinal == 1) {
					opcaoMenu = 0;
				} else if(opcaoFinal == 2) {
					opcaoMenu = 3;
				} else {
					System.out.printf("""
							Valor incorreto.
							Queres fazer o questionario novamente?
							1 - sim ------------------------------
							2 - não ------------------------------
							""");
					opcaoFinal = scanner.nextInt();
				}
			}

			if (opcaoMenu == 3) {
				System.out.println("Fim.");
				break;
			}

		}

		scanner.close();
	}

}
