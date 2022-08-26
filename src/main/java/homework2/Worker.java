/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import homework2.Interfaces.IDrivable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * @author Paraducha Juan
 */
public abstract class Worker extends Human implements IDrivable {

    private final Logger LOGGER = LogManager.getLogger(Worker.class);
    private final ArrayList<LicenseType> license = new ArrayList<>();
    public int shiftHours;
    private int yearsOfExperience;
    private int salary;
    private boolean isDriver;

    public Worker(int salary) {
        this.salary = salary;
    }

    public Worker() {
    }

    public boolean isDriver() {
        return isDriver;
    }

    public void setDriver(boolean driver) {
        isDriver = driver;
    }

    public ArrayList<LicenseType> getLicense() {
        return license;
    }

    public void setLicense(LicenseType license) {
        this.license.add(license);
    }

    public void printLicenseTypes() {

        for (int i = 0; i < license.size(); i++) {
            LOGGER.info("This worker has a license for driving a " + license.get(i).getVehicle());
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getShift() {
        return shiftHours;
    }

    public void setShift(int shift) {
        this.shiftHours = shift;
    }

    public int getExperience() {
        return yearsOfExperience;
    }

    public void setExperience(int years) {
        this.yearsOfExperience = years;
    }

    public abstract double totalSalary();
}
