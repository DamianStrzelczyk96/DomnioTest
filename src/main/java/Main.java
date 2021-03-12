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

    public static void main(String[] args) {

    }
}
