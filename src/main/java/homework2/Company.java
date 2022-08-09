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
public class Company {

    public String name;
    public double costOfBuilding;
    public short weeksOfConstruction;
    public int workersSalary;
    public final String companyName = "ConstructionWorks";
    
    
    public void setWorkersSalary(Worker w){
        workersSalary = w.TotalSalary();
    }
    
    
        public double buildingCost(Building b){
        
        switch(b.material){
            case "Concrete":
                this.costOfBuilding = b.areaInSqMts * b.floors * 3000;
                break;
            case "Steel":
                this.costOfBuilding = b.areaInSqMts * b.floors * 4200;
                break;
            case "Bricks":
                this.costOfBuilding = b.areaInSqMts * b.floors * 3300;
                break;
            case "Stone":
                this.costOfBuilding = b.areaInSqMts * b.floors * 4800;
                break;
            case "Wood":
            case "Organic":
                this.costOfBuilding = b.areaInSqMts * b.floors * 2500;
                break;
            default :
                this.costOfBuilding = b.areaInSqMts * b.floors * 2500;
        }
        
        return this.costOfBuilding;
    }

}
