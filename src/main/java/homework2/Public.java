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
public class Public extends Building {

    @Override
    public String toString() {
        return "Public";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void changeTaxes(int taxes) {
        super.yearlyTaxes = taxes;
    }
}
