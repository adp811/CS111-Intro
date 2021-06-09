/*************************************************************************
 *  Compilation:  javac FindDuplicate.java
 *  Execution:    java FindDuplicate
 *
 *  @author: Aryan Patel; adp182
 *
 * FindDuplicate that reads n integer arguments from the command line 
 * into an integer array of length n, where each value is between is 1 and n, 
 * and displays true if there are any duplicate values, false otherwise.
 *
 *  % java FindDuplicate 10 8 5 4 1 3 6 7 9
 *  false
 *
 *  % java FindDuplicate 4 5 2 1 
 *  true
 *************************************************************************/

public class FindDuplicate {

    public static void main(String[] args) {

		int[] array = new int[args.length];
		boolean isDuplicate = false;
		
		for (int i = 0; i < array.length; i++){

			int num = Integer.parseInt(args[i]);
			array[i] = num;

		}
		
		for(int i = 0; i < array.length; i++){
			for(int n = i + 1; n < array.length; n++){
				if(array[i] == array[n]){
					isDuplicate = true;
				}
			}

		}

		System.out.println(isDuplicate);


		//WRITE YOUR CODE HERE
	}
}
