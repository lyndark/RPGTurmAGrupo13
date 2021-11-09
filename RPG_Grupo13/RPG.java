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
	
	//menu de escolha usando o la�o do-while
	do {	
		System.out.println("_________________________");
		System.out.println("         MENU          ");
		System.out.println("_________________________");
		System.out.println("\n1 - INSTRU��ES \n2 - JOGAR \n3 - CR�DITOS \n4 - SAIR");
		
		opcao = scr.nextInt();
		
		switch(opcao) {
		case 1:
			System.out.println("� Instru��es �");
			System.out.println("");
			break;
		case 2:
			System.out.println("Jogar");
			//nomePersonagem = nomePersonagem(scr);
			
			ArrayList opcoes = new ArrayList<String>();
			
			opcoes.add("programa��o");
			opcoes.add("Structured Query Language (SQL)");
			opcoes.add("racioc�nio l�gico");
			opcoes.add("marca��o de texto (Estrutura��o)");
			opcoes.add("Nenhuma das anteriores");
			
			perguntasAleatorias(opcoes);
			
			System.out.println("teste");
			break;
		case 3:
			System.out.println("� Cr�ditos �");
			System.out.println("Desenvolvido por: \nEvelyn Santos Rodrigues \nKevin Corumba Alexandre \nMariana Rosa da Silva �");
			break;
		case 4:
			System.out.println("� Programa Encerrado �");
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
		System.out.println("Ent�o, " + nomeJogador + ", para entender portas l�gicas, primeiro vamos resolver um desafio" + "/n");
	}
	
	
}
