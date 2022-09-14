package jdbc.DAO.mysql;

import jdbc.Airport;
import jdbc.City;
import jdbc.DAO.IBaseDAO;

import java.sql.*;
import java.util.ArrayList;

public class AirportDAO implements IBaseDAO<Airport> {

    public final String INSERT_AIRPORT = "INSERT INTO airports(airport_name, IATA_code, cityId) " + "VALUES(?, ?, ?)";
    public final String GET_AIRPORT_BY_ID = "SELECT * FROM airports LEFT JOIN cities ON airports.cityId = cities.city_id WHERE airport_id = ? ORDER BY airport_id";
    public final String GET_ALL_AIRPORTS = "SELECT * FROM airports LEFT JOIN cities ON airports.cityId = cities.city_id ORDER BY airport_id";
    public final String DELETE_BY_ID = "DELETE FROM airports WHERE airport_id = ?";
    public final String UPDATE_AIRPORT = "UPDATE airports SET airport_name =  ?, IATA_code = ?, cityId = ? WHERE airport_id = ?";
    public final String DELETE_ALL = "DELETE FROM airports";
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_task", "root", "root");
    PreparedStatement preparedStatement;

    public AirportDAO() throws SQLException {
    }

    @Override
    public Airport getById(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(GET_AIRPORT_BY_ID);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();

        result.next();

        City city = new City(result.getInt("city_id"), result.getString("city_name"));
        Airport airport = new Airport(result.getInt("airport_id"), result.getString("airport_name"), result.getString("IATA_code"), city);

        return airport;
    }

    @Override
    public ArrayList<Airport> getAll() throws SQLException {
        preparedStatement = connection.prepareStatement(GET_ALL_AIRPORTS);

        ResultSet result = preparedStatement.executeQuery();

        ArrayList<Airport> airports = new ArrayList<>();

        while (result.next()) {
            City city = new City(result.getInt("city_id"), result.getString("city_name"));

            Airport airport = new Airport(result.getInt("airport_id"), result.getString("airport_name"), result.getString("IATA_code"), city);

            airports.add(airport);
        }
        return airports;
    }

    @Override
    public void insertRow(Airport object) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_AIRPORT);

        preparedStatement.setString(1, object.getAirport_name());
        preparedStatement.setString(2, object.getIATA_code());
        preparedStatement.setInt(3, object.getCity().getCity_id());

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {

        preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void updateRow(int id, Airport object) throws SQLException {

        preparedStatement = connection.prepareStatement(UPDATE_AIRPORT);
        preparedStatement.setString(1, object.getAirport_name());
        preparedStatement.setString(2, object.getIATA_code());
        preparedStatement.setInt(3, object.getCity().getCity_id());
        preparedStatement.setInt(4, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteAll() throws SQLException {

        preparedStatement = connection.prepareStatement(DELETE_ALL);

        preparedStatement.executeUpdate();
    }
}
