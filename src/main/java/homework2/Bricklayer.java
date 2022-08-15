package homework2;

public class Bricklayer extends Worker {

    private int salary;

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

    @Override
    public int TotalSalary(){
        return 10;
    }


}
