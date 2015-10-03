/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jnboeira
 */
public class Evolution {
    private double[] fitness;
    private double bestFitness;
    
    public Evolution(){
        bestFitness = -1;
        //System.out.println(bestFitness);
        fitness = new double[100];
        for(int i=0;i<100;i++){
            fitness[i] = -1;
            //System.out.println(fitness[i]);
        }
    }

    public double[] getFitness() {
        return fitness;
    }

    public void setFitness(double[] fitness) {
        this.fitness = fitness;
    }
    
    public double getFitnessI(int i) {
        return fitness[i];
    }

    public void setFitnessI(double fitness, int i) {
        this.fitness[i] = fitness;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }
    
    public void fitness(int[] gene, int i){
        double x = convX(gene);
        double y = convY(gene);
        fitness[i] = bf6(x, y);
        if(fitness[i] > bestFitness){
            bestFitness = fitness[i];
        }
            
    }
    
    public double bf6(double x, double y){
        double mant = Math.sin(Math.sqrt(x*x +y*y));
        double div = (x*x +y*y);
        double res = 0.5 + (mant*mant - 0.5)/(1 + 0.001*div*div);
        System.out.println("bf6: "+res);
        return res;
    }
    
    public double convX(int[] gene){
        double sum = 0;
        for(int i=0;i<22;i++){
            sum += gene[i]*Math.pow(2.0, (double) i);
        }
        sum = sum/20971.5 - 100;
        System.out.println("X: "+sum);
        return sum;
    }
    
    public double convY(int[] gene){
        double sum = 0;
        for(int i=22;i<44;i++){
            sum += gene[i]*Math.pow(2.0, (double) (i - 22));
        }
        sum = sum/20971.5 - 100;
        System.out.println("Y: "+sum);
        return sum;
    }
    
    public void crossover(){
    
    }
    
    public void mutate(){
    
    }
    
    public void tournament(){
    
    }
}
