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
public class Health extends Public {

    public Health() {
        super.yearlyTaxes = 0;
        super.weeksOfConstruction = 52;
        costCalculation(50000);
    }

    @Override
    public String toString() {
        return "Health";
    }

}