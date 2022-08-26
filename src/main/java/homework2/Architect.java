/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import homework2.interfaces.IData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Paraducha Juan
 */
public class Architect extends Worker implements IData {

    private final Logger LOGGER = LogManager.getLogger(Architect.class);
    private final List<String> degrees = new ArrayList<>();
    private String planType;

    public Architect() {
        super(2500);
        this.setExperience(1);
    }

    public Architect(int salary) {
        super(salary);
    }

    public Architect(int salary, String plan, int experience, String name) {
        super(salary);
        this.planType = plan;
        this.setExperience(experience);
        this.setName(name);
    }

    public List<String> getDegrees() {
        return degrees;
    }

    public void printDegreesFromCountry(String country) {
        List<String> postgrads = this.getDegrees().stream().filter((i) -> i.toLowerCase().contains(country.toLowerCase())).collect(Collectors.toList());

        postgrads.forEach((i) -> LOGGER.info(i));
    }

    public void printPostgradCountries() {
        List<String> postgradCountries = this.getDegrees().stream().map((i) -> i.split(", ")[i.split(", ").length - 1]).collect(Collectors.toList());

        postgradCountries.forEach(i -> LOGGER.info(i));
    }

    public void printAllDegrees() {
        LOGGER.info(this.getDegrees().stream().reduce("| ", (acc, curr) -> acc + curr + " | "));
    }

    public void appendDegrees(String degrees) {
        this.degrees.add(degrees);
    }

    @Override
    public double totalSalary() {
        double total = 0;
        if ("FullPlan".equals(planType)) {
            total = (int) (super.getExperience() * super.getSalary() * 1.7);
        }
        if ("BasicPlan".equals(planType) || "".equals(planType)) {
            total = (int) (super.getExperience() * super.getSalary() * 1.2);
        }

        if (total >= 20000) {
            System.out.println("????" + super.getSalary());
            super.setSalary(20000);
            total = 20000;
        }

        return total;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    @Override
    public String getData() {
        String data = "";
        if (this.getName() != null && this.getName().equals("")) {
            data = "Architect does not have a name";
        } else {
            data = this.getName();
        }
        if (this.getAge() == 0) {
            data += "\n Architect does not have a defined age";
        } else {
            data += " is " + this.getAge() + " years old";

            if (!this.planType.equals("")) {
                data += " and is working on a " + this.planType;
            }
        }

        return data;
    }

    @Override
    public String getNationalityAndName() {
        String data = "";
        if (!this.getName().equals("")) {
            data += this.getName();
        }
        if (this.getNationality() != null && !this.getNationality().equals("")) {
            data += " is " + this.getNationality();
        } else {
            if (data.equals("")) {
                data = "This architect does not have a nationality defined";
            } else {
                data += " has no nationality defined";
            }
        }

        return data;
    }
}
