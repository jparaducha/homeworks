/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import homework2.Exceptions.InvalidAreaException;
import homework2.Exceptions.InvalidFloorsException;

/**
 * @author Paraducha Juan
 */
public class Building extends Company {

    private static int buildingCount;

    static {
        buildingCount = 0;
    }

    private final int buildingId;
    java.util.Scanner scan = new java.util.Scanner(System.in);
    private int yearlyTaxes;
    private Material material;
    private int floors;
    private int areaInSqMts;
    private int costOfBuilding;

    public Building() {
        buildingCount++;

        this.buildingId = buildingCount;
    }

    public Building(Material material) {
        buildingCount++;

        this.buildingId = buildingCount;
        this.material = material;
    }

    public Building(Material material, int area, int floors) throws InvalidFloorsException, InvalidAreaException {
        if (floors < 0) {
            throw new InvalidFloorsException("Floors cannot be negative");
        }
        if (floors == 0) {
            throw new InvalidFloorsException("Floors cannot be zero");
        }
        if (area < 0) {
            throw new InvalidAreaException("Area cannot be negative");
        }
        if (area == 0) {
            throw new InvalidAreaException("Area cannot be zero");
        }
        buildingCount++;

        this.buildingId = buildingCount;
        this.material = material;
        this.areaInSqMts = area;
        this.floors = floors;
    }

    public int getFloors() {
        return this.floors;
    }

    public void setFloors(int floors) throws InvalidFloorsException {
        if (floors < 0) {
            throw new InvalidFloorsException("Floors cannot be negative");
        }
        if (floors == 0) {
            throw new InvalidFloorsException("Floors cannot be zero");
        }
        this.floors = floors;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getArea() {
        return this.areaInSqMts;
    }

    public void setArea(int area) throws InvalidAreaException {
        if (area < 0) {
            throw new InvalidAreaException("Area cannot be negative");
        }
        if (area == 0) {
            throw new InvalidAreaException("Area cannot be zero");
        }
        this.areaInSqMts = area;
    }

    public int getTotalArea() {
        return this.areaInSqMts * this.floors;
    }

    public int getTaxes() {
        return yearlyTaxes;
    }

    public double buildingCost() {

        switch (this.material) {
            case CONCRETE:
                this.costOfBuilding = this.areaInSqMts * this.floors * 2700;
                break;
            case STEEL:
                this.costOfBuilding = this.areaInSqMts * this.floors * 3900;
                break;
            case BRICKS:
                this.costOfBuilding = this.areaInSqMts * this.floors * 3000;
                break;
            case STONE:
                this.costOfBuilding = this.areaInSqMts * this.floors * 4500;
                break;
            case WOOD:
            case ORGANIC:
                this.costOfBuilding = this.areaInSqMts * this.floors * 2450;
                break;
            default:
                this.costOfBuilding = this.areaInSqMts * this.floors * 2200;
        }

        return this.costOfBuilding;
    }
}
