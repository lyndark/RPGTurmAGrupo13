import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
public class RPG {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scr = new Scanner(System.in);
		
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
			System.out.println("");
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
}
