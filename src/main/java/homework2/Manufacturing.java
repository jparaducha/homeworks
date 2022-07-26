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
public class Manufacturing extends Industrial {
    
    public Manufacturing(){
        super.yearlyTaxes = 6500;
        super.weeksOfConstruction = 16;
        costCalculation(28000);
    }

    @Override
    public String toString() {
        return "Manufacturing";
    }
    
}
