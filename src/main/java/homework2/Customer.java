/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

/**
 * @author Paraducha Juan
 */
public class Customer extends Human {

    private int budget;

    public Customer() {
    }

    public Customer(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
