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

            Customer customer = new Customer();

            Permit permit = new Permit();

            Company company = new Company();

            b.setArea(200);
            b.setFloors(5);

            LOGGER.info("Building cost:" + b.buildingCost());

            Architect arquitecto = new Architect(2100, "FullPlan", 3);

            Project proyecto = new Project(arquitecto, b, permit);

            Bricklayer brick1 = new Bricklayer();
            Bricklayer brick2 = new Bricklayer();

            Bricklayer brick3 = new Bricklayer();

            proyecto.addWorker(brick1);

            proyecto.addWorker(brick2);

            proyecto.addWorker(brick3);

            LOGGER.info("salary of worker1: " + brick1.TotalSalary());

            LOGGER.info("salary of all workers: " + proyecto.bricklayersListCost());

            LOGGER.info("salary of the architect: " + arquitecto.TotalSalary());

            LOGGER.info("Total cost of the project: " + company.TotalCost(proyecto));
        } catch (Exception e) {

            LOGGER.error(e);
        }
    }
}
