/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

/**
 *
 * @author Paraducha Juan
 */
public class Cottage extends House {
    
    
    public Cottage(){
        super.yearlyTaxes = 350;
        super.weeksOfConstruction = 4;
        
        costCalculation(7500);
    }

    @Override
    public String toString() {
        return "Cottage";
    }
    
    
}