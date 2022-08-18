package homework2;

public class Bricklayer extends Worker {

    private boolean extraHours;
    private boolean isAvailable;

    public Bricklayer() {
        super(1100);
    }

    public Bricklayer(int salary, boolean extra) {
        super(salary);
        this.extraHours = extra;
    }

    public boolean getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(boolean extra) {
        this.extraHours = extra;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public double TotalSalary() {
        if (extraHours) {
            return super.getSalary() * 1.5;
        }
        return super.getSalary();
    }

    @Override
    public String toString() {
        return "Bricklayer";
    }
}
