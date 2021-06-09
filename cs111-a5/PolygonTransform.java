/*************************************************************************
 *  Compilation:  javac PolygonTransform.java
 *  Execution:    java PolygonTransform
 *
 *  @author: Aryan Patel - adp182
 *
 *************************************************************************/

public class PolygonTransform {


    // Returns a new array that is an exact copy of the given array. 
    // The given array is not mutated. 
    public static double[] copy(double[] array) {
        
        double [] returnArray = new double[array.length]; //new local array 
        for (int i = 0; i < returnArray.length; i ++){
            returnArray[i] = array[i]; //copy input array into return array
        }

        return returnArray; //return copied array

    }
    
    // Scales the given polygon by the factor alpha. 
    public static void scale(double[] x, double[] y, double alpha) {

        for(int i = 0; i < x.length; i++){ // scale x-values by alpha 
            x[i] = x[i] * alpha;
        }

        for(int i = 0; i < y.length; i++){ // scale y-values by alpha
            y[i] = y[i] * alpha;
        }

    }
    
    // Translates the given polygon by (dx, dy). 
    public static void translate(double[] x, double[] y, double dx, double dy) {
       
        for(int i = 0; i < x.length; i++){ // translates x-values by dx 
            x[i] = x[i] + dx;
        }

        for(int i = 0; i < y.length; i++){ // translates y-values by dy
            y[i] = y[i] + dy;
        }
    
    }
    
    // Rotates the given polygon theta degrees counterclockwise, about the origin. 
    public static void rotate(double[] x, double[] y, double theta) {

        double thetaRadians = Math.toRadians(theta);

        double[] xRef = copy(x);
        double[] yRef = copy(y);

        for(int i = 0; i < x.length; i++){ 

            x[i] = (xRef[i] * Math.cos(thetaRadians)) - (yRef[i] * Math.sin(thetaRadians));
           
        }

        for (int i = 0; i < y.length; i++){

            y[i] = (yRef[i] * Math.cos(thetaRadians)) + (xRef[i] * Math.sin(thetaRadians));

        }

    }

    // Tests each of the API methods by directly calling them. 
    public static void main(String[] args) {

        // method tests:

        //scale test
        /*StdDraw.setScale(-5.0, +5.0); 
        double[] x = { 0, 1, 1, 0 }; 
        double[] y = { 0, 0, 2, 1 }; 
        double alpha = 2.0; 
        StdDraw.setPenColor(StdDraw.RED); 
        StdDraw.polygon(x, y); 
        scale(x, y, alpha); 
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y);*/


        //translate test
        /*StdDraw.setScale(-5.0, +5.0); 
        double[] x = { 0, 1, 1, 0 }; 
        double[] y = { 0, 0, 2, 1 }; 
        double dx = 2.0, dy = 1.0; 
        StdDraw.setPenColor(StdDraw.RED); 
        StdDraw.polygon(x, y); 
        translate(x, y, dx, dy); 
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y);*/


        //rotate test:
        /*StdDraw.setScale(-5.0, +5.0); 
        double[] x = { 0, 1, 1, 0 }; 
        double[] y = { 0, 0, 2, 1 }; 
        double theta = 90.0; 
        StdDraw.setPenColor(StdDraw.RED); 
        StdDraw.polygon(x, y); 
        rotate(x, y, theta); 
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y);*/

    }
}
