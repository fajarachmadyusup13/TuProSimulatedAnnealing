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
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        heading();
        new SimulatedAnnealing().findMinima();
    }
    
    public static void heading(){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("|" + String.format("%10s %10s", "x1", "|"));
        System.out.print(String.format("%10s %10s", "x2", "|"));
        System.out.print(String.format("%6s %3s", "Temp", "|"));
        System.out.print(String.format("%13s %7s", "New Func", "|"));
        System.out.print(String.format("%15s %5s", "Current Func", "|"));
        System.out.print(String.format("%15s %5s", "Best So Far", "|"));
        System.out.print(String.format("%5s %1s", "Rand", "|"));
        System.out.println(String.format("%5s %1s", "Prob", "|"));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }
    
}
