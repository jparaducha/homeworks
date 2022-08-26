package homework2;

import homework2.customLinkedList.CustomLinkedList;
import homework2.customLinkedList.Node;
import homework2.exceptions.InvalidSalaryException;
import homework2.interfaces.IManageable;

public class Project implements IManageable {

    private final CustomLinkedList<Bricklayer> bricklayerCustomLinkedList = new CustomLinkedList<>();
    private final CustomLinkedList<Architect> architectList = new CustomLinkedList<>();
    private String city;
    private Building building;
    private Permit permit;
    private Plumber plumber;
    private Inspector inspector;

    public Project() {
    }

    public Project(Architect architect, Building building, Permit permit, Inspector inspector) {
        this.architectList.add(architect);
        this.building = building;
        this.permit = permit;
        this.inspector = inspector;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public Plumber getPlumber() {
        return plumber;
    }

    public void setPlumber(Plumber plumber) {
        this.plumber = plumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CustomLinkedList<Architect> getArchitectList() {
        return architectList;
    }

    public void setArchitectList(Architect architectList) {
        this.architectList.add(architectList);
    }

    public double getArchitectSalary() throws InvalidSalaryException {
        double total;
        total = 0;
        int counter;
        counter = 2;
        Node<Architect> temp = new Node<>(null);

        if (this.architectList.head == null) {
            return 0;
        } else {

            Node<Architect> X = this.architectList.head;

            total = total + X.data.totalSalary();
            if (X.data.totalSalary() <= 0) {
                throw new InvalidSalaryException("Architect salary must be a positive number");
            }
            while (X.next != null) {
                X = X.next;
                if (X.data.totalSalary() <= 0) {
                    throw new InvalidSalaryException("Architect salary must be a positive number");
                }
                total = total + X.data.totalSalary();
                counter++;
            }
        }
        return total;
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

    public CustomLinkedList<Bricklayer> getAvailableWorkers() {
        CustomLinkedList<Bricklayer> list = new CustomLinkedList<>();
        Node node = this.bricklayerCustomLinkedList.head;

        while (node.next != null) {
            Bricklayer bricks = (Bricklayer) node.data;
            if (bricks.isAvailable()) {
                list.add(bricks);
            }
        }

        return list;
    }

    public CustomLinkedList<Bricklayer> getExtraHoursWorkers() {
        CustomLinkedList<Bricklayer> list = new CustomLinkedList<>();
        Node node = this.bricklayerCustomLinkedList.head;

        do {
            Bricklayer bricks = (Bricklayer) node.data;
            if (bricks.getExtraHours() && bricks.isAvailable()) {
                list.add(bricks);
            }

            node = node.next;
        } while (node != null);

        return list;
    }

    public double bricklayersListCost() throws InvalidSalaryException {
        double total;
        total = 0;
        int counter;
        counter = 2;
        Node<Bricklayer> temp = new Node<>(null);

        if (this.bricklayerCustomLinkedList.head == null) {
            return 0;
        } else {

            Node<Bricklayer> X = this.bricklayerCustomLinkedList.head;

            total = total + X.data.totalSalary();
            if (X.data.getSalary() <= 0) {
                throw new InvalidSalaryException("Worker salary must be a positive number");
            }
            while (X.next != null) {
                X = X.next;
                if (X.data.getSalary() <= 0) {
                    throw new InvalidSalaryException("Worker salary must be a positive number");
                }
                total = total + X.data.totalSalary();
                counter++;
            }
        }
        return total;
    }

    public String getWorkersCount() {
        String text = "";
        if (building.getTotalArea() > 2000) {
            text += "This building should have 2 architects or project managers and 3 plumbers";
        } else {
            text += "This building will be fine with 1 architect";
        }

        return text;
    }
}
