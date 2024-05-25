package jogodaforca;

import java.util.*;

public class jogo {
  static Scanner ler = new Scanner(System.in);
  static Random random = new Random();

  public static void main(String[] args) {
    
     String palavra = temas();
int opcao=0;
    while (opcao != 4) {
      System.out.println("\n---------- BEM VINDO AO JOGO DA FORCA ---------- \n");
      System.out.println("Escolha uma das opções abaixo: \n");
      System.out.println("1 - Jogar\n");
      System.out.println("2 - Como jogar\n");
      System.out.println("3 - Créditos\n");
      System.out.println("4 - Sair");
      opcao = ler.nextInt();
      

      switch(opcao){
        case 1: 
        
           String[] palavras = { palavra };
          int quantPalavras = palavras.length;
            int indiceSorteado = random.nextInt(quantPalavras);
            String sorteada = palavras[indiceSorteado];

            char [] acertos = new char[sorteada.length()];
            for(int i =0; i < acertos.length; i++) {
              acertos[i] = 0;
            }

            String letrasUtilizadas = "";


            char letra;	
            boolean ganhou = false;
            int vidas = sorteada.length();
          
          if (Arrays.asList("SAPO", "CACHORRO", "TAMANDUA", "GATO", "CAMELO", "GALINHA", "GALO", "BALEIA").contains(palavra.toUpperCase())) {
              System.out.println("\nO Tema é Animal");
          }
          else if(Arrays.asList("PITAYA", "UVA", "BANANA", "MORANGO", "ABACATE", "ABACAXI", "MACA", "MANGA").contains(palavra.toUpperCase())){
            System.out.println("\nO Tema é Fruta");
          }
          else if(Arrays.asList("BRASIL", "RUSSIA", "CHILE", "GUINE", "JAPAO").contains(palavra.toUpperCase())){
            System.out.println("\nO Tema é País");
          }
          else{
            System.out.println("\nO Tema é Objeto");
          }

            while (!ganhou && vidas > 0) {
            System.out.println("\n"
                +"Voce tem " + vidas + " vidas\n"
                +"Letras utilizadas:" + letrasUtilizadas
                +"\n\nQual letra voce deseja tentar?");
            letra = ler.next().toUpperCase().charAt(0);
            letrasUtilizadas += " " + letra;

            boolean perdeVida = true;

            for (int i =0; i < sorteada.length(); i++) {

              if (letra == sorteada.charAt(i)) {
                acertos[i] = 1;
                perdeVida = false;
                }
              }
            if (perdeVida)
              vidas--;
            System.out.println("\n");
            ganhou = true;
            for (int i = 0; i < sorteada.length(); i++) {
              if (acertos[i] ==0) {
              System.out.print (" _ ");
              ganhou = false;
                }
              else {
              System.out.print(" " + sorteada.charAt(i) + " ");
                }
              }

            System.out.println("\n");

            }

            if (vidas != 0) {
            System.out.println("\n\n\tParabens!!! Voce ganhou!\n\n");
              }
            else {
              System.out.println("\n\n\tVoce perdeu!");
              System.out.println("\n\n\tA palavra era: "+ sorteada);
              }
          break;
        case 2:
           System.out.println("O jogo da forca é um jogo de adivinhação, onde o jogador deve adivinhar uma palavra secreta. A Quantidade de vida é a quantidade de letras na palavra secreta. Boa sorte !");
          break;
        case 3:
           System.out.println("Desenvolvido por: \nRaymouns \nPlxandre \nRodMayOnes");
          break;
        case 4:
          System.out.println("Encerrando");
            }
    }
  }

public static String temas() {
  String[] animal = { "SAPO", "CACHORRO", "TAMANDUA", "GATO", "CAMELO", "GALINHA", "GALO", "BALEIA"};
  String[] fruta = { "PITAYA", "UVA", "BANANA", "MORANGO", "ABACATE", "ABACAXI", "MACA", "MANGA" };
  String[] objeto = { "TELEVISAO", "COMPUTADOR", "TELEFONE", "CANETA", "MOUSE" };
  String[] paises = { "BRASIL", "RUSSIA", "CHILE", "GUINE", "JAPAO" };

  int a = random.nextInt(1, 5);
  if (a == 1) {
    int b = random.nextInt(animal.length);
    String palavra = animal[b];
    return palavra;
  } else if (a == 2) {
    int b = random.nextInt(fruta.length);
    String palavra = fruta[b];
    return palavra;
  } else if (a == 3) {
    int b = random.nextInt(objeto.length);
    String palavra = objeto[b];
    return palavra;
  } else {
    int b = random.nextInt(paises.length);
    String palavra = paises[b];
    return palavra;
  }
}
}