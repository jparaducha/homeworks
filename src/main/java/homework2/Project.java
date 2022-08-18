package homework2;

import homework2.CustomLinkedList.CustomLinkedList;
import homework2.CustomLinkedList.Node;

public class Project {

    private final CustomLinkedList<Bricklayer> bricklayerCustomLinkedList = new CustomLinkedList<>();
    private String city;
    private Architect architect;
    private Building building;
    private Permit permit;

    public Project() {
    }

    public Project(Architect architect, Building building, Permit permit) {
        this.architect = architect;
        this.building = building;
        this.permit = permit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Architect getArchitect() {
        return architect;
    }

    public void setArchitect(Architect architect) {
        this.architect = architect;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Permit getPermit() {
        return permit;
    }

    public void setPermit(Permit permit) {
        this.permit = permit;
    }

    public void addWorker(Bricklayer bricklayer) {
        this.bricklayerCustomLinkedList.add(bricklayer);
    }

    public CustomLinkedList<Bricklayer> getWorkers() {
        return this.bricklayerCustomLinkedList;
    }

    public double bricklayersListCost() {
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
                total = total + X.data.TotalSalary();
                counter++;
            }
        }
        return total;
    }
}
