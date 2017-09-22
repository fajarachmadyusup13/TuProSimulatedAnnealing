/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuprosimulatedannealingbu;

import java.util.Random;

/**
 *
 * @author ghost
 */

public class SimulatedAnnealing {
    
    public static final double RATE_OF_COOLING      = 0.009;
    public static final double INITIAL_TEMPERATURE  = 1000;
    public static final double MIN_TEMPERATURE      = 0.99;
    
    public void findMinima(){
        double temperature              = INITIAL_TEMPERATURE;
        double acceptanceProbability    = 1.0;
        double randomNumber             = Math.random();
        State newState                  = randomized();
        State currentState              = newState;
        State bestSoFar                 = currentState;
        double minimum                  = bestSoFar.formula();
        double bestX1                   = bestSoFar.getX1();
        double bestX2                   = bestSoFar.getX2();
        
        while (temperature > MIN_TEMPERATURE) {
            double e                    = currentState.formula() - newState.formula();
            if (currentState.formula() - newState.formula() > 0) {
                currentState    = newState;
                bestSoFar       = newState;
                
            }else{
                acceptanceProbability   = Math.exp(e/temperature);
                if (acceptanceProbability > randomNumber) {
                    currentState    = newState;
//                    bestSoFar       = newState;
//                    bestX1          = currentState.getX1();
//                    bestX2          = currentState.getX2();
                }
            }
            if (minimum > bestSoFar.formula()) {
                minimum = bestSoFar.formula();
                bestX1          = bestSoFar.getX1();
                bestX2          = bestSoFar.getX2();
            }
            
            System.out.print("|" + String.format("%15s %5s", String.format("%.8f", newState.getX1()), "|"));
            System.out.print(String.format("%15s %5s", String.format("%.8f", newState.getX2()), "|"));
            System.out.print(String.format("%7s %2s", String.format("%.2f", temperature), "|"));
            System.out.print(String.format("%16s %4s", String.format("%.8f", newState.formula()), "|"));
            System.out.print(String.format("%16s %4s", String.format("%.8f", currentState.formula()), "|"));
            System.out.print(String.format("%16s %4s", String.format("%.8f", bestSoFar.formula())  , "|"));
            System.out.print(String.format("%5s %1s", String.format("%.2f", randomNumber), "|"));
            System.out.println(String.format("%5s %1s", String.format("%.2f", acceptanceProbability), "|"));
            
            randomNumber    = Math.random();
            newState        = randomized();
            
            
            temperature *= 1-RATE_OF_COOLING;
        }
        
        System.out.println("----------------------------------------------");
        System.out.println("| Best so Far  : " + String.format("%23s %5s", String.format("%.8f", minimum), "|"));
//        System.out.println("| Minimum      : " + String.format("%23s %5s", String.format("%.8f", minimum), "|"));
        System.out.println("| x1           : " + String.format("%23s %5s", String.format("%.8f", bestX1), "|"));
        System.out.println("| x2           : " + String.format("%23s %5s", String.format("%.8f", bestX2), "|"));
        System.out.println("----------------------------------------------");
    }
    
    public State randomized(){
        double max      = 10.0d;
        double min      = -10.0d;
        Random ran      = new Random();
        double x1       = ran.nextDouble()* (max - min) + min;
        double x2       = ran.nextDouble()* (max - min) + min;
        
        State newState  = new State(x1, x2);
        return newState;
    }
}
