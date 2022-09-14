package jdbc;

import java.util.ArrayList;

public class Flight {

    private ArrayList<Passenger> passengers = new ArrayList<>();
    private int flight_id;
    private String flight_duration;
    private double price;
    private String departure_time;
    private String arrival_time;
    private Airport arrival_airport;
    private Airport departure_airport;
    private Pilot pilot;
    private Plane plane;
    private Airline airline;

    public Flight() {
    }

    public Flight(int flight_id, String flight_duration, double price, String departure_time, String arrival_time, Airport arrival_airport, Airport departure_airport, Pilot pilot, Plane plane, Airline airline, ArrayList<Passenger> passengers) {
        this.flight_id = flight_id;
        this.flight_duration = flight_duration;
        this.price = price;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.arrival_airport = arrival_airport;
        this.departure_airport = departure_airport;
        this.pilot = pilot;
        this.plane = plane;
        this.airline = airline;
        this.passengers = passengers;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_duration() {
        return flight_duration;
    }

    public void setFlight_duration(String flight_duration) {
        this.flight_duration = flight_duration;
    }

    @Override
    public String toString() {
        return "Flight{" + "passengers=" + passengers + ", flight_id=" + flight_id + ", flight_duration='" + flight_duration + '\'' + ", price=" + price + ", departure_time='" + departure_time + '\'' + ", arrival_time='" + arrival_time + '\'' + ", arrival_airport=" + arrival_airport + ", departure_airport=" + departure_airport + ", pilot=" + pilot + ", plane=" + plane + ", airline=" + airline + '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Airport getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(Airport arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    public Airport getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(Airport departure_airport) {
        this.departure_airport = departure_airport;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
}
