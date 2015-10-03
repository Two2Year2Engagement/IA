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
        for(int i =0;i<100;i++){
            chromossome[i] = new Chromossome(i);
            cAux[i] = new Chromossome();
        }
        Evolution evolve = new Evolution();
        for(int i=0;i<100;i++){
            System.out.println("Iteracao "+i);
            evolve.fitness(chromossome[i].getGene(), i);
        }
        /*while(evolve.getBestFitness() <= 0.99){
            
        }*/
    
    }    
}
