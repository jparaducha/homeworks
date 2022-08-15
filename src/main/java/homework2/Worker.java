/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

/**
 * @author Paraducha Juan
 */
public abstract class Worker extends Human {

    public int shiftHours;
    private int yearsOfExperience;

    public int getShift() {
        return shiftHours;
    }

    public void setShift(int shift) {
        this.shiftHours = shift;
    }

    public int getExperience() {
        return yearsOfExperience;
    }

    public void setExperience(int years) {
        this.yearsOfExperience = years;
    }

    public abstract int TotalSalary();
}
