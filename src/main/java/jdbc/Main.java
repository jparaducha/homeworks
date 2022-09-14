package jdbc;

import jdbc.DAO.mysql.CountryDAO;
import jdbc.DAO.mysql.FlightDAO;
import jdbc.DAO.mysql.PlaneDAO;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        PlaneDAO pld = new PlaneDAO();
        CountryDAO countryDAO = new CountryDAO();
/*
        Plane plane2 = pld.getPlaneById(2);

        System.out.println(plane2);

        System.out.println("--------------------------------");
        ArrayList<Plane> planes = pld.getAllPlanes();

        for (int i = 0; i < planes.size(); i++) {
            System.out.println(planes.get(i));
        }

        pld.insertPlane(3333, 2);

        ArrayList<Plane> planeInserted = pld.getAllPlanes();

        long idToDelete = 0;
        System.out.println("--------------------------------");
        for (int i = 0; i < planeInserted.size(); i++) {
            System.out.println(planeInserted.get(i));

            if (planeInserted.get(i).getYear() == 3333) {
                idToDelete = planeInserted.get(i).getPlaneId();
            }
        }

        pld.deletePlane(idToDelete);

        Country Argentina = countryDAO.getById(1);

        System.out.println(Argentina);

        ArrayList<Country> countries;

        countries = countryDAO.getAll();

        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }

        */

        FlightDAO fDAO = new FlightDAO();

        Flight flight4 = fDAO.getById(4);

        System.out.println(flight4);
    }
}