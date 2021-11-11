
package rpg;

import java.util.Scanner;


 
public class RPG{
    
    
    
   static  void DialogoMagoHeroi() {
	


	Scanner entrada = new Scanner(System.in); 
	  
	  System.out.print("Digite o nome do seu personagem *_* : ");
	  String nome = entrada.next();
          System.out.print( "meu nome é mestre \n");
	  System.out.print("Olá "+nome+" Como vai ?\n");
          
	  System.out.print("(1)estou bem!! (2)estou mais ou menos!!! ");
         int respota = entrada.nextInt();
  
         if(respota==1){
         System.out.print("\nOtimo , irei ti guiar  em nosso reino\n");}
	  
          else{
         System.out.print("\nBom, iremos melhorar essa situação,serei seu guia em nosso reino\n");}
          
         System.out.print("\nEste reino possui muitos desafios, para uma jovem como você "+nome+"\n");
         
         System.out.print("\n(1)ficarei horado em ser seu discípulo!! (2)gostaria muito de saber mais sobre!!! \n");
         int respota1 = entrada.nextInt();
       
         
         if( respota1==1){
         System.out.print("\nSeja bem vindo!!!\n");}
         else{System.out.print("\nEsta honrado em lhe ensinar,Seja bem vindo!!!\n");              }
	  System.out.print("Portas ou circuitos lógicos são dispositivos que operam e trabalham com um ou mais sinais \n lógicos de entrada para produzir uma e somente uma saída, dependente da função implementada no circuito.\n São geralmente usadas em circuitoseletrônicos, por causa das situações que os sinais deste tipo de circuito \n podem apresentar: presença de sinal, ou 1, e ausência de sinal, ou 0. As situações Verdade e Falso");
    
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
static void Menu()	{
	
     System.out.print(" \n*****MENU*****\n");
     System.out.print("\n(1) Indrodução\n");
     System.out.print("\n(2) Regras \n");
     System.out.print("\n(3) Jogar\n");
     System.out.print("\n(4) Sair\n");
     
}
 static void Saudacoes() {
	 
	 System.out.print("\n Seja bem vindo ao nosso vilareijo!!!\n" );
	 System.out.print("\n Logical Ports\n");
	 
 }
  
 
static void PrimeiraFase() {


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
public static void main(String[] args) {
 
DialogoMagoHeroi();
	

 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
        
   
}
}

