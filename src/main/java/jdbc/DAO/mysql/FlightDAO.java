package jdbc.DAO.mysql;

import jdbc.*;
import jdbc.DAO.IBaseDAO;

import java.sql.*;
import java.util.ArrayList;

public class FlightDAO implements IBaseDAO<Flight> {

    public final String INSERT_FLIGHT = "INSERT INTO flights(airlineId,pilotId,planeId,price, departure_time, arrival_time, flight_duration) " + "VALUES(?,?,?,?,?,?,?)";
    public final String GET_FLIGHT_BY_ID = "SELECT *, a2.airport_name AS a2_name, a1.airport_name AS a1_name, a1.airport_id AS a1Id, a2.airport_id AS a2Id, a1.IATA_code AS a1IATA, a2.IATA_code AS a2IATA, c1.city_name AS city1, c2.city_name AS city2, con1.country_name AS con1, con2.country_name AS con2, con1.country_id AS con1id, con2.country_id AS con2id, con3.country_name AS con3, con3.country_id AS con3id, c1.city_id AS city1id, c2.city_id AS city2id FROM flights JOIN airlines ON airlines.airline_id = flights.airlineId JOIN countries con3 ON airlines.countryId = con3.country_id  JOIN planes ON planes.plane_id = flights.planeId JOIN plane_models ON planes.modelId = plane_models.model_id JOIN plane_manufacturers ON plane_models.manufacturer = plane_manufacturers.manufacturer_id JOIN pilots ON pilots.id_pilot = flights.pilotId JOIN pilot_licenses ON pilots.id_pilot = pilot_licenses.pilotId LEFT JOIN airport_flights af1 ON flights.flight_id = af1.flightId LEFT JOIN airports a1 ON af1.departure_airportId = a1.airport_id LEFT JOIN airport_flights af2 ON flights.flight_id = af2.flightId LEFT JOIN airports a2 ON af2.arrival_airportId = a2.airport_id INNER JOIN cities c1 ON c1.city_id = a1.cityId INNER JOIN cities c2 ON c2.city_id = a2.cityId INNER JOIN countries con1 ON con1.country_id = c1.countryId INNER JOIN countries con2 ON con2.country_id = c2.countryId JOIN tickets ON flights.flight_id = tickets.flightId JOIN passengers ON passengers.passenger_id = tickets.passengerId WHERE flight_id = ?";
    public final String GET_ALL_FLIGHTS = "SELECT *, a2.airport_name AS a2_name, a1.airport_name AS a1_name, a1.airport_id AS a1Id, a2.airport_id AS a2Id, a1.IATA_code AS a1IATA, a2.IATA_code AS a2IATA, c1.city_name AS city1, c2.city_name AS city2, con1.country_name AS con1, con2.country_name AS con2, con1.country_id AS con1id, con2.country_id AS con2id, con3.country_name AS con3, con3.country_id AS con3id, c1.city_id AS city1id, c2.city_id AS city2id FROM flights JOIN airlines ON airlines.airline_id = flights.airlineId JOIN countries con3 ON airlines.countryId = con3.country_id JOIN planes ON planes.plane_id = flights.planeId JOIN plane_models ON planes.modelId = plane_models.model_id JOIN plane_manufacturers ON plane_models.manufacturer = plane_manufacturers.manufacturer_id JOIN pilots ON pilots.id_pilot = flights.pilotId JOIN pilot_licenses ON pilots.id_pilot = pilot_licenses.pilotId LEFT JOIN airport_flights af1 ON flights.flight_id = af1.flightId LEFT JOIN airports a1 ON af1.departure_airportId = a1.airport_id LEFT JOIN airport_flights af2 ON flights.flight_id = af2.flightId LEFT JOIN airports a2 ON af2.arrival_airportId = a2.airport_id INNER JOIN cities c1 ON c1.city_id = a1.cityId INNER JOIN cities c2 ON c2.city_id = a2.cityId INNER JOIN countries con1 ON con1.country_id = c1.countryId INNER JOIN countries con2 ON con2.country_id = c2.countryId JOIN tickets ON flights.flight_id = tickets.flightId JOIN passengers ON passengers.passenger_id = tickets.passengerId ORDER BY flight_id";
    public final String DELETE_BY_ID = "DELETE FROM flights WHERE flight_id = ?";
    public final String UPDATE_FLIGHT = "UPDATE flights SET passenger_name =  ? WHERE flight_id = ?";
    public final String DELETE_ALL = "DELETE FROM flights";
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_task", "root", "root");
    PreparedStatement preparedStatement;

    public FlightDAO() throws SQLException {
    }

    @Override
    public Flight getById(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(GET_FLIGHT_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();

        ArrayList<Passenger> passengers = new ArrayList<>();

        result.next();

        Pilot_License license = new Pilot_License(result.getInt("license_id"), result.getString("issued_on"), result.getString("expires"), result.getInt("pilotId"));
        Pilot pilot = new Pilot(result.getInt("id_pilot"), result.getString("pilot_name"), result.getInt("pilot_age"), license);

        Plane_Manufacturer manufacturer = new Plane_Manufacturer(result.getInt("manufacturer_id"), result.getString("manufacturer_name"));
        Plane plane = new Plane(result.getInt("plane_id"), result.getInt("year"), result.getString(result.findColumn("model_name")), manufacturer);

        Country country1 = new Country(result.getString("con1"), result.getInt("con1id"));
        City city1 = new City(result.getInt("city1id"), result.getString("city1"), country1);
        Airport departure_airport = new Airport(result.getInt("a1id"), result.getString("a1_name"), result.getString("a1IATA"), city1);

        Country country2 = new Country(result.getString("con2"), result.getInt("con2id"));
        City city2 = new City(result.getInt("city2id"), result.getString("city2"), country2);
        Airport arrival_airport = new Airport(result.getInt("a2id"), result.getString("a2_name"), result.getString("a2IATA"), city2);

        Country country3 = new Country(result.getString("con3"), result.getInt("con3id"));
        Airline airline = new Airline(result.getInt("airline_id"), result.getString("airline_name"), country3);

        passengers.add(new Passenger(result.getInt("passenger_id"), result.getString("passenger_name")));

        while (result.next()) {
            passengers.add(new Passenger(result.getInt("passenger_id"), result.getString("passenger_name")));
        }

        result.previous();
        Flight flight = new Flight(result.getInt("flight_id"), result.getString("flight_duration"), result.getDouble("price"), result.getString("departure_time"), result.getString("arrival_time"), arrival_airport, departure_airport, pilot, plane, airline, passengers);

        return flight;
    }

    @Override
    public ArrayList<Flight> getAll() throws SQLException {
        return null;
    }

    @Override
    public void insertRow(Flight object) throws SQLException {

    }

    @Override
    public void deleteById(int id) throws SQLException {

        preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void updateRow(int id, Flight object) throws SQLException {

    }

    @Override
    public void deleteAll() throws SQLException {

        preparedStatement = connection.prepareStatement(DELETE_ALL);

        preparedStatement.executeUpdate();
    }
}