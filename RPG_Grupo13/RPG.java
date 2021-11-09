import java.util.Scanner;

import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;

public class RPG {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scr = new Scanner(System.in);
		int contarPontos = 0;
		String nomePersonagem = "";
		
	int opcao;
	
	//menu de escolha usando o laço do-while
	do {	
		System.out.println("_________________________");
		System.out.println("         MENU          ");
		System.out.println("_________________________");
		System.out.println("\n1 - INSTRUÇÕES \n2 - JOGAR \n3 - CRÉDITOS \n4 - SAIR");
		
		opcao = scr.nextInt();
		
		switch(opcao) {
		case 1:
			System.out.println("« Instruções »");
			System.out.println("");
			break;
		case 2:
			System.out.println("Jogar");
			//nomePersonagem = nomePersonagem(scr);
			
			ArrayList opcoes = new ArrayList<String>();
			
			opcoes.add("programação");
			opcoes.add("Structured Query Language (SQL)");
			opcoes.add("raciocínio lógico");
			opcoes.add("marcação de texto (Estruturação)");
			opcoes.add("Nenhuma das anteriores");
			
			perguntasAleatorias(opcoes);
			
			System.out.println("teste");
			break;
		case 3:
			System.out.println("« Créditos »");
			System.out.println("Desenvolvido por: \nEvelyn Santos Rodrigues \nKevin Corumba Alexandre \nMariana Rosa da Silva ®");
			break;
		case 4:
			System.out.println("« Programa Encerrado »");
			break;
		default:
		}
	}
	while(opcao == 4);
	
	}
	
	
	
	public static void nomePersonagem(Scanner scr) {
		System.out.println("Digite o nome do personagem: ");
		String nomePersonagem = scr.next();
		
		return nomePersonagem;
	}
	
	public static void nomeMago(Scanner scr) {
		System.out.println("Digite o nome do personagem: ");
		String nomeMago = scr.next();
		return nomeMago;
	}
	
	public static void perguntasAleatorias(ArrayList opcoes) {
	    Collections.shuffle(opcoes);
	    for (int indexOpcoes = 0; indexOpcoes < opcoes.size(); indexOpcoes++) {
            System.out.println((indexOpcoes) + ") - " + opcoes.get(indexOpcoes));
        }
	}
	
	public static void ensinarJogo(String nomeJogador) {
		System.out.println("Então, " + nomeJogador + ", para entender portas lógicas, primeiro vamos resolver um desafio" + "/n");
	}
	
	
}
