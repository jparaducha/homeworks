package jdbc;

import java.util.List;

public class Plane {

    private int year;
    private String model;
    private Plane_Manufacturer manufacturer;
    private int planeId;
    private List<String> flights;

    public Plane() {

    }

    public Plane(int id, int year, String model, Plane_Manufacturer manufacturer/*,List<String> flights*/) {
        this.planeId = id;
        this.year = year;
        this.model = model;
        this.manufacturer = manufacturer;
        //this.flights = flights;
    }

    @Override
    public String toString() {
        return "Plane{" + "year=" + year + ", model='" + model + '\'' + ", manufacturer='" + manufacturer + '\'' + ", planeId=" + planeId + ", flights=" + flights + '}';
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public int getModelId() {
        return Integer.parseInt(this.model);
    }

    public Plane_Manufacturer getManufacturer() {
        return manufacturer;
    }

    public List<String> getFlights() {
        return flights;
    }

    public void setFlights(List<String> flights) {
        this.flights = flights;
    }
}
