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
        double total = 0;
        if ("FullPlan".equals(planType)) {
            total = (int) (super.getExperience() * super.getSalary() * 1.7);
        }
        if ("BasicPlan".equals(planType) || "".equals(planType)) {
            total = (int) (super.getExperience() * super.getSalary() * 1.2);
        }

        if (total >= 20000) {
            System.out.println("????" + super.getSalary());
            super.setSalary(20000);
            total = 20000;
        }

        return total;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }
}
