/*************************************************************************
 *  Compilation:  javac TwoSmallest.java
 *  Execution:    java TwoSmallest 1.1 6.9 0.3
 *
 *  @author: Aryan Patel 
 *
 *  The program TwoSmallest takes a set of double command-line
 *  arguments and prints the smallest and second-smallest number, in that
 *  order. It is possible for the smallest and second-smallest numbers to
 *  be the same (if the sequence contains duplicate numbers).
 *
 *  Note: display one number per line
 *
 *  % java TwoSmallest 17.0 23.0 5.0 1.1 6.9 0.3
 *  0.3
 *  1.1
 *
 *  % java TwoSmallest 17.0 23.0 5.0 1.1 6.9 0.3
 *  0.3
 *  0.3
 *************************************************************************/

public class TwoSmallest {

    public static void main(String[] args) {


        Double min = Double.MAX_VALUE; 
        Double min2 = Double.MAX_VALUE;

        for (int i = 0; i < args.length; i++) {

            if(Double.parseDouble(args[i]) < min) {
                min2 = min;
                min = Double.parseDouble(args[i]);
           
            } else if (Double.parseDouble(args[i]) < min2) {
                min2 = Double.parseDouble(args[i]); 
            }
         
        }

        System.out.println(min);
        System.out.println(min2);

        
        // WRITE YOUR CODE HERE
    }

}
