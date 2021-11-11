import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Collections;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class RPG {

	
	// DARK LOGICS - THE GREAT CHALLENGE
	public static int contarPontos = 0;
	public static String nomePet = "";

	public static void main(String[] args) throws InterruptedException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Scanner scr = new Scanner(System.in);

		menu(scr);

	}

	public static void menu(Scanner scr) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		String nomePersonagem = "";
		String nomeMago = "";
		
		int opcao;

		do {
			System.out.println("_________________________");
			System.out.println("         MENU          ");
			System.out.println("_________________________");
			System.out.println("\n1 - INSTRUÇÕES \n2 - JOGAR \n3 - CRÉDITOS \n4 - SAIR");

			opcao = scr.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("« Instruções »");
				instrucoes();

				String continuarJogo = scr.next();
				if (continuarJogo.equalsIgnoreCase("s")) {
					menu(scr);
				}
				break;
			case 2:
				System.out.println("\n« Iniciando jogo »\n");
				sinopse();

				nomePersonagem = nomePersonagem(scr, nomePersonagem);
				carregaJogo();

				dialogoInicial(scr, nomePersonagem, opcao);

				break;
			case 3:
				System.out.println("« Créditos »");
				System.out.println(
						"Desenvolvido por: \nDaniel Leite \nEvelyn Santos Rodrigues \nKevin Corumba Alexandre \nMariana Rosa da Silva ®");
				break;
			case 4:
				System.out.println("« Programa Encerrado »");
				break;
			default:
			}
		} while (opcao == 4);
	}

	public static void sinopse() {
		System.out.println(
				"\nGordes é um dos mais bonitos vilarejos do Palácio das almas, fica no alto de uma colina de Luberon na Região de Provence. A área pacata e calma foi tomada pelo Grande Spartakus.\r\n"
						+ "O maior objetivo de Spartakus é causar o caos e tomar o vilarejo para si e transformar em um reino de terror.\r\n"
						+ "Reza a lenda que existe um grande guerreiro destinado a trazer a paz de volta para Gordes. Será você o grande prometido??\r\n"
						+ "");
	}

	public static void instrucoes() {
		System.out.println(
				"\nÉ um jogo de perguntas e respostas baseado no tema 'Portas Lógicas', o jogador passará por 5 fases nas quais enfrentará os cincos seguidores de Spartakus (Baratheon, Frey, Alliser, Varys e Bolton) até chegar na fase final. As fases consistem em perguntas simples/moderadas.\r\n"
						+ "O jogador contará com ajuda do Mago Azadium que derá breve instruções de como exercitar a lógica para a resolução do problema. Se o jogador acertar as questões ele ganhará um grande companheiro pet (ele pode ajudar ou atrapalhar, preste banstante atenção nas palavras ditas por ele; por mais que pareçam sem nexo, tem um grande sentido!).\r\n"
						+ "Ahh, não posso esquecer que cada questão certa o jogador ganhará uma certa quantidade de pontos. AAAAAA e pra que servem esses pontos????? É uma boa pergunta!!!! Os pontos adquiridos em cada etapa lhe trarão o direito de adquirir um item na fase final (é uma ajuda e tanto). \r\n"
						+ "\nEae, bora jogar?????");
	}


	public static void dialogoInicial(Scanner scr, String nomePersonagem, int opcao) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Escreva("🧙‍♂️ Olá Grande Cavalheiro(a), " + nomePersonagem + ". Como estás?\n", TimeUnit.MILLISECONDS, 60);

		System.out.println("Digite 1 - Estou bem \nDigite 2 - Não estou bem");

		int resposta = scr.nextInt();

		if (resposta == 1) {
			System.out.print("\n🧙‍♂️ Ótimo!! Irei te guiar em nosso reino.\n");
		} else {
			System.out.print("\n🧙‍♂️ Bom, iremos melhorar essa situação, serei seu guia em nosso reino\n");
		}

		Escreva("\n🧙‍♂️ Este reino possui grandes desafios, para um(a) jovem como você " + nomePersonagem + "\n",
				TimeUnit.MILLISECONDS, 60);
		System.out.print("\n1 - Ficarei honrado em ser seu discípulo!!\n2 - Gostaria muito de saber mais sobre!!! \n");
		int resposta1 = scr.nextInt();

		if (resposta1 == 1) {
			System.out.print("\n🧙‍♂️ Seja Bem-Vindo!!!\n");
		} else {
			System.out.print("\n🧙‍♂️ Ficarei honrado em lhe ensinar, Seja Bem-Vindo!!!\n");
		}

		Escreva("\n🧙‍♂️ Nosso reino está esperando ha muito tempo um guerreiro(a)\nque possa abrir as portas logicas e vencer o grande Vilão \n",
				TimeUnit.MILLISECONDS, 60);

		System.out.print("\n1 - Esse cara sou eu!!! \n2 - Esse é o meu chamado de vida, mestre!!! \n");
		int resposta2 = scr.nextInt();
		if (resposta2 == 1) {
			Escreva("\n🧙‍♂️ kkk Veremos meu, caro.\n", TimeUnit.MILLISECONDS, 60);
		} else {
			Escreva("\n🧙‍♂️ Veremos...\n", TimeUnit.MILLISECONDS, 60);
		}

		Escreva("\n🧙‍♂️ Irei passar algumas orientacões sobre as tais portas logicas funcionam " + nomePersonagem
				+ "\n", TimeUnit.MILLISECONDS, 60);
		System.out.print("\n1- Certo mestre! \n2- Escutarei atentamente \n");
		int resposta3 = scr.nextInt();

		if (resposta3 == 1) {
			System.out.print("🧙‍♂️ Azadium diz: ");
			Escreva("Pois bem, deseja continuar? \n", TimeUnit.MILLISECONDS, 60);
			System.out.println("\n1 - Continuar \n2 - Parar");
			int escolha = scr.nextInt();
			if (escolha == 1) {
				Escreva("🧔 Baratheon diz: Você," + nomePersonagem + ", jamais irá me derrotar, pois eu sou o MAIOR e o mais forte de toda Gordes HAHAHHAHAHA.",
						TimeUnit.MILLISECONDS, 60);
				primeiroDesafio(scr, nomePersonagem, opcao);
			} else {
				finalizaJogo(opcao);
			}

		} else {
			System.out.print("\n🧙‍♂️ Que assim seja\n");
			
			Escreva("\n🧙‍♂️ Azadium diz: As portas ou circuitos lógicos são dispositivos "
					+ "que operam e trabalham com um ou mais sinais \n lógicos de entrada para produzir uma e somente uma saída, dependente da função implementada no circuito.\n São geralmente usadas em circuitoseletrônicos, por causa das situações que os sinais deste tipo de circuito \n podem apresentar: presença de sinal, ou '1', e ausência de sinal, ou '0'. As situações Verdade e Falso \n",
					TimeUnit.MILLISECONDS, 60);
			Escreva("\n🧙‍♂️ Azadium diz: Nesse primeiro desafio você enfrentará o discípulo de Spartakus - Baratheon. Está preparado(a)?",
					TimeUnit.MILLISECONDS, 60);

			System.out.println("\n1 - Sim \n2 - Não");
			int escolha = scr.nextInt();
			if (escolha == 1) {
				Escreva("🧔 Baratheon diz: Você," + nomePersonagem + ", jamais irá me derrotar, pois eu sou o MAIOR e o mais forte de toda Gordes HAHAHHAHAHA.",
						TimeUnit.MILLISECONDS, 60);
				primeiroDesafio(scr, nomePersonagem, opcao);
			} else {
				finalizaJogo(opcao);
			}

		}

	}
	
	static int contadorPergunta = 0;
	public static boolean pergunta(Scanner scr, String nomePersonagem, int opcao, String[] alternativas, 
			String resposta) throws InterruptedException, IllegalAccessException, 
	IllegalArgumentException, 
	InvocationTargetException {
		
		if(contadorPergunta != 0) {
			Escreva("\n🧙‍♂️ Ok, vamos para mais uma tentativa\n", TimeUnit.MILLISECONDS, 60);
			contadorPergunta++;
		}
		
		ArrayList<String> perguntas = new ArrayList<String>();
		perguntas.add(alternativas[0]);
		perguntas.add(alternativas[1]);
		perguntas.add(alternativas[2]);
		perguntas.add(alternativas[3]);
		perguntas.add(alternativas[4]);
		perguntasAleatorias(perguntas);
		
		String respostaCerta = resposta;
		int escolhaPergunta = scr.nextInt();
		int escolhaIndex = escolhaPergunta - 1;
		
		String respostaUsuario = (String) perguntas.get(escolhaIndex);
		
		System.out.println(respostaCerta + " - " + respostaUsuario);
		
		if (respostaCerta == respostaUsuario) {
			contadorPergunta = 0;
			return true;
		} else if(respostaCerta != respostaUsuario) {
			Escreva("\n🧙‍♂️ Azadium diz: Deseja tentar novamente?\n", TimeUnit.MILLISECONDS, 60);
			System.out.println("\n1 - Sim, estou confiante! \n2 - Não");
			
			int escolha = scr.nextInt();
			
			if(escolha == 1) {
				pergunta(scr, nomePersonagem, opcao, alternativas, respostaUsuario);
			}else {
				finalizaJogo(opcao);
			}
		}
		return false;
	}

	public static void finalizaJogo(int opcao) {
		opcao = 4;
	}

	public static void Escreva(String mensagem, TimeUnit unit, long tempo_mensagem) throws InterruptedException {
		for (char caractere : mensagem.toCharArray()) {
			System.out.print(caractere);
			unit.sleep(tempo_mensagem);
		}
	}

	public static void primeiroDesafio(Scanner scr, String nomePersonagem, int opcao) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Escreva("\n🧙‍♂️ Para ir para o próximo nível, você precisará descobrir como abrir a porta a frente. Você verá \r\n"
				+ "uma porta representada pela expressão booleana S = A . B . C, e para abrir a porta a saída do \r\n"
				+ "circuito deve ser 1, então você deverá escolher os valores das entradas cujo na tabela verdade \r\n"
				+ "o valor seja 1. Qual das alternativas abre essa porta? (100 pontos)\n", TimeUnit.MILLISECONDS, 60);

		ArrayList<String> perguntas = new ArrayList<String>();
		perguntas.add("A = 1, B = 0, C = 1");
		perguntas.add("A = 1, B = 1, C = 1");
		perguntas.add("A = 1, B = 1, C = 0");
		perguntas.add("A = 0, B = 0, C = 0");
		perguntas.add("A = 0, B = 1, C = 1");
		perguntasAleatorias(perguntas);

		String respostaCerta = "A = 1, B = 1, C = 1";
		int escolhaPergunta = scr.nextInt();

		String respostaUsuario = (String) perguntas.get(escolhaPergunta - 1);

		if (respostaCerta == respostaUsuario) {
			segundoDesafio(scr, nomePersonagem, opcao);
		} else {
			Escreva("\n🧔 Baratheon diz: HAHAHAHAHA " + nomePersonagem + ", eu disse que você não era pareô para mim!!!\n", TimeUnit.MILLISECONDS, 60);
			Escreva("\n🧙‍♂️ Azadium diz: Deseja tentar novamente?\n", TimeUnit.MILLISECONDS, 60);
			System.out.println("\n1 - Sim \n2 - Não");
			
			int escolha = scr.nextInt();
			
			if(escolha == 1) {
				primeiroDesafio(scr, nomePersonagem, opcao);
			}else {
				finalizaJogo(opcao);
			}
		}

	}
	

	public static void segundoDesafio(Scanner scr, String nomePersonagem, int opcao) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Escreva("\n🧙‍♂️ Azadium diz:  Boa, " +  nomePersonagem + ". Você conseguiu com grande sabedoria resolver o primeiro desafio, e sua recompensa será um pet que irá te fazer companhia nessa jornada. \n", 
				TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Como deseja chamar o seu novo companheiro?  \n", TimeUnit.MILLISECONDS, 60);
		nomePet = scr.next();
		
		Escreva("\n😺 " + nomePet + " diz: UAAAAAAAAAAAL, é um grande prazer em lhe conhecer, mestre " +  nomePersonagem +"!\n", TimeUnit.MILLISECONDS, 60);
		Escreva("\n😻 Eu sou uma gatinha miaaaaaaaaau.\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n" + nomePersonagem + " diz: É um prazer conher você também, " + nomePet + " \n", TimeUnit.MILLISECONDS, 60);
		Escreva("\n" + nomePersonagem + " diz: Estou muito contente com a sua companhia, " + nomePet + ". Iremos ter grandes aventuras juntos. \n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Azadium diz: Que bom, " + nomePersonagem + " e " + nomePet + " , é bom ver que estão se dando bem... " + nomePersonagem + ", vocês estão prontos para o próximo desafio?\n", TimeUnit.MILLISECONDS, 60);
		Escreva("\n🧙‍♂️ Você enfrentará o segundo o discípulo Spartakus - Frey\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n👨‍🦳 Tome cuidado, não pense que será fácil como foi antes!\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\nEu não tenho medo, irei derrota-lo!!!\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\nConfesso que estou apreensivo!!!\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n👨‍🦳 Frey diz: Você " + nomePersonagem + ", jamais passará por mim!! Não pense que eu sou fraco igual ao Baratheon. Para passar por mim exige uma sabedoria que você claramente não tem. \n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\nSINTA MEU PODEEER 🔥🔥🔥\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Espero que esteja confiante, " + nomePersonagem + "\n", TimeUnit.MILLISECONDS, 60);
		Escreva("\n🧙‍♂️ Uma porta NOR de 3 entradas tem ____ possibilidades de saída\n", TimeUnit.MILLISECONDS, 60);
		
		String[] alternativas = {"Uma", "Quatro", "Oito", "Todas as anteriores", " Nenhuma das anteriores"};
		boolean resposta = pergunta(scr, nomePersonagem, opcao, alternativas, "Oito");
		if(resposta) {
			Escreva("\n👨‍🦳 Frey diz: Não acredito que um(a) fracote como você foi capaz de me derrotar AAAAAAAAAAA\n", TimeUnit.MILLISECONDS, 60);
			Escreva("\n👨‍🦳 VOCÊ PASSOU POR MIM, MAS, JAMAIS IRÁ DERROTAR O ALLISER.\n", TimeUnit.MILLISECONDS, 60);
			terceiroDesafio(scr, nomePersonagem, opcao);
		}
		
	}

	public static void terceiroDesafio(Scanner scr, String nomePersonagem, int opcao) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Escreva("\n🧙‍♂️ Azadium diz: Parece que temos aqui o grande guerreiro destinado a salvar Gordes.\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n😻 " + nomePet + " diz: Meu mestre é um gênio!!!!!!\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Azadium diz: Está preparado para próxima fase? As coisas estão ficando quentes e as portas estão se abrindo HAHAHAHAHA\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n😻 " + nomePet + " diz: ~miauuuuuuu que velho sem noção ~miauuuuu\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Azadium diz:" + nomePersonagem + ", se prepare para o próximo desafio ôoooooo grande guerreiro.\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧔🏾‍ Alliser diz: Não tem como um fedelho(a) que nem você me derrotar. JAMAIS JAMAIS!!!!"
				+ "Você sentirá a fúria de um grande deus. E ESSE DEUS SOU EU.\n"
				+ "MORRAAAAAA, " + nomePersonagem + ", MORRAAAAAA!!!\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️‍ Azadium diz: Aqui está seu próximo desafio:\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ A saída de uma por OR com três entradas, A, B, e C, é BAIXA quando ______.\n", TimeUnit.MILLISECONDS, 60);
		
		String[] alternativas = {
				"A = 0, B = 0, C = 0", 
				"A = 0, B = 0, C = 1", 
				"A = 0, B = 1, C = 1", 
				"A = 1, B = 1, C = 1", 
				"Todas as anteriores"
				};
		
		Escreva("\n😻 " + nomePet + " diz: nem todos os zeros são a esquerda ririri ~miaaaaaaaau\n", TimeUnit.MILLISECONDS, 60);
		
		boolean resposta = pergunta(scr, nomePersonagem, opcao, alternativas, "A = 0, B = 0, C = 0");
		if(resposta) {
			Escreva("\n😻 " + nomePet + "~miaaaaaaau\n"
					+ "MEU MESTRE É O MELHOR!\n"
					+ "MEU MESTRE É O MELHOR!\n", TimeUnit.MILLISECONDS, 60);
			
			Escreva("\n🧔🏾 Alliser diz: ISSO NÃO IRÁ FICAR ASSIM, EU IREI ME VINGAR.\n"
					+ "EU PROMETO QUE IREI ME VINGAR :@\n"
					+ "AAAAAAAAAAAAAAAAAAAAAAAAAAA\n"
					+ "VOCÊ AINDA SENTIRÁ A FÚRIA DE UM GRANDE DEUS\n", TimeUnit.MILLISECONDS, 60);
			
			Escreva("\n🧙‍♂️‍ As portas estão se abrindo de maneira surpreendente HAHAHA ~grande entusiasmo \n"
					+ "- Você está indo muito bem, " + nomePersonagem + "\n"
					+ " De fato você é o(a) grande guerreiro(a) escolhido.\n"
					+ "Vamos para o próximo desafio. \n"
					+ "\n", TimeUnit.MILLISECONDS, 60);
			
			quartoDesafio(scr, nomePersonagem, opcao);
			
		}else {
			Escreva("\n🧔🏾 Alliser diz: EU SABIA QUE JAMAIS SERIA DERROTADO POR FEDELHO(A) IGUAL A VOCÊ\n"
					+ "NIGUÉM É PÁREO PARA UM DEUS COMO EU, NINGUÉEEEEEEM\r"
					+ "\n", TimeUnit.MILLISECONDS, 60);
			
			Escreva("\n😻 " + nomePet + " meu mestre(a) é o melhor, ele irá te derrotar da pior forma  ~miaaaaaaau\n", TimeUnit.MILLISECONDS, 60);
		}
		
		
	}

	public static void quartoDesafio(Scanner scr, String nomePersonagem, int opcao) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Escreva("\n🧔🏿‍‍ Varys diz: \n"
				+ "Esperem um pouco \n"
				+ "DAQUI VOCÊS NÃO PASSARÃO \n"
				+ "Aqueles tolos só tinham um único trabalho, e fracassaram. ~decepcionado \n"
				+ "A arrogância do homem o torna burro. \n"
				+ "Não sou que nem aqueles arrogantes, daqui você não passarão. \n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Uma porta NOR de 2 entradas é equivalente a ______.\n", TimeUnit.MILLISECONDS, 60);
		
		String[] alternativas = {
				"Porta OR negativa á entrada", 
				"Porta OR negativa á saída", 
				"Porta AND negativa á saída",  
				"Todas as anteriores", 
				"Nenhuma das anteriores"
				};
		
		Escreva("\n😻 " + nomePet + " diz: miaaaaaau baby no or no or oh oh oh ~cantarolando~ \n", TimeUnit.MILLISECONDS, 60);
		boolean resposta = pergunta(scr, nomePersonagem, opcao, alternativas, "Porta OR negativa á saída");
		if(resposta) {
			
			Escreva("\n😻 " + nomePet + " diz: que belo dia para salvar vilas chefin ~miauuuuuuuuu\n", TimeUnit.MILLISECONDS, 60);
			Escreva("\n🧙‍♂️ Sempre persistir e jamais desistir!", TimeUnit.MILLISECONDS, 60);
			Escreva("\n🧔🏿 Como um sábio, sei quando admitir a derrota. \n"
					+ "Estou me retirando...\n"
					+ "As coisas podem estar indo bem agora. Será que irá continuar assim? \n", TimeUnit.MILLISECONDS, 60);
			
			Escreva("\n🧙‍♂️ Nunca vi nada parecido antes, tenho orgulho do tanto que você evoluiu nessa jornada!\n", TimeUnit.MILLISECONDS, 60);
			Escreva("\n😻 " + nomePet + " diz: orgulho chefin, orgulho! ༼ つ◕_◕ ༽つ  ~miauuuuuuu\n", TimeUnit.MILLISECONDS, 60);
			
			Escreva("\n🧙‍♂️ Preparado para o penúltimo desafio? Você foi muito forte até aqui. Se sinta orgulhoso!", TimeUnit.MILLISECONDS, 60);
			
			quintoDesafio(scr, nomePersonagem, opcao);
			
		}else {
			Escreva("\n😻 " + nomePet + " diz:  mestrinho(a)...\n"
					+ "você só está cansado, pense um pouco melhor ~miauuuuuuu\n", TimeUnit.MILLISECONDS, 60);
			Escreva("\n🧔🏿‍‍ O grande segredo da vida é admitir a derrota e jamais tentar novamente.", TimeUnit.MILLISECONDS, 60);
			Escreva("\n🧙‍♂️ Algumas palavras podem desmotivar, mas, não se\n"
					+ "esqueça da força que há em você, " + nomePersonagem + "! Siga em frente...\n", TimeUnit.MILLISECONDS, 60);
		}
	}

	public static void quintoDesafio(Scanner scr, String nomePersonagem, int opcao) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Escreva("\n😻 " + nomePet + " diz:  Aquele é Bolton, o mal em forma de gente! Ele parece um garotinho egoísta, \n"
				+ "traiçoeiro e descarado, mas na verdade ele é muito, muito mais do que isso. ~miauuuuuuuuuuuu\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧔🏿 Bolton diz: Como chegaram até aqui? Os outros \n"
				+ "discípulos são muito incompetentes. Será que eu tenho que fazer tudo por aqui?\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Quantas combinações de entrada uma tabela de verdade teria com um gate AND de seis entradas? \n", TimeUnit.MILLISECONDS, 60);
		
		String[] alternativas = {
				"32", 
				"48", 
				"64",  
				"128", 
				"Nenhuma das anteriores"
				};
		
		Escreva("\n😻 " + nomePet + " diz: são dois? são seis? não sei ~miauuuuuu\n", TimeUnit.MILLISECONDS, 60);
		boolean resposta = pergunta(scr, nomePersonagem, opcao, alternativas, "64");
		
		if(resposta) {
			Escreva("\n🧙‍♂️ As outras portas não eram nada perto dessa...\n", TimeUnit.MILLISECONDS, 60);
			Escreva("\n🧙‍♂️ Você conseguiu chegar até aqui... o último desafio o DESAFIO FINAL com o todo poderoso SPARTAKUS. \n", TimeUnit.MILLISECONDS, 60);
			Escreva("\n🧙‍♂️ Vocês está pronto para esse sombrio desafio? Serei realista é logo lhe direi que não será nada fácil essa fase. \n", TimeUnit.MILLISECONDS, 60);
			
			sextoDesafio(scr, nomePersonagem, opcao);
			
		}else {
			Escreva("\n🧔🏿 Bolton diz: Existe uma possibilidade de 30% de já estar chovendo.\n"
					+ "Será que você seria capaz de responder certo?\n", TimeUnit.MILLISECONDS, 60);
			
			Escreva("\n😻 " + nomePet + " diz: Eu estava obcecada. Passava 80% do meu tempo falando sobre o "
					+ "Bolton e os 20% restantes eu torcia para que alguém falasse disso, só para poder falar mais um pouco ~miaaaaaaau\n", 
					TimeUnit.MILLISECONDS, 60);
			
			
			Escreva("\n🧙‍♂️ Só sei que nada sei. \n", TimeUnit.MILLISECONDS, 60);
			
			
		}
		
	}

	public static void sextoDesafio(Scanner scr, String nomePersonagem, int opcao) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Escreva("\n🧔🏿‍ SPARTAKUS diz: COMO OUSAM ME PERTURBAR??????\n"
				+ "AAAAAAAAAAAAAAAA :@ :@ :@ ~furioso\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n😻 " + nomePet + " diz: chefin estou com medo ~miauuuuu\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧔🏿‍ SPARTAKUS diz: Não me importa o seu conhecimento adquirido até aqui. " +  nomePersonagem + ", você nunca terá a capacidade de me derrotar. \n"
				+ "Gordes é MINHA! Esse vilarejo me pertence! Vocês jamais o terão de volta...\n"
				+ "Desistam aqui e não passem pela humilhação da derrota. Serei gentil e os deixarei ir sem nenhum arranhão. \n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n😻 " + nomePet + " diz: chefin estou com medo ~miauuuuu\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Azadium diz: Tenha calma e pense com saberia, são escolhas dificeis. Estamos aqui por um objetivo!\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Azadium e Spartakus dizem: \n"
				+ "ESTÁ PREPARADO PARA ESSE DESAFIO?\n", TimeUnit.MILLISECONDS, 60);
		
		System.out.println("\n1 - SIM \n2 - CHEGUEI ATÉ AQUI PELO OBJETIVO, E ESSE OBJETIVO É SALVAR GORDES.");
		
		int resposta2 = scr.nextInt();
		if (resposta2 == 1 || resposta2 == 2) {
			Escreva("\n🧙‍♂️ DESAFIO FINAL - O GRANDE DESAFIO\n", TimeUnit.MILLISECONDS, 60);
		}
		
		Escreva("\n🧙‍♂️ A saída de uma porta XOR é ALTA se _____.\n", TimeUnit.MILLISECONDS, 60);
		
		String[] alternativas = {
				"Todas as entradas são BAIXAS", 
				"Todas as entradas são ALTAS", 
				"As entradas são desiguais",  
				"Todas as anteriores", 
				"Nenhuma das anteriores"
				};
		
		Escreva("\n😻 " + nomePet + " diz: são dois? são seis? não sei ~miauuuuuu\n", TimeUnit.MILLISECONDS, 60);
		boolean resposta = pergunta(scr, nomePersonagem, opcao, alternativas, "64");
		
		if(resposta) {
			
			Escreva("\n🧙‍♂️ Azadium e 😻" + nomePet + " dizem: \n"
					+ "Você conseguiu, você conseguiu!!!\n"
					+ "Gordes finalmente está a salvo.\n"
					+ "✴ Podemos retomar as nossas vidas e tudo isso graças a você!!!!!!! ✴\n " + nomePersonagem + ", Parabéns por chegar até aqui!\n", TimeUnit.MILLISECONDS, 60);
			
			Escreva("\n🧙‍♂️ Spartakus diz:\n"
					+ "ISSO NÃO FICARÁ ASSIM...\n"
					+ "TERÁ VOLTA...\n", TimeUnit.MILLISECONDS, 60);
			
			System.out.println("     ..!:                                    \r\n"
					+ "     .                      !!!!             \r\n"
					+ "         #########!:              !####!!!!           \r\n"
					+ "       .#############            ##:...!!#!!          \r\n"
					+ "       :#####:!!::##!            .#:.:...:###.        \r\n"
					+ "        !##!....::.                .!...!####         \r\n"
					+ "        ..!###!:!##:            :##!!!..:!!!##        \r\n"
					+ "     !!!:!!!!   ..:!.         .!##!!##!:##!##!#!:     \r\n"
					+ "    #####!!###!!!!!##:        !:#:::: . :#::##:::     \r\n"
					+ "    .#####!##!###!!# !        ::!!!!!.. :!!!!#! .     \r\n"
					+ "   .##!######!!!!:.##.       :!:!!::: . ::::!!#!.     \r\n"
					+ "    !#####!!!!!!:  .###      !##!:::::::::::!####     \r\n"
					+ "    !!!!####!##########!!     :##!::::::::!##!::!     \r\n"
					+ "    :  ###################   ..!!#:!#####!!!###!!.    \r\n"
					+ "    ..:.!!!!########::!  .   ##:::::::::::###! ###    \r\n"
					+ "     :.:######!:::::::!::   !#####!:!!:::::!!######   \r\n"
					+ "     .:!:###:::::::!!:!:!:  !#########.############.  \r\n"
					+ "      !:##:::::::!!:::!        .######  ##########!   \r\n"
					+ "      ##########!:!!::!         #####    #########.   \r\n"
					+ "      !:::::::!!::::::.          ####     ####.       \r\n"
					+ "     .!:::::::!:::::!!          .####     :###.       \r\n"
					+ "    !!::::!!::!::::!!!           ####:    :###!       \r\n"
					+ "   !::::!!!::  !!::!!!            ####    .####       \r\n"
					+ " .!::::::::.  :::::!!:.           ####     ####.      \r\n"
					+ " :::::::::!  ::::::::!!          !!!!!!     ###!      \r\n"
					+ " .::::::::!    #!:!!::            :!::.     ####      \r\n"
					+ "  .##::##      !##:##             ###:      #####     \r\n"
					+ "   #####       :######           !###!       ###      \r\n"
					+ "   #####           !#####       ####         #!!#     \r\n"
					+ "   :#####                                    ####.   \r\n"
					+ "");
			
		}else {
			Escreva("\n🧔🏿 Spartakus diz: \n"
					+ "HAHAHAHAHAHAHAA\n"
					+ "EU SABIA QUE UM FRACOTE IGUAL A VOCÊ JAMAIS TERIA CHANCES CONTRA MIM\n"
					+ "VOLTE PARA CASA, GORDES NÃO PERTECE MAIS Á VOCÊS\n"
					+ "GORDES É MINHA, É MINHA E SEMPRE SERÁ\n", TimeUnit.MILLISECONDS, 60);
			
			Escreva("\n😻 " + nomePet + " diz: chefin estou com medo ~miauuuuu\n", TimeUnit.MILLISECONDS, 60);
			
			Escreva("\n🧙‍♂️ Azadium diz: Persistir e Persistir e jamais desistir!\n", TimeUnit.MILLISECONDS, 60);
			
		}
	}

	public static void carregaJogo() throws InterruptedException {
		int count = 0;
		System.out.println("\n⌛ Carregando jogo...");
		for (int i = 0; i < 5000; i++) {
			count++;
			if (count == 100) {
				Thread.sleep(100);
				System.out.print("=");
				count = 0;
			}
		}
		System.out.print(" 100%\n");
		System.out.println("ok, vamos lá‼️");
	}

	public static String nomePersonagem(Scanner scr, String nomePersonagem) {
		System.out.println("Como seu personagem irá se chamar? ");
		nomePersonagem = scr.next();

		return nomePersonagem;
	}

	public static String nomeMago(Scanner scr, String nomeMago) {
		System.out.println("Digite o nome do personagem: ");
		nomeMago = scr.next();

		return nomeMago;
	}

	public static void perguntasAleatorias(ArrayList<String> opcoes) {
		Collections.shuffle(opcoes);
		System.out.println("\n");
		for (int indexOpcoes = 0; indexOpcoes < opcoes.size(); indexOpcoes++) {
			System.out.println((indexOpcoes + 1) + ") - " + opcoes.get(indexOpcoes));
		}
	}

}
