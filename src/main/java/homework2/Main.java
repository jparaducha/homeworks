/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Paraducha Juan
 */
public class Main {

private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        
        try{
        
        Building b = new Building("Wood");
        Company c = new Company();
        
        b.setArea(200);
        b.setFloors(5);

        logger.info("Building cost:"  + c.buildingCost(b));

        }catch(Exception e){
            logger.error(e);
        }
        
    }
}
