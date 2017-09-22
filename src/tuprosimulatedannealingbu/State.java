/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuprosimulatedannealingbu;

/**
 *
 * @author ghost
 */
public class State {
    double x1;
    double x2;

    public State(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }
    
    public double formula(){
        double x1 = this.getX1();
        double x2 = this.getX2();
        double result = ((4 - 2.1 * Math.pow(x1, 2D) + (Math.pow(x1, 4D)/3)) * Math.pow(x1, 2D)) + 
                        (x1 * x2) + ((-4 + 4 * Math.pow(x2, 2D)) * Math.pow(x2, 2D));
        return result;
    }
}
