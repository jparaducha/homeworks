package homework2;

public class Project extends Company {

    private String city;
    private Customer customer;
    private Architect architect;
    private Building building;
    private Permit permit;

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

}
