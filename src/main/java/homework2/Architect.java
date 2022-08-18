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

    public Architect() {
        super(2500);
        super.setExperience(1);
    }

    public Architect(int salary) {
        super(salary);
    }

    public Architect(int salary, String plan, int experience) {
        super(salary);
        this.planType = plan;
        super.setExperience(experience);
    }

    @Override
    public double TotalSalary() {
        if ("FullPlan".equals(planType)) {
            super.setSalary((int) (super.getExperience() * super.getSalary() * 1.7));
        }
        if ("BasicPlan".equals(planType) || "".equals(planType)) {
            super.setSalary((int) (super.getExperience() * super.getSalary() * 1.2));
        }

        if (super.getSalary() > 20000) {
            super.setSalary(20000);
        }

        return super.getSalary();
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }
}
