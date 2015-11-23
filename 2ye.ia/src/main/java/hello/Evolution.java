/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author jnboeira
 */
public class Evolution {
    private double[] fitness;
    private double bestFitness;
    private int bestFitnessI;
    
    public Evolution(){
        bestFitness = -1;
        //System.out.println(bestFitness);
        fitness = new double[100];
        for(int i=0;i<100;i++){
            fitness[i] = -1;
            //System.out.println(fitness[i]);
        }
        bestFitnessI = 0;
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
    
    public void fitness(Chromossome[] chrom){
        for(int i = 0;i<100;i++){
            int[] gene = chrom[i].getGene();
            //for(int k=0;k<44;k++){
            //    System.out.print(gene[k]);
            //}
            //System.out.println();
            double x = convX(gene);
            double y = convY(gene);
            fitness[i] = bf6(x, y);
            //System.out.println("Fitness "+i+": "+fitness[i]);
            if(fitness[i] > bestFitness){
                bestFitness = fitness[i];
                bestFitnessI = i;
            }    
        }
         System.out.println("Best Fitness "+bestFitness);
    }
    
    private double bf6(double x, double y){
        double mant = Math.sin(Math.sqrt(x*x +y*y));
        double div = (x*x +y*y);
        double res = 0.5 + (mant*mant - 0.5)/(1 + 0.001*div*div);
        //System.out.println("bf6: "+res);
        return res;
    }
    
    private double convX(int[] gene){
        double sum = 0;
        for(int i=0;i<22;i++){
            sum += gene[i]*Math.pow(2.0, (double) i);
        }
        sum = sum/20971.5 - 100;
        //System.out.println("X: "+sum);
        return sum;
    }
    
    private double convY(int[] gene){
        double sum = 0;
        for(int i=22;i<44;i++){
            sum += gene[i]*Math.pow(2.0, (double) (i - 22));
        }
        sum = sum/20971.5 - 100;
        //System.out.println("Y: "+sum);
        return sum;
    }
    
    public void crossover(Chromossome[] chrom, Chromossome[] aux){
        Random rg = new Random();
        int rand = rg.nextInt(1000001) % 100;
        for(int i =0;i < rand;i++){
            //System.out.println("Iteracao"+i);
            int i1 = tournament(), i2 = tournament();
            while(i1 == i2){
                i2 = tournament();
            }
            //System.out.println("I1: "+i1+" I2: "+i2);
            for(int k = 0; k < 22;k++){
                aux[i].setGeneI(chrom[i1].getGeneI(k), k);
            }
            for(int k = 22; k < 44;k++){
                aux[i].setGeneI(chrom[i2].getGeneI(k), k);
            }
            //chrom[i1].printGene(); chrom[i2].printGene();
            //aux[i].printGene(); System.out.println();
        }
        for(int i = rand;i < 100;i++){
            aux[i].setGene(chrom[i].getGene());
        }
        mutate(aux);
    }
    
    private void mutate(Chromossome[] aux){
        Random rg = new Random();
        for(int i =0;i < 100;i++){
            int randMut = rg.nextInt(i+300) % 10;
            //System.out.println("Mut? "+randMut);
            //if(randMut == 1){
                int randGene = rg.nextInt(randMut+i+139) % 44;
                //System.out.println("Gene: "+randGene);
                int valGene = rg.nextInt(randMut+i+1001) % 2;
                //System.out.println("Val: "+valGene);
                aux[i].setGeneI(valGene, randGene);
            //}
        }
    }
    
    public void convertGenes(Chromossome[] chrom, Chromossome[] aux){
        for(int i = 0;i < 100;i++){
            for(int k = 0;k < 44;k++){
                chrom[i].setGeneI(aux[i].getGeneI(k), k);
            }
        }
    }
    
    private int tournament(){
        Random rg = new Random();
        int[] idx = new int[5];        
        for(int i = 0;i < 5;i++){
            idx[i] = rg.nextInt(250+i) % 100;
        }
        int best = getBestIdx(idx);
    
        return best;
    }
    
    private int getBestIdx(int[] idx){
        double bestFit = -1;
        int bestI = 0;
        for(int i = 0;i < 5;i++){
            if(fitness[idx[i]] > bestFit){
                bestFit = fitness[idx[i]];
                bestI = idx[i];
            }
        }
        //System.out.println("Best I: "+bestI);
        
        return bestI;
    }

    public int getBestFitnessI() {
        return bestFitnessI;
    }
    
    
}
