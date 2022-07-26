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
public class Industrial extends Building {

    private int quantityOfWorkers = 0;

    @Override
    public String toString() {
        return "Industrial";
    }

    public void setWorkers(int quantity) {
        quantityOfWorkers = quantity;
    }

    public int getWorkers() {
        return quantityOfWorkers;
    }

}
