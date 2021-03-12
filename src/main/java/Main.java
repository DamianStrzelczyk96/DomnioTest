import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static String newStructure(String domino, int iterations){

        char[] dominoesBeforeIteration = domino.toCharArray();
        char[] dominoesAfterIteration = domino.toCharArray();

        for(int i=0 ; i<iterations;i++){
            for (int x=0; x<dominoesBeforeIteration.length -1 ;x++){
                if(dominoesBeforeIteration[x] == Domino.vertical){
                    if(x>0 && dominoesBeforeIteration[x-1]==Domino.right && x<dominoesBeforeIteration.length-1
                            && dominoesBeforeIteration[x+1]!=Domino.left){
                        dominoesAfterIteration[x]=Domino.right;
                    }
                    if(x>0 && dominoesBeforeIteration[x+1]==Domino.left && x<dominoesBeforeIteration.length-1
                            && dominoesBeforeIteration[x-1]!=Domino.right){
                        dominoesAfterIteration[x]=Domino.left;
                    }
                }
            }
            dominoesBeforeIteration=dominoesAfterIteration;
        }
        String newDominos = new String(dominoesAfterIteration);

        return newDominos;
    }

    public static String oldStructure(String domino, int iterations){
        char[] dominoesBeforeIteration = domino.toCharArray();
        char[] dominoesAfterIteration = domino.toCharArray();


        for (int i = 0 ; i<iterations ; i++){
            for (int x=0; x<dominoesBeforeIteration.length -1 ;x++){
                if(x>0 && dominoesBeforeIteration[x]==Domino.right && dominoesBeforeIteration[x-1]==Domino.right
                        && x<dominoesBeforeIteration.length-1){
                    if(dominoesBeforeIteration[x+1]==Domino.left ||dominoesBeforeIteration[x+1]==Domino.vertical ){
                        dominoesAfterIteration[x]=Domino.vertical;
                    }
                }

                if(x>0 && dominoesBeforeIteration[x]==Domino.left && dominoesBeforeIteration[x+1]==Domino.left
                        && x<dominoesBeforeIteration.length-1){
                    if(dominoesBeforeIteration[x-1]==Domino.right ||dominoesBeforeIteration[x-1]==Domino.vertical ){
                        dominoesAfterIteration[x]=Domino.vertical;
                    }
                }
            }
            dominoesBeforeIteration=dominoesAfterIteration;
        }

        String newDominos = new String(dominoesAfterIteration);
        return newDominos;
    }

    public static void main(String[] args) {

       int action = 3;
       String tekst ="";
       int numbersOfIterations =0;


       while (action!=0){
           System.out.println("Wybierz metode wybierajac cyfre:");
           System.out.println("1. Iteracja do przodu");
           System.out.println("2. Iteracja wsteczna");
           System.out.println("0. zakończenie programu");
           Scanner scanner = new Scanner(System.in);
           action = scanner.nextInt();
           if(action==0){
               break;
           }
           if (action==1){
               System.out.println("Podaj uklad domina");
               Scanner scanner1 = new Scanner(System.in);
               tekst = scanner1.nextLine();
               System.out.println("Podaj ilosc iteracji");
               numbersOfIterations = scanner.nextInt();
               System.out.println("Oto wynik:");
               System.out.println(newStructure(tekst,numbersOfIterations));
           }
           if (action==2){
               System.out.println("Podaj uklad domina");
               Scanner scanner1 = new Scanner(System.in);
               tekst = scanner1.nextLine();
               System.out.println("Podaj ilosc iteracji");
               numbersOfIterations = scanner.nextInt();
               System.out.println("Oto wynik:");
               System.out.println(oldStructure(tekst,numbersOfIterations));
           }
       }


    }
}
