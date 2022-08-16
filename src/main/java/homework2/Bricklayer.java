package homework2;

public class Bricklayer extends Worker {

    private int salary;

    public Bricklayer(){
        this.salary = 1200;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

    @Override
    public double TotalSalary(){
        return this.salary;
    }

    @Override
    public String toString(){
        return "Bricklayer";
    }


}
