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
public class Worker extends Human implements ISalary {

    public int shiftHours;
    public int quantity;

    public Worker(int q) {
        this.quantity = q;
    }

    public Worker() {
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setShift(int shift) {
        this.shiftHours = shift;
    }

    public int getShift() {
        return shiftHours;
    }

    public int TotalSalary() {
        return shiftHours * quantity;
    }

}
