package homework2;

public class Plumber extends Worker {

    Building b;

    public Plumber(Building b) {
        this.b = b;
    }

    public Plumber() {
    }

    public Building getBuilding() {
        return b;
    }

    public void setBuilding(Building b) {
        this.b = b;
    }

    @Override
    public double TotalSalary() {

        return 4.5 * b.getTotalArea();
    }
}
