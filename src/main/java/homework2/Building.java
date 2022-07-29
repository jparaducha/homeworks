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
public abstract class Building {

    java.util.Scanner scan = new java.util.Scanner(System.in);

    static int buildingCount = 0;
    int buildingId;
    int yearlyTaxes;
    double costOfBuilding;
    short weeksOfConstruction;
    String material;
    final String constructionCompany = "LeVille Works";

    public Building() {
        buildingCount++;

        this.buildingId = buildingCount;
    }

    protected void costCalculation(int price) {

        System.out.println("Select material of construction:"
                + "\n1.Wood"
                + "\n2.Concrete"
                + "\n3.Steel"
                + "\n4.Bricks (default)"
                + "\nAny key: Select default\n");

        String selection = scan.nextLine();

        switch (selection) {
            case "1":
                this.costOfBuilding = price * 1;
                this.material = "Wood";
                break;
            case "2":
                this.costOfBuilding = price * 2.3;
                this.material = "Concrete";
                break;
            case "3":
                this.costOfBuilding = price * 3.5;
                this.material = "Steel";
                break;
            default:
                this.costOfBuilding = price * 1.8;
                this.material = "Bricks";
        }

    }

    public int getTaxes() {
        return yearlyTaxes;
    }

    @Override
    public abstract String toString();

    protected void timeAndCost() {
        System.out.println("The " + this.toString() + " building made of " + this.material + " will cost: $" + Math.ceil(this.costOfBuilding) + " and will be finished in approximately " + this.weeksOfConstruction + " weeks.");
        System.out.println("This building will have a yearly tax of $" + this.yearlyTaxes);
        System.out.println("Select any key to continue...");
        scan.nextLine();
    }

}
