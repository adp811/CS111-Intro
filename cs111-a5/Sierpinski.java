/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author: Aryan Patel - adp182
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        return (Math.sqrt(3.0)/2) * length;  
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {
        
        StdDraw.setPenColor(StdDraw.BLACK);
        double triangleHeight = height(length);
        double[] xArr = {x,x - (length/2), x + (length/2)};
        double[] yArr = {y,y + triangleHeight,y + triangleHeight};
        //System.out.println("x: " + x + " y: " + y + " length: " + length);
        StdDraw.filledPolygon(xArr, yArr);
	
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {
 
        if(n == 0) return; //base case      

        filledTriangle(x, y, length); //draw first filled triangle

        sierpinski(n-1, x + (length/2), y, length/2); 
        sierpinski(n-1, x - (length/2), y, length/2); 
        sierpinski(n-1, x, y + height(length), length/2);
        
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {

        //outline triangle:
        double[] outlineX = {0.0, 1.0, 0.5};
        double[] outLineY = {0.0, 0.0, height(1)};
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.polygon(outlineX, outLineY);

        int n = Integer.parseInt(args[0]); //n input value 

        sierpinski(n, 0.5, 0.0, 0.5); //call recursive method

    }
}
