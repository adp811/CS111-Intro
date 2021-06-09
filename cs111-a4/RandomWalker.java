/*************************************************************************
 *  Compilation:  javac RandomWalker.java
 *  Execution:    java RandomWalker 10
 *
 *  @author: Aryan Patel, adp182
 *
 * The program RandomWalker that takes an int command-line argument n
 * and simulates the motion of a random walk for n steps. Print the
 * location at each step (including the starting point), treating the
 * starting point as the origin (0, 0). Also, print the square of the
 * final Euclidean distance from the origin.
 *
 *  % java RandomWalker 10
 * (0,0)
 * (-1,0)
 * (-1,-1)
 * (-1,-2)
 * (-1,-3)
 * (-1,-4)
 * (-1,-5)
 * (0,-5)
 * (-1,-5)
 * (-2,-5)
 * (-2,-4)
 * Squared distance = 20.0
 *
 *************************************************************************/

public class RandomWalker {

    public static void main(String[] args) {

    // WRITE YOUR CODE HERE
    
    int steps = Integer.parseInt(args[0]);
    
    int xCoordinate = 0;
    int yCoordinate = 0;

    System.out.println("(" + xCoordinate + ", " + yCoordinate + ")");
    
    for(int i = 0; i < steps; i++){

        int direction = (int) (Math.random() * 4) + 1;

        if (direction == 1) yCoordinate ++; //North
        if (direction == 2) xCoordinate ++; //East
        if (direction == 3) yCoordinate--; //South 
        if (direction == 4) xCoordinate --; //West
        
        System.out.println("(" + xCoordinate + ", " + yCoordinate + ")");

    }
        double squaredDistance = (Math.pow(xCoordinate, 2)) + (Math.pow(yCoordinate, 2));
        System.out.println("Squared distance = " + squaredDistance);

    }
}
