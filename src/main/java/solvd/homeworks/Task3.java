/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solvd.homeworks;

import java.util.Arrays;

/**
 *
 * @author Paraducha Juan
 */
public class Task3 {
    
        public static void main(String[] args){
            
        
        int[] array = new int[]{3, 7, 6, 13, 33, 9, -100, 25};
        
        selectionSort(array);
        
        System.out.println("Sorted array: ");
        
        for(int element : array){
            System.out.println(element);
        }
        
        
        }
        
        public static void selectionSort(int[] array){
        
        for(int i = 0; i<array.length; i++){
            int smallestInRun = i;
            for(int j = i; j<array.length; j++){
                if(array[j]< array[smallestInRun]){
                    smallestInRun = j;
                }
            
            }
            
            int aux = array[i];
            array[i] = array[smallestInRun];
            array[smallestInRun] = aux;
        }       
    }
}
