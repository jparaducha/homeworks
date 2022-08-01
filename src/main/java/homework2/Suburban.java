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
public class Suburban extends House implements privateProperty, homeOwner {

    public Suburban() {
        super.yearlyTaxes = 1000;
        super.weeksOfConstruction = 4;
        costCalculation(12000);
    }

    @Override
    public String toString() {
        return "Suburban";
    }

    @Override
    public void changeMaterial() {
        System.out.println("Introduce new type of material: ");

        this.material = scan.nextLine();
    }

    @Override
    public void HOACharge(String className) {

        System.out.println("You have to pay " + homework2.homeOwner.BASIC_TAX * 4.5 + " to the Home Owner Association");

    }

}
