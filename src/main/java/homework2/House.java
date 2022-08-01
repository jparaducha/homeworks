/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

/**
 *
 * @author Paraducha Juan
 */
public class House extends Building implements homeOwner {

    static String className = "Housing";
    String address;

    @Override
    public String toString() {
        return className;
    }

    public House(String address) {
        this.address = address;
    }

    public House() {

    }

    @Override
    public int hashCode() {

        return super.hashCode() + 1;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final House other = (House) obj;
        return true;
    }

    @Override
    public void HOACharge(String className) {

        System.out.println("You have to pay " + homework2.homeOwner.BASIC_TAX * 2.5 + " to the Home Owner Association");

    }

}
