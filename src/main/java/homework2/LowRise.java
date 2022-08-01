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
public final class LowRise extends Apartment implements privateProperty {

    public LowRise() {
        super.yearlyTaxes = 2200;
        super.weeksOfConstruction = 16;
        costCalculation(20000);
    }

    @Override
    public String toString() {
        return "LowRise";
    }

    @Override
    public void changeMaterial() {
        System.out.println("Introduce new type of material: ");

        this.material = scan.nextLine();
    }

}
