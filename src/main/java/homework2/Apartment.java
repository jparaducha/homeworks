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
public  class Apartment extends Building {

    String address;
    int tenantsQuantity = 0;
        
    public Apartment() {
        this.address = "221B Baker Street";
    }
    
    
    public Apartment(String name){
        this.address = name;
    }
    

    static String name = "Departamento";

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        
        return super.equals(obj);
    }
    
    public void setTenants(int tenants){
        tenantsQuantity = tenants;
    }
    
    public int getTenants(){
        return tenantsQuantity;
    }
}
