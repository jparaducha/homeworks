/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

/**
 *
 * @author Paraducha Juan
 */
public class Building extends Company {

    java.util.Scanner scan = new java.util.Scanner(System.in);

    public static int buildingCount;
    public int buildingId;
    public int yearlyTaxes;
    public String material;
    public int floors;
    public String name;
    public String type;
    public int areaInSqMts;

    static {
        buildingCount = 0;
    }

    public Building() {
        buildingCount++;

        this.buildingId = buildingCount;
    }

    public Building(String material) {
        buildingCount++;

        this.buildingId = buildingCount;
        this.material = material;
    }

    public Building(String material, int area, int floors) throws InvalidFloorsException, InvalidAreaException{
        if(floors< 0){
            throw new InvalidFloorsException("Floors cannot be negative");
        }
        if(floors==0){
            throw new InvalidFloorsException("Floors cannot be zero");
        }
        if(area< 0){
            throw new InvalidAreaException("Area cannot be negative");
        }
        if(area==0){
            throw new InvalidAreaException("Area cannot be zero");
        }
        buildingCount++;

        this.buildingId = buildingCount;
        this.material = material;
        this.areaInSqMts = area;
        this.floors = floors;
    }
    
    public void setFloors(int floors) throws InvalidFloorsException{
        if(floors< 0){
            throw new InvalidFloorsException("Floors cannot be negative");
        }
        if(floors==0){
            throw new InvalidFloorsException("Floors cannot be zero");
        }
        this.floors = floors;
    }
    
    public int getFloors(){
        return this.floors;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setArea(int area) throws InvalidAreaException {
        if(area< 0){
            throw new InvalidAreaException("Area cannot be negative");
        }
        if(area==0){
            throw new InvalidAreaException("Area cannot be zero");
        }
        this.areaInSqMts = area;
    }

    public int getArea() {
        return this.areaInSqMts;
    }

    public int getTaxes() {
        return yearlyTaxes;
    }

    /*
    protected void timeAndCost() {
        System.out.println("The " + this.toString() + " building made of " + this.material + " will cost: $" + Math.ceil(this.costOfBuilding) + " and will be finished in approximately " + this.weeksOfConstruction + " weeks.");
        System.out.println("This building will have a yearly tax of $" + this.yearlyTaxes);
        System.out.println("Select any key to continue...");
        scan.nextLine();
    }

    protected void costWithArea() {
        System.out.println("Enter the area to be built on in square meters: ");
        int area = scan.nextInt();

        if (area > 100) {
            this.costOfBuilding *= 1.2;
        }
        if (area > 250) {
            this.costOfBuilding *= 1.8;
        }
        if (area > 400) {
            this.costOfBuilding *= 2.6;
        }
        
        timeAndCost();
    }*/
}
