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
public class Education extends Public {
    
    public Education(){
        super.yearlyTaxes = 0;
        super.weeksOfConstruction = 20;
        costCalculation(24000);
    }

    @Override
    public String toString() {
        return "Education";
    }
    
    
    
}
