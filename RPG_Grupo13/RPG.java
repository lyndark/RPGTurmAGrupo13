import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Collections;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class RPG {

	public static int contarPontos = 0;
	public static String nomePet = "";
	//Método principal que executa os demais métodos
	public static void main(String[] args) throws InterruptedException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		//Instância do Scanner para pegar valores digitados pelo usuário
		Scanner scr = new Scanner(System.in);
		
		//Chama o menu
		menu(scr);

	}
	
	//Método para carregar o menu
	public static void menu(Scanner scr) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		String nomePersonagem = "";
		String nomeMago = "";
		
		int opcao;
		// Executa o menu enquanto a condição for verdadeira
		do {
			System.out.println("_________________________");
			System.out.println("         MENU          ");
			System.out.println("_________________________");
			System.out.println("\n1 - INSTRUÇÕES \n2 - JOGAR \n3 - CRÉDITOS \n4 - SAIR");
			
			//Opcao escolhida pelo usuários
			opcao = scr.nextInt();
			
			//Carrega de acordo com a condição
			switch (opcao) {
			case 1:
				//Instruções do jogo
				System.out.println("« Instruções »");
				//Chama instruções do jogo
				instrucoes();
				//Método responsável por continuar o jogo dependendo da escolha do jogador
				String continuarJogo = scr.next();
				//Tem que digitar 's' para continuar e 'n'
				if (continuarJogo.equalsIgnoreCase("s")) {
					//Chama o menu de forma recursiva para o iniciar ou sair do jogo
					menu(scr);
				}
				break;
			case 2:
				//Inicia o jogo
				System.out.println("\n« Iniciando jogo »\n");
				//Carrega sinopse
				sinopse();
				//Seta o nome do personagem
				nomePersonagem = nomePersonagem(scr, nomePersonagem);
				carregaJogo();
				//Inicia primeiro dialogo
				dialogoInicial(scr, nomePersonagem, opcao);

				break;
			case 3:
				//Carrega os créditos
				System.out.println("« Créditos »");
				System.out.println(
						"Desenvolvido por: \nDaniel Leite \nEvelyn Santos Rodrigues \nKevin Corumba Alexandre \nMariana Rosa da Silva ®");
				//Chama o menu de novo para executar novamente
				menu(scr);
				break;
			case 4:
				//Encerrando programa
				System.out.println("« Programa Encerrado »");
				
				//Seta zero para sair do menu
				opcao = 0;
				break;
			default:
			}
		} while (opcao == 4);
	}
	
	//Sinopse do jogo
	public static void sinopse() {
		//Printa a história da sinopse
		System.out.println(
				"\nGordes é um mais bonitos vilarejos do Palácio das almas, fica no alto de uma colina de Luberon na Região de Provence. A área pacata e calma foi tomada pelo Grande Spartakus.\r\n"
						+ "O maior objetivo de Spartakus é causar o caos e tomar o vilarejo para si e tranformar em reino de terror.\r\n"
						+ "Reza a lenda que existe um grande guerreiro destinado a trazer a paz de volta para Gordes. Será você o grande prometido??\r\n"
						+ "");
	}
	
	//Carrega as instruções iniciais do jogo
	public static void instrucoes() {
		//Printa as instruções do jogo
		System.out.println(
				"\nÉ um jogo de perguntas e respostas baseado no tema 'Portas Lógicas', o jogador passará por 5 fases nas quais enfrentará os cincos seguidores de Spartakus (Baratheon, Frey, Alliser, Varys e Bolton) até chegar na fase final. As fases consistem em perguntas simples/moderadas.\r\n"
						+ "O jogador contará com ajuda do Mago Azadium que derá breve instruções de como exercitar a lógica para a resolução do problema. Se o jogador acertar as questões ele ganhará um grande companheiro pet (ele pode ajudar ou atrapalhar, preste banstante atenção nas palavras ditas por ele; por mais que pareçam sem nexo, tem um grande sentido!).\r\n"
						+ "Ahh, não posso esquecer que cada questão certa o jogador ganhará uma certa quantidade de pontos. AAAAAA e pra que servem esses pontos????? È uma boa pergunta!!!! Os pontos adquiridos em cada etapa lhe trará o direito de adquirir um item na fase final (é uma ajuda e tanto). \r\n"
						+ "\nEae, bora jogar?????");
	}

	//Carrega o dialogo inicial do jogo
	public static void dialogoInicial(Scanner scr, String nomePersonagem, int opcao) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Escreva("🧙‍♂️ Olá Grande Cavalheiro(a), " + nomePersonagem + ". Como estás?\n", TimeUnit.MILLISECONDS, 60);
		//Solicita ao usuário uma escolha
		System.out.println("\nDigite 1 - Estou bem \nDigite 2 - Não estou bem");

		int resposta = scr.nextInt();
		//Segue o fluxo conforme a resposta dada
		if (resposta == 1) {
			System.out.print("\n🧙‍♂️ Ótimo!! irei te guiar em nosso reino.\n");
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
		
		Escreva("\n🧙‍♂️ Nosso reino está esperando há muito tempo um guerreiro(a)\nque possa abrir ás portas lógicas e vencer o grande Vilão \n",
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
				Escreva("🧔 Baratheon diz: Você, " + nomePersonagem + ", jamais irá me derrotar, pois eu sou o MAIOR e o mais forte de toda Gordes HAHAHHAHAHA.",
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
				Escreva("🧔 Baratheon diz: Você, " + nomePersonagem + ", jamais irá me derrotar, pois eu sou o MAIOR e o mais forte de toda Gordes HAHAHHAHAHA.",
						TimeUnit.MILLISECONDS, 60);
				primeiroDesafio(scr, nomePersonagem, opcao);
			} else {
				finalizaJogo(opcao);
			}

		}

	}
	
	static int contadorPergunta = 0;
	static boolean resultado = false;
	
	//Carrega a pergunta de forma aleatoria
	public static boolean pergunta(Scanner scr, String nomePersonagem, int opcao, String[] alternativas, 
			String resposta) throws InterruptedException, IllegalAccessException, 
	IllegalArgumentException, 
	InvocationTargetException { 
		
		//Exibe o contador para o usuário saber sua tentativa
		if(contadorPergunta != 0) {
			Escreva("\n🧙‍♂️ Ok, vamos para mais uma tentativa\n", TimeUnit.MILLISECONDS, 60);
			contadorPergunta++;
		}
		
		ArrayList<String> perguntas = new ArrayList<String>();
		//Adiciona as pertguntas em array
		perguntas.add(alternativas[0]);
		perguntas.add(alternativas[1]);
		perguntas.add(alternativas[2]);
		perguntas.add(alternativas[3]);
		perguntas.add(alternativas[4]);
		
		//Monta as perguntas de forma aleatória
		perguntasAleatorias(perguntas);
		
		//Armazena a resposta certa 
		String respostaCerta = resposta;
		
		//Pede que o usuário escolha sua opção
		int escolhaPergunta = scr.nextInt();
		
		//Trata a escolha do usuário pegando o número digitado menos 1 para se enquadrar no range do array
		int escolhaIndex = escolhaPergunta - 1;
		
		//Armazena a resposta do usuario dando um find na lista com base no index capturado
		String respostaUsuario = (String) perguntas.get(escolhaIndex);
		
		// Verifica se a pergunta é a correta
		if (respostaCerta == respostaUsuario) {
			//Contador para exibir a tentativa para o usuário
			contadorPergunta = 0;
			resultado = true;
		} 
		
		//Se a reposta do usuário for diferente, ele exibe uma mensagem para o usuário tente novamente 
		if(respostaCerta != respostaUsuario) {
			Escreva("\n🧙‍♂️ Azadium diz: Deseja tentar novamente?\n", TimeUnit.MILLISECONDS, 60);
			System.out.println("\n1 - Sim, estou confiante! \n2 - Não");
			
			//Usuário escolhe
			int escolha = scr.nextInt();
			
			//Caso ele deseje continuar, a função de pergunta é recarregada
			if(escolha == 1) {
				pergunta(scr, nomePersonagem, opcao, alternativas, resposta);
			}else {
				//Caso contrário, ele finaliza o jogo e o resultado é setado false
				resultado = false;
				finalizaJogo(opcao);
			}
		}
		
		return resultado;
	}
	
	//Método que finaliza o jogo
	public static void finalizaJogo(int opcao) {
		opcao = 0;
	}
	
	// Método para escrever interpassado
	public static void Escreva(String mensagem, TimeUnit unit, long tempo_mensagem) throws InterruptedException {
		for (char caractere : mensagem.toCharArray()) {
			System.out.print(caractere);
			unit.sleep(30);
		}
	}

	//Método para chamar o primeiro desafio
	public static void primeiroDesafio(Scanner scr, String nomePersonagem, int opcao) throws InterruptedException, 
	IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException {
		//Exibe a pergunta para o primeiro desafio
		Escreva("\n🧙‍♂️ Para ir para o próximo nível, você precisará descobrir como abrir a porta a frente. Você verá \r\n"
				+ "uma porta representada pela expressão booleana S = A . B . C, e para abrir a porta a saída do \r\n"
				+ "circuito deve ser 1, então você deverá escolher os valores das entradas cujo na tabela verdade \r\n"
				+ "o valor seja 1. Qual das alternativas abre essa porta? (100 pontos)\n", TimeUnit.MILLISECONDS, 60);
		
		//Amarzena numa estrutura de dados array list as perguntas
		ArrayList<String> perguntas = new ArrayList<String>();
		perguntas.add("A = 1, B = 0, C = 1");
		perguntas.add("A = 1, B = 1, C = 1");
		perguntas.add("A = 1, B = 1, C = 0");
		perguntas.add("A = 0, B = 0, C = 0");
		perguntas.add("A = 0, B = 1, C = 1");
		
		//Embaralha as perguntas de forma aleatória
		perguntasAleatorias(perguntas);
		
		//Identifica a resposta certa
		String respostaCerta = "A = 1, B = 1, C = 1";
		
		//Escolha da pergunta
		int escolhaPergunta = scr.nextInt();
		
		//Pega resposta do usuário na lista
		String respostaUsuario = (String) perguntas.get(escolhaPergunta - 1);
		
		//Valida se a resposta do usuário é igual a resposta correta
		if (respostaCerta.equalsIgnoreCase(respostaUsuario)) {
			//Casos seja, chama o segundo desafio
			segundoDesafio(scr, nomePersonagem, opcao);
		} else {
			
			//Caso erro, o usuário tem uma nova chance
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
	
	//Método para chamar o segundo desafio
	public static void segundoDesafio(Scanner scr, String nomePersonagem, int opcao) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Escreva("\n🧙‍♂️ Azadium diz:  Boa, " +  nomePersonagem + ". Você conseguiu com grande sabedoria resolver o primeiro desafio, e sua recompensa será um pet que irá te fazer companhia nessa jornada. \n", 
				TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Como deseja chamar o seu novo companheiro?  \n", TimeUnit.MILLISECONDS, 60);
		nomePet = scr.next();
		
		Escreva("\n😺 " + nomePet + " diz: UAAAAAAAAAAAL, é um grande prazer em lhe conhecer, mestre " +  nomePersonagem +"!\n", TimeUnit.MILLISECONDS, 60);
		Escreva("\n😻 Eu sou uma gatinha miaaaaaaaaau.\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n" + nomePersonagem + " diz: É um prazer conhecer você também, " + nomePet + " \n", TimeUnit.MILLISECONDS, 60);
		Escreva("\n" + nomePersonagem + " diz: Estou muito contente com a sua companhia, " + nomePet + ". Iremos ter grandes aventuras juntos. \n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Azadium diz: Que bom, " + nomePersonagem + " e " + nomePet + ", é bom ver que estão se dando bem... " + nomePersonagem + ", vocês estão prontos para o próximo desafio?\n", TimeUnit.MILLISECONDS, 60);
		Escreva("\n🧙‍♂️ Você enfrentará o segundo o discípulo Spartakus - Frey\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n👨‍🦳 Tome cuidado, não pense que será fácil como foi antes!\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\nEu não tenho medo, irei derrota-lo!!!\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\nConfesso que estou apreensivo!!!\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n👨‍🦳 Frey diz: Você " + nomePersonagem + ", jamais passará por mim!! Não pense que eu sou fraco igual ao Baratheon. Para passar por mim exige uma sabedoria que você claramente não tem. \n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\nSINTA MEU PODEEER 🔥🔥🔥\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Espero que esteja confiante, " + nomePersonagem + "\n", TimeUnit.MILLISECONDS, 60);
		Escreva("\n🧙‍♂️ Uma porta NOR de 3 entradas tem ____ possibilidades de saída\n", TimeUnit.MILLISECONDS, 60);
		
		//Amarzena numa estrutura de dados array list as perguntas
		String[] alternativas = {"Uma", "Quatro", "Oito", "Todas as anteriores", "Nenhuma das anteriores"};
		
		//Valida se a resposta é a correta
		boolean resposta = pergunta(scr, nomePersonagem, opcao, alternativas, "Oito");
		
		//Verifica se é true a resposta correta
		if(resposta) {
			Escreva("\n👨‍🦳 Frey diz: Não acredito que um(a) fracote como você foi capaz de me derrotar AAAAAAAAAAA\n", TimeUnit.MILLISECONDS, 60);
			Escreva("\n👨‍🦳 VOCÊ PASSOU POR MIM, MAS, JAMAIS IRÁ DERROTAR O ALLISER.\n", TimeUnit.MILLISECONDS, 60);
			//Caso seja, chama o terceiro desafio
			terceiroDesafio(scr, nomePersonagem, opcao);
		}
		
	}
	
	//Método para chamar o terceiro desafio
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
		
		//Seta as alternativas num array
		String[] alternativas = {
				"A = 0, B = 0, C = 0", 
				"A = 0, B = 0, C = 1", 
				"A = 0, B = 1, C = 1", 
				"A = 1, B = 1, C = 1", 
				"Todas as anteriores"
				};
		
		Escreva("\n😻 " + nomePet + " diz: nem todos os zeros são a esquerda ririri ~miaaaaaaaau\n", TimeUnit.MILLISECONDS, 60);
		
		//Verifica se é true a resposta correta
		boolean resposta = pergunta(scr, nomePersonagem, opcao, alternativas, "A = 0, B = 0, C = 0");
		
		//Valida se a resposta é correta
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
					+ "De fato você é o(a) grande guerreiro(a) escolhido.\n"
					+ "Vamos para o próximo desafio. \n"
					+ "\n", TimeUnit.MILLISECONDS, 60);
			//Chama o quarto desafio
			quartoDesafio(scr, nomePersonagem, opcao);
			
		}else {
			Escreva("\n🧔🏾 Alliser diz: EU SABIA QUE JAMAIS SERIA DERROTADO POR FEDELHO(A) IGUAL A VOCÊ\n"
					+ "NIGUÉM É PAREÔ PARA UM DEUS COMO EU, NINGUÉEEEEEEM\r"
					+ "\n", TimeUnit.MILLISECONDS, 60);
			
			Escreva("\n😻 " + nomePet + " meu mestre(a) é o melhor, ele irá te derrotar da pior forma  ~miaaaaaaau\n", TimeUnit.MILLISECONDS, 60);
		}
		
		
	}
	
	//Chama o quarto desafio
	public static void quartoDesafio(Scanner scr, String nomePersonagem, int opcao) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Escreva("\n🧔🏿‍‍ Varys diz: \n"
				+ "Esperem um pouco \n"
				+ "DAQUI VOCÊS NÃO PASSARÃO \n"
				+ "Aqueles tolos só tinham um único trabalho, e fracassaram. ~decepcionado \n"
				+ "A arrogância do homem o torna burro. \n"
				+ "Não sou que nem aqueles arrogantes, daqui você não passarão. \n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Uma porta NOR de 2 entradas é equivalente a ______.\n", TimeUnit.MILLISECONDS, 60);
		
		//Seta as alternativas num array
		String[] alternativas = {
				"Porta OR negativa á entrada", 
				"Porta OR negativa á saída", 
				"Porta AND negativa á saída",  
				"Todas as anteriores", 
				"Nenhuma das anteriores"
				};
		
		//Verifica se é true a resposta correta
		Escreva("\n😻 " + nomePet + " diz: miaaaaaau baby no or no or oh oh oh ~cantarolando~ \n", TimeUnit.MILLISECONDS, 60);
		boolean resposta = pergunta(scr, nomePersonagem, opcao, alternativas, "Porta OR negativa á saída");
		//Valida se a resposta é correta
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
	
	//Chama o quinto desafio
	public static void quintoDesafio(Scanner scr, String nomePersonagem, int opcao) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Escreva("\n😻 " + nomePet + " diz:  Aquele é Bolton, o mal em forma de gente! Ele parece um garotinho egoísta, \n"
				+ "traiçoeiro e descarado, mas na verdade ele é muito, muito mais do que isso. ~miauuuuuuuuuuuu\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧔🏿 Bolton diz: Como chegaram até aqui? Os outros \n"
				+ "discípulos são muito incopetentes. Será que eu tenho que fazer tudo por aqui?\n", TimeUnit.MILLISECONDS, 60);
		
		Escreva("\n🧙‍♂️ Quantas combinações de entrada uma tabela de verdade teria com um gate AND de seis entradas? \n", TimeUnit.MILLISECONDS, 60);
		
		//Seta as alternativas num array
		String[] alternativas = {
				"É 32", 
				"É 48", 
				"É 64",  
				"É 128", 
				"É 42"
				};
		
		//Verifica se é true a resposta correta
		Escreva("\n😻 " + nomePet + " diz: são dois? são seis? não sei ~miauuuuuu\n", TimeUnit.MILLISECONDS, 60);
		boolean resposta = pergunta(scr, nomePersonagem, opcao, alternativas, "É 64");
		//Valida se a resposta é correta
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
	
	//Chama o sexto e último desafio
	public static void sextoDesafio(Scanner scr, String nomePersonagem, int opcao) throws InterruptedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Escreva("\n🧔🏿‍ SPARTAKUS diz: COMO USAM ME PERTURBAR??????\n"
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
		
		//Valida se a resposta é correta
		Escreva("\n😻 " + nomePet + " diz: não se sinta assim chefin, ainda temos chances!!! ~miauuuuuu\n", TimeUnit.MILLISECONDS, 60);
		boolean resposta = pergunta(scr, nomePersonagem, opcao, alternativas, "As entradas são desiguais");
		//Caso a resposta seja correta, finaliza o jogo parabenizando o jogador
		if(resposta) {
			
			Escreva("\n🧙‍♂️ Azadium e 😻" + nomePet + " dizem: \n"
					+ "Você consegiu, você conseguiu!!!\n"
					+ "Gorbes finalmente está a salvo.\n"
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
	
	//Chama barra de carregamento
	public static void carregaJogo() throws InterruptedException {
		//Seta um contador 
		int count = 0;
		//Imprime uma mensagem dizendo que o jogo está carregando
		System.out.println("\n⌛ Carregando jogo...");
		//Executa o for simulando uma execução de 5 segundos
		for (int i = 0; i < 5000; i++) {
			//Seta o contador para validar se ele é igual a 100
			count++;
			//Verifica se o contador é igual
			if (count == 100) {
				//Inicia uma tread para segurar durante um tempo para simular um carregamento
				Thread.sleep(100);
				//Exibe um igual para simular o carregamento
				System.out.print("=");
				count = 0;
			}
		}
		System.out.print(" 100%\n");
		System.out.println("ok, vamos lá‼️");
	}
	
	//Seta Nome do personagem
	public static String nomePersonagem(Scanner scr, String nomePersonagem) {
		//Imprime uma mensagem solicitando o nome de um personagem
		System.out.println("Como seu personagem irá se chamar? ");
		nomePersonagem = scr.next();
		
		//Devolve o nome do personagem
		return nomePersonagem;
	}
	
	//Seta nome do mago
	public static String nomeMago(Scanner scr, String nomeMago) {
		//Imprime a mensagem para solicitar o nome do mago
		System.out.println("Digite o nome do personagem: ");
		nomeMago = scr.next();
		//Retorna o nome do mago
		return nomeMago;
	}
	
	//Monta perguntas e exibe aleatórias
	public static void perguntasAleatorias(ArrayList<String> opcoes) {
		//Monta de forma aleatória as opções
		Collections.shuffle(opcoes);
		System.out.println("\n");
		
		//Exibe as opções de forma aleatória
		for (int indexOpcoes = 0; indexOpcoes < opcoes.size(); indexOpcoes++) {
			System.out.println((indexOpcoes + 1) + ") - " + opcoes.get(indexOpcoes));
		}
	}

}
