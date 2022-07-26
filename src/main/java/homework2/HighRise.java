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
public class HighRise extends Apartment {
    
    public HighRise(){
        super.yearlyTaxes = 4000;
        super.weeksOfConstruction = 52;
        costCalculation(75000);
    }

    @Override
    public String toString() {
        return "HighRise";
    }
    
    
}
