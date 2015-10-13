package hello;
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
public class BF6Main {
    public static void main(String[] args) {
        Random rg = new Random();
        Chromossome[] chromossome = new Chromossome[100];
        Chromossome[] cAux = new Chromossome[100];
        int count = 0;
        for(int i =0;i<100;i++){
            chromossome[i] = new Chromossome(i);
            cAux[i] = new Chromossome();
        }
        Evolution evolve = new Evolution();
        evolve.fitness(chromossome);
        
        while(evolve.getBestFitness() <= 0.999){
            evolve.crossover(chromossome, cAux);
            evolve.convertGenes(chromossome, cAux);
            evolve.fitness(chromossome);
            System.out.println("Iteracao "+count+" BestFitness = "+evolve.getBestFitness());
            evolve.setBestFitness(0.0); 
            count++;
        }
    
    }    
}
