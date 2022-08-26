package homework2;

import homework2.interfaces.IData;

public class Bricklayer extends Worker implements IData {

    private boolean extraHours;
    private boolean isAvailable;

    public Bricklayer() {
        super(1100);
    }

    public Bricklayer(int salary, boolean extra) {
        super(salary);
        this.extraHours = extra;
    }

    public Bricklayer(boolean extra) {
        super(1100);
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
    public double totalSalary() {
        if (extraHours) {
            return super.getSalary() * 1.5;
        }
        return super.getSalary();
    }

    @Override
    public String toString() {
        return "Bricklayer";
    }

    @Override
    public String getData() {
        String data = "";
        if (this.getName().equals("")) {
            data = "Bricklayer does not have a name";
        } else {
            data = this.getName();
        }

        if (this.getAge() == 0) {
            data += "\n Architect does not have a defined age";
        } else {
            data += " is " + this.getAge() + " years old";

            if (this.isAvailable()) {
                data += " and is available";
            } else {
                data += " and is not available";
            }
        }

        return data;
    }

    @Override
    public String getNationalityAndName() {
        String data = "Bricklayer ";
        if (!this.getName().equals("")) {
            data += this.getName();
        }
        if (this.getNationality() != null && !this.getNationality().equals("")) {
            data += " is " + this.getNationality();
        } else {
            if (data.equals("")) {
                data = " does not have a nationality defined";
            } else {
                data += " has no nationality defined";
            }
        }

        return data;
    }
}
