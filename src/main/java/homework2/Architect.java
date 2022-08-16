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
    private double salary;

    public Architect(){
        this.salary = 1900;
        super.setExperience(1);
    }

    public Architect(int salary){
        this.salary = salary;
    }

    public Architect(int salary, String plan, int experience){
        this.salary = salary;
        this.planType = plan;
        super.setExperience(experience);
    }

    @Override
    public double TotalSalary() {
        if ("FullPlan".equals(planType)) {
            salary = super.getExperience() * salary * 1.7;
        }
        if ("BasicPlan".equals(planType) || "".equals(planType)) {
            salary = super.getExperience() * salary * 1.2;
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
