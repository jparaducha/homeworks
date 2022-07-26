/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import java.util.Scanner;

/**
 *
 * @author Paraducha Juan
 */
public class Main {

    static String flag = "s";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        
        do {
            System.out.println("Select new building to build"
                    + "\n1.Apartment"
                    + "\n2.House"
                    + "\n3.Public"
                    + "\n4.Industrial"
                    + "\nAny key. Exit\n");

            String selection = scan.nextLine();
            String selection2;
            
            switch (selection) {
                case "1":
                    System.out.println("Select new building to build"
                            + "\n1.Low Rise"
                            + "\n2.High Rise"
                            + "\nAny key. Select other type of building\n");
                    
                    selection2 = scan.nextLine();
                    if ("1".equals(selection2)) {
                        LowRise build = new LowRise();
                        build.timeAndCost();
                    }
                    if ("2".equals(selection2)) {
                        Building build = new HighRise();
                        build.timeAndCost();
                    }
                    break;
                case "2":
                    System.out.println("Select new building to build"
                            + "\n1.Cottage"
                            + "\n2.Suburban"
                            + "\nAny key. Select other type of building\n");
                    selection2 = scan.nextLine();
                    if ("1".equals(selection2)) {
                        Building build = new Cottage();
                        build.timeAndCost();
                    }
                    if ("2".equals(selection2)) {
                        Building build = new Suburban();
                        build.timeAndCost();
                    }
                    break;
                case "3":
                    System.out.println("Select new building to build"
                            + "\n1.Health"
                            + "\n2.Education"
                            + "\nAny key. Select other type of building\n");
                    selection2 = scan.nextLine();
                    
                    if ("1".equals(selection2)) {
                        Building build = new Health();
                        build.timeAndCost();
                    }
                    if ("2".equals(selection2)) {
                        Building build = new Education();
                        build.timeAndCost();
                    }
                    break;
                case "4":
                    System.out.println("Select new building to build"
                            + "\n1.Manufacturing"
                            + "\n2.Distribution"
                            + "\nAny key. Select other type of building\n");
                    selection2 = scan.nextLine();
                    if ("1".equals(selection2)) {
                        Building build = new Manufacturing();
                        build.timeAndCost();
                    }
                    if ("2".equals(selection2)) {
                        Building build = new Distribution();
                        build.timeAndCost();
                    }
                    break;
                default:
                    flag = "n";
            }
            
            

        } while (!flag.equals("n"));

    }
}
