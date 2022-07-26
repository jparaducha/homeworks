/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

/**
 *
 * @author Paraducha Juan
 */
public class Task2 {
    
    public static void main(String[] args){
  
        int[] array = new int[]{3, 7, 6, 13, 33, 9, -100, 25};
        int smallestValue = array[0];
        int biggestValue = array[0];
        
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
        }
}