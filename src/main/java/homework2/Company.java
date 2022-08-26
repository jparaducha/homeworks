/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import homework2.customLinkedList.CustomLinkedList;
import homework2.exceptions.InvalidBudgetException;
import homework2.exceptions.InvalidMaterialException;
import homework2.exceptions.InvalidSalaryException;
import homework2.interfaces.IRise;

import java.util.ArrayList;

/**
 * @author Paraducha Juan
 */
public class Company {

    public final String COMPANY_NAME = "ConstructionWorks";
    private final ArrayList<Customer> listOfCustomers = new ArrayList<>();
    private String name;

    public Company() {
    }

    private double applyRaise(Project p, IRise rise) throws InvalidSalaryException {
        return rise.getSalariesWithRaise(p);
    }

    public double raiseLambda(Project proyecto, int amount) throws InvalidSalaryException {
        return this.applyRaise(proyecto, (p) -> p.bricklayersListCost() + (p.getWorkers().length() * amount));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomers() {
        return listOfCustomers;
    }

    public void setCustomer(Customer customer) {
        this.listOfCustomers.add(customer);
    }

    public String totalCost(Project p, Customer customer) throws InvalidSalaryException, InvalidBudgetException, InvalidMaterialException {
        if (this.listOfCustomers.indexOf(customer) == -1) {
            this.listOfCustomers.add(customer);
        }

        int timeInMonths = (int) Math.ceil(constructionTime(p) / 4);
        double totalCost = 0;
        if (customer.getBudget() <= 0) {
            throw new InvalidBudgetException("Customer budget cannot be negative");
        }

        if (p.getArchitectSalary() < 0) {
            throw new InvalidSalaryException("Architect salary cannot be negative");
        }
        if (p.getArchitectSalary() == 0) {
            throw new InvalidSalaryException("Architect salary cannot be zero");
        }
        if (p.getBuilding().includesPlumbing()) {
            p.getPlumber().setBuilding(p.getBuilding());
            totalCost = p.getPlumber().totalSalary() * timeInMonths;
        }

        totalCost += p.getBuilding().buildingCost() + p.getArchitectSalary() + p.bricklayersListCost() * timeInMonths;
        String text = "Total cost of the project: $" + totalCost + "\n";
        if (totalCost < customer.getBudget()) {
            text += "The customer is $" + (customer.getBudget() - totalCost) + " in surplus";
        }

        if (totalCost > customer.getBudget()) {
            text += "The customer is $" + (totalCost - customer.getBudget()) + " in shortage";
        }

        if (totalCost == customer.getBudget()) {
            text += "The customer has the right amount of money for the project";
        }

        if (!p.getPermit().getApproval()) {
            text += "\n The approval for the permit will cost an extra $" + p.getInspector().totalSalary();
        }

        return text;
    }

    public int constructionTime(Project p) {
        int totalArea = p.getBuilding().getTotalArea();
        CustomLinkedList<Bricklayer> bricklayerCustomLinkedList = p.getWorkers();
        int areaPerWorker = totalArea / (bricklayerCustomLinkedList.length() + (int) (p.getExtraHoursWorkers().length() * 0.5));

        return (int) Math.ceil((areaPerWorker / 10) * p.getBuilding().timeToBuild());
    }
}
