/*************************************************************************
 *  Compilation:  javac RURottenTomatoes.java
 *  Execution:    java RURottenTomatoes
 *
 *  @author: Aryan Patel, adp182
 *
 * RURottenTomatoes creates a 2 dimensional array of movie ratings 
 * from the command line arguments and displays the index of the movie 
 * that has the highest sum of ratings.
 *
 *  java RURottenTomatoes 3 2 5 2 3 3 4 1
 *  0
 *************************************************************************/

public class RURottenTomatoes {

    public static void main(String[] args) {

		int rows = Integer.parseInt(args[0]);
		int columns = Integer.parseInt(args[1]);

		int [][] array = new int[rows][columns];
		//System.out.println("row size: "+ array.length);
		//System.out.println("column size: "+ columns);
				
		int[] input = new int[args.length - 2];
		//System.out.println("remaining length: "+input.length);

		int sum = 0;
		int maxRating = 0;
		int maxRatingIndex = 0;

		for(int i = 2; i < args.length; i++){
			
			int number = Integer.parseInt(args[i]);
			input[i-2] = number;

		}

		/*System.out.println("input array contents: ");
		for(int i = 0; i < input.length; i++){
			
			System.out.println(input[i]);

		}*/

		int counter = 0;

		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				array[i][j] = input[counter];
				counter++;
			}
		} 


		/*System.out.println("2D Array Contents: ");
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[0].length; j++){
				System.out.println(array[i][j]);
			}
			System.out.println("new row");
		} */
		
		/*System.out.println("2D Array Contents: ");
		for(int i = 0; i < array[0].length; i++){
			for(int j = 0; j < array.length; j++){
				System.out.println(array[j][i]);
			}
			System.out.println("column");
		}*/

	
		for(int i = 0; i < array[0].length; i++){
			for(int j = 0; j < array.length; j++){
				sum = sum + array[j][i];
			}
			
			if(sum > maxRating) {
				maxRating = sum;
				maxRatingIndex = i;
			}

			sum = 0;

		}

		//System.out.println("max rating sum: "+ maxRating);
		//System.out.println("max max index "+ maxRatingIndex);	
		
		System.out.println(maxRatingIndex); // Final Output 	
		
	}
}
