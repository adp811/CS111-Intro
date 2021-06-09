public class testJava {
    public static void main(String args[]){


        char [][] array = {

            {'w', 'r', 'x'},
            {'d', 'e', 'g'},
            {'c', 'q', 'u'}

        };

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] == 'x'){
                    if(j == array[i].length - 1){
                        StdOut.print("Found Row");
                    }
                }
            }
        }





    }
    
}
