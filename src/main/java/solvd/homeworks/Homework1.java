/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solvd.Homeworks;
import java.util.Arrays;

/**
 *
 * @author Paraducha Juan
 */
public class Homework1 {
      
    public static void main(String[] args){
        
        System.out.println("Text from the main method");
        
        int[] array = new int[]{3, 7, 6, 13, 33, 9, -100, 25};
        int smallestValue = 10000;
        int biggestValue = -10000;
        
        int i = 0;
        
        while(i < array.length){
            System.out.println(array[i]);
            
            if(array[i]< smallestValue){
                smallestValue = array[i];
            }
            if(array[i]> biggestValue){
                biggestValue = array[i];
            }
            
            i++;
        }
        System.out.println("Smallest number: " + smallestValue
                + "\nBiggest number: " + biggestValue);
        
        
        System.out.println("Sorted array: " + Arrays.toString(selectionSort(array)));
        
     }
    
    
    public static int[] selectionSort(int[] array){
        
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
        
        return array;        
    }
    
}
