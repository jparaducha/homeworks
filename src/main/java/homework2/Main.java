/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

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

            Customer customer = new Customer(2500000, "Philip Pirrip");

            Permit permit = new Permit();

            Company company = new Company(customer);

            b.setArea(200);
            b.setFloors(5);

            LOGGER.info("Building cost:" + b.buildingCost());

            Architect arquitecto = new Architect(2100, "FullPlan", 3, "Le Corbusier");

            Project proyecto = new Project(arquitecto, b, permit);

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

            LOGGER.info("salary of worker1: " + brick1.TotalSalary());

            LOGGER.info("salary of all workers: " + proyecto.bricklayersListCost());

            LOGGER.info("salary of the architect: " + arquitecto.TotalSalary());

            LOGGER.info(company.ConstructionTime(proyecto));

            LOGGER.info(arquitecto.getNationalityAndName());
            LOGGER.info(arquitecto.getData());

            LOGGER.info(company.TotalCost(proyecto));
        } catch (Exception e) {

            LOGGER.error(e);
        }
    }
}
