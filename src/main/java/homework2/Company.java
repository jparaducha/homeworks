/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import homework2.CustomLinkedList.CustomLinkedList;
import homework2.Exceptions.InvalidBudgetException;
import homework2.Exceptions.InvalidMaterialException;
import homework2.Exceptions.InvalidSalaryException;

/**
 * @author Paraducha Juan
 */
public class Company {

    public final String COMPANY_NAME = "ConstructionWorks";
    private String name;
    private Customer customer;

    public Company() {
    }

    public Company(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String TotalCost(Project p) throws InvalidSalaryException, InvalidBudgetException, InvalidMaterialException {
        double totalCost = 0;
        if (customer.getBudget() <= 0) {
            throw new InvalidBudgetException("Customer budget cannot be negative");
        }

        if (p.getArchitect().getSalary() < 0) {
            throw new InvalidSalaryException("Architect salary cannot be negative");
        }
        if (p.getArchitect().getSalary() == 0) {
            throw new InvalidSalaryException("Architect salary cannot be zero");
        }
        if (p.getBuilding().includesPlumbing()) {
            p.getPlumber().setBuilding(p.getBuilding());
            totalCost = p.getPlumber().TotalSalary();
        }

        totalCost += p.getBuilding().buildingCost() + p.getArchitect().TotalSalary() + p.bricklayersListCost();
        String text = "Total cost of the project: $" + totalCost + "\n";
        if (totalCost < this.customer.getBudget()) {
            text += "The customer is $" + (this.customer.getBudget() - totalCost) + " in surplus";
        }

        if (totalCost > this.customer.getBudget()) {
            text += "The customer is $" + (totalCost - this.customer.getBudget()) + " in shortage";
        }

        if (totalCost == this.customer.getBudget()) {
            text += "The customer has the right amount of money for the project";
        }

        if (!p.getPermit().getApproval()) {
            text += "\n The approval for the permit will cost an extra $" + p.getInspector().TotalSalary();
        }

        return text;
    }

    public String ConstructionTime(Project p) {
        int totalArea = p.getBuilding().getTotalArea();
        CustomLinkedList<Bricklayer> bricklayerCustomLinkedList = p.getWorkers();
        int areaPerWorker = totalArea / (bricklayerCustomLinkedList.length() + (int) (p.getExtraHoursWorkers().length() * 0.5));

        return "This project will take approximately " + (int) Math.ceil((areaPerWorker / 9) * p.getBuilding().TimeToBuild()) + " weeks to be completed";
    }
}
