/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

/**
 * @author Paraducha Juan
 */
public class Architect extends Worker {

    private String planType;

    @Override
    public int TotalSalary() {
        int salary;
        salary = 0;
        if ("FullPlan".equals(planType)) {
            salary = super.getExperience() * 2500;
        }
        if ("BasicPlan".equals(planType) || "".equals(planType)) {
            salary = super.getExperience() * 1000;
        }

        if (salary > 20000) {
            salary = 20000;
        }

        return salary;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

}
