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
public class Public extends Building implements working {

    private int quantityOfWorkers = 0;

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

    public void setWorkers(int quantity) {
        quantityOfWorkers = quantity;
    }

    public int getWorkers() {
        return quantityOfWorkers;
    }
    
    @Override
    public void printWorkers(){
        System.out.println("This " + this.toString() + " building has " + this.quantityOfWorkers + " workers");
    }
}