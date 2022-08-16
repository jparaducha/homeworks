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

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {


        try {

            Material wood = Material.WOOD;

            Building b = new Building(wood);
            Customer customer = new Customer();
            Permit permit = new Permit();

            b.setArea(200);
            b.setFloors(5);

            logger.info("Building cost:" + b.buildingCost());

            Architect arquitecto = new Architect(2100,"FullPlan",3);
            Project proyecto = new Project(arquitecto, customer, b, permit);

            Bricklayer brick1 = new Bricklayer();
            Bricklayer brick2 = new Bricklayer();
            Bricklayer brick3 = new Bricklayer();

            proyecto.addWorker(brick1);
            proyecto.addWorker(brick2);
            proyecto.addWorker(brick3);

            logger.info("salary of a worker: " + brick1.TotalSalary());
            logger.info("salary of the architect: " + arquitecto.TotalSalary());

            logger.info("Total cost of the project: " + proyecto.TotalCost());


        } catch (Exception e) {
            logger.error(e);
        }

    }
}
