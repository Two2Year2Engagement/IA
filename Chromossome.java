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
public class Chromossome {
    private int[] gene;
    
    public Chromossome(int j){
        gene = new int[44];
        Random rg = new Random();
        System.out.print("Chromosome "+j+": ");
        for(int i=0;i<44;i++){
            gene[i] = ((rg.nextInt(997*(3+j))) + rg.nextInt(1373*(3+i))) % 2;
            System.out.print(gene[i]);
        }
        System.out.println();
    }
    
    public Chromossome(){
        gene = new int[44];
        for(int i=0;i<44;i++){
            gene[i] = -1;
            System.out.print(gene[i]);
        }
        System.out.println();
    }

    public int[] getGene() {
        return gene;
    }

    public void setGene(int[] gene) {
        this.gene = gene;
    }
    
    public int getGeneI(int i) {
        return gene[i];
    }

    public void setGeneI(int gene, int i) {
        this.gene[i] = gene;
    }
  
}
