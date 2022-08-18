/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

/**
 * @author Paraducha Juan
 */
public class Company {

    public final String companyName = "ConstructionWorks";
    private String name;
    private Customer customer;

    public Company() {
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

    public double TotalCost(Project p) {
        return p.getBuilding().buildingCost() + p.getArchitect().TotalSalary() + p.bricklayersListCost();
    }

    public String ConstructionTime(Project p) {
        int totalArea = p.getBuilding().getTotalArea();
        int quantityOfWorkers = p.getWorkers().length();
        int areaPerWorker = totalArea / quantityOfWorkers;

        return "about a week";
    }

    //calculateCost(proyect)
}
