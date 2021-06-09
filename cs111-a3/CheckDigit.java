/*************************************************************************
 *  Compilation:  javac CheckDigit.java
 *  Execution:    java CheckDigit 020131452
 *
 *  @author: Aryan Patel 
 *
 *  Takes a 12 or 13 digit integer as a command line argument, then computes
 *  and displays the check digit
 *
 *  java CheckDigit 048231312622
 *  0
 *
 *  java CheckDigit 9780470458310
 *  0
 * 
 *  java CheckDigit 9780470454310
 *  8
 * 
 *  Print only the check digit character, nothing else.
 *
 *************************************************************************/

public class CheckDigit {

    public static void main (String[] args) {

        // WRITE YOUR CODE HERE
        
        long input = Long.parseLong(args[0]);
        int digitCount = String.valueOf(input).length();

        int sum1 = 0;
        int sum2 = 0;

        if (digitCount == 12){
            int counter = 12;

            while(counter > 0){
                if (counter % 2 == 0){
                    sum1 += (int) (input % 10);
                } else{
                    sum2 += (int) (input % 10);
                }

                input = input / 10;
                counter -= 1;
            }

        } else if (digitCount == 13){
            int counter = 13;
            
            while(counter > 0){
                if (counter % 2 == 1){
                    sum1 += (int) (input % 10);
                } else{
                    sum2 += (int) (input % 10);
                }

                input = input / 10;
                counter -= 1;
            }

        } else {
            int counter = 11; 

            while(counter > 0){
                if (counter % 2 == 1){
                    sum1 += (int) (input % 10);
                } else{
                    sum2 += (int) (input % 10);
                }

                input = input / 10;
                counter -= 1;
            }


        }

        int digit1 = sum1 % 10;
        int digit2 = sum2 % 10;

        digit2 = digit2 * 3;
        digit2 = digit2 % 10;

        int total = (digit1 + digit2) % 10;

        System.out.print(total);

    }
}