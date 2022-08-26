/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

            Company company = new Company(customer);

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

            List<String> internationalPostgrad = arquitecto.getDegrees().stream().filter((i) -> !i.contains("Argentina")).collect(Collectors.toList());
            List<String> postgradCountries = arquitecto.getDegrees().stream().map((i) -> i.split(", ")[i.split(", ").length - 1]).collect(Collectors.toList());
/*
            LOGGER.info("International degrees:");
            internationalPostgrad.forEach((i) -> LOGGER.info(i));
            LOGGER.info(postgradCountries);
            LOGGER.info(arquitecto.getDegrees().stream().reduce("| ", (acc, curr) -> acc + curr + " | "));
            */

            Inspector inspector = new Inspector();
            Project proyecto = new Project(arquitecto, b, permit, inspector);
            //company.applyRaise(proyecto, (p) -> p.bricklayersListCost() + (p.getWorkers().length() * 100));

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

            LicenseType crane = LicenseType.CRANE;
            brick1.setLicense(crane);
            brick1.printLicenseTypes();
/*
            LOGGER.info("workers' salaries raised: " + company.applyRaise(proyecto, (p) -> p.bricklayersListCost() + (p.getWorkers().length() * 100)));
            LOGGER.info("salary of worker1: " + brick1.totalSalary());

            LOGGER.info("salary of all workers: " + proyecto.bricklayersListCost());

            LOGGER.info("salary of the architect: " + arquitecto.totalSalary());

            LOGGER.info("This project will take approximately " + company.constructionTime(proyecto) + " weeks to be completed");

            LOGGER.info(arquitecto.getNationalityAndName());
            LOGGER.info(arquitecto.getData());

            LOGGER.info(company.totalCost(proyecto));
*/
            Class reflectionClass = Building.class;

            Field[] fields = reflectionClass.getDeclaredFields();

            LOGGER.info("\nFields inside building class:\n");
            for (Field field : fields) {
                LOGGER.info((field.getModifiers() == 0 ? "default " : field.getModifiers() == 1 ? "public " : "private ") + field.getType() + " " + field.getName());
            }

            Method[] methods = reflectionClass.getDeclaredMethods();

            LOGGER.info("\nmethods inside building class:\n");
            for (Method method : methods) {
                LOGGER.info((method.getModifiers() == 0 ? "default " : method.getModifiers() == 1 ? "public " : "private ") + method.getReturnType() + " " + method.getName() + (method.getParameterTypes().length == 0 ? "()" : "( " + Arrays.toString(method.getParameterTypes()) + " )"));

                // NOT NEEDED ↓↓↓
                //
                /*if (method.getParameterTypes().length == 0) {
                    //LOGGER.info("Takes no parameters");
                    LOGGER.info("()");
                } else {
                    Class[] parameterTypes = method.getParameterTypes();
                    LOGGER.info("Takes parameters of type: ");
                    for (Class parameterType : parameterTypes) {
                        LOGGER.info(parameterType.getName());
                    }
                }*/
            }

            Method something = reflectionClass.getDeclaredMethod("includesPlumbing");
            LOGGER.info("Calling method using reflection: " + something.invoke(b));
            Constructor[] constructors = reflectionClass.getConstructors();

            LOGGER.info("\nConstructors in Building class:\n");
            for (Constructor constructor : constructors) {
                LOGGER.info(constructor);
            }
        } catch (Exception e) {

            LOGGER.error(e);
        }
    }
}
