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
public class Architect extends Human implements ISalary {

    public int yearsOfExperience;
    public String shift;

    @Override
    public int TotalSalary() {
        int salary;
        salary = 0;
        if ("FullTime".equals(shift)) {
            salary = yearsOfExperience * 2500;
        }
        if ("PartTime".equals(shift) || "".equals(shift)) {
            salary = yearsOfExperience * 1000;
        }

        if (salary > 20000) {
            salary = 20000;
        }

        return salary;
    }

    public void setExperience(int years) {
        this.yearsOfExperience = years;
    }

    public int getExperience() {
        return yearsOfExperience;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getShift() {
        return shift;
    }

}
