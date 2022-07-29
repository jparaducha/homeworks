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
public class Distribution extends Industrial {

    public Distribution() {
        super.yearlyTaxes = 4500;
        super.weeksOfConstruction = 20;
        costCalculation(25000);
    }

    @Override
    public String toString() {
        return "Distribution";
    }

}
