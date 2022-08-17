package homework2;

import homework2.CustomLinkedList.CustomLinkedList;
import homework2.CustomLinkedList.Node;

public class Project {

    private String city;
    private Customer customer;
    private Architect architect;
    private Building building;
    private Permit permit;
    private CustomLinkedList<Bricklayer> bricklayerCustomLinkedList = new CustomLinkedList<>();

    public Project(){};

    public Project(Architect architect, Customer customer, Building building, Permit permit){
    this.architect = architect;
    this.customer = customer;
    this.building = building;
    this.permit = permit;
    };

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setArchitect(Architect architect){
        this.architect = architect;
    }

    public Architect getArchitect(){
        return architect;
    }

    public void setBuilding(Building building){
        this.building = building;
    }

    public Building getBuilding(){
        return building;
    }

    public void setPermit(Permit permit){
        this.permit = permit;
    }

    public Permit getPermit(){
        return permit;
    }

    public void addWorker(Bricklayer bricklayer){
        this.bricklayerCustomLinkedList.add(bricklayer);
    }

    public String getWorkers(){
        return this.bricklayerCustomLinkedList.toString();
    }

    private double bricklayersListCost(){
        double total;
        total = 0;
        int counter;
        counter = 2;
        Node<Bricklayer> temp = new Node<>(null);

        if (this.bricklayerCustomLinkedList.head == null) {
            return 0;
        } else {

            Node<Bricklayer> X = this.bricklayerCustomLinkedList.head;

            total = total + X.data.TotalSalary();
            while (X.next != null) {
                X = X.next;
                total =  total + X.data.TotalSalary();
                counter++;
            }

        }
        return total;
    }

    public double TotalCost(){
        return building.buildingCost() + architect.TotalSalary() + bricklayersListCost();
    }

}
