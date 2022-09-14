/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import homework2.enums.LicenseType;
import homework2.enums.Material;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Paraducha Juan
 */
public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {

            Material wood = Material.WOOD;

            Building b = new Building(wood);

            Customer customer = new Customer(2700000, "Philip Pirrip");

            Permit permit = new Permit();

            Company company = new Company();

            b.setArea(200);
            b.setFloors(5);

            Plumber plumber = new Plumber(b);

            //LOGGER.info("Building cost:" + b.buildingCost());

            Architect arquitecto = new Architect(2100, "FullPlan", 3, "Le Corbusier");
            arquitecto.appendDegrees("Arquitectura, UBA, Argentina");
            arquitecto.appendDegrees("Sustentabilidad en Arquitectura y Urbanismo, UBA, Argentina");
            arquitecto.appendDegrees("Master of Design, University of Sidney, Australia");
            arquitecto.appendDegrees("Master of Heritage Conservation, University of Sidney, Australia");
            arquitecto.appendDegrees("Architectural History, Oxford University, United Kingdom");

            // Java streams;
            arquitecto.printDegreesFromCountry("argentina");
            arquitecto.printPostgradCountries();
            arquitecto.printAllDegrees();
            LOGGER.info("Architect " + arquitecto.getName() + " has a degree from an Australian entity: " + arquitecto.hasDegreeInCountry("Australia"));
            LOGGER.info("Architect " + arquitecto.getName() + " has a degree from an Georgian entity: " + arquitecto.hasDegreeInCountry("Georgia"));
            LOGGER.info("Architect " + arquitecto.getName() + " has " + arquitecto.numberOfDegrees() + " degrees.");

            Inspector inspector = new Inspector();
            Project proyecto = new Project(arquitecto, b, permit, inspector);

            //CREATES WORKERS AND ADDS THEM TO THE PROJECT;
            Bricklayer brick1 = new Bricklayer();
            Bricklayer brick2 = new Bricklayer(true);
            Bricklayer brick3 = new Bricklayer();
            Bricklayer brick4 = new Bricklayer();
            Bricklayer brick5 = new Bricklayer(1150, true);
            Bricklayer brick6 = new Bricklayer(1200, true);

            proyecto.addWorker(brick1);
            proyecto.addWorker(brick2);
            proyecto.addWorker(brick3);
            proyecto.addWorker(brick4);
            proyecto.addWorker(brick5);
            proyecto.addWorker(brick6);

            // GIVES A WORKER A LICENSE;
            LicenseType crane = LicenseType.CRANE;
            brick1.setLicense(crane);
            brick1.printLicenseTypes();

            LOGGER.info("workers' salaries raised: " + company.applyRaise(proyecto, (p) -> p.bricklayersListCost() + (p.getWorkers().length() * 450)));
            LOGGER.info("salary of worker1: " + brick1.totalSalary());

            LOGGER.info("salary of all workers: " + proyecto.bricklayersListCost());

            LOGGER.info("salary of the architect: " + arquitecto.totalSalary());

            LOGGER.info("This project will take approximately " + company.constructionTime(proyecto) + " weeks to be completed");

            LOGGER.info(arquitecto.getNationalityAndName());
            LOGGER.info(arquitecto.getData());

            LOGGER.info(company.totalCost(proyecto, customer));
        } catch (Exception e) {

            LOGGER.error(e);
        }
    }
}
