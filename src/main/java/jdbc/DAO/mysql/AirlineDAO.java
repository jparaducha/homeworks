package jdbc.DAO.mysql;

import jdbc.Airline;
import jdbc.Country;
import jdbc.DAO.IBaseDAO;

import java.sql.*;
import java.util.ArrayList;

public class AirlineDAO implements IBaseDAO<Airline> {

    public final String INSERT_AIRLINE = "INSERT INTO airlines(airline_name, countryId) " + "VALUES(?,?)";
    public final String GET_AIRLINE_BY_ID = "SELECT * FROM airlines LEFT JOIN countries ON airlines.countryId = countries.country_id WHERE airline_id = ?";
    public final String GET_ALL_AIRLINES = "SELECT * FROM airlines LEFT JOIN countries ON countries.country_id = cities.countryId ORDER BY airline_id"; // LEFT JOIN airlines ON countries.country_id = airlines.countryId
    public final String DELETE_BY_ID = "DELETE FROM airlines WHERE airline_id = ?";
    public final String UPDATE_AIRLINE = "UPDATE airlines SET airline_name =  ?, countryId = ? WHERE airline_id = ?";
    public final String DELETE_ALL = "DELETE FROM airlines";
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_task", "root", "root");
    PreparedStatement preparedStatement;

    public AirlineDAO() throws SQLException {
    }

    @Override
    public Airline getById(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(GET_AIRLINE_BY_ID);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();

        result.next();

        Country country = new Country();
        country.setCountry_name(result.getString("country_name"));
        Airline airline = new Airline(result.getInt("airline_id"), result.getString("airline_name"), country);

        return airline;
    }

    @Override
    public ArrayList<Airline> getAll() throws SQLException {
        preparedStatement = connection.prepareStatement(GET_ALL_AIRLINES);
        ResultSet result = preparedStatement.executeQuery();

        ArrayList<Airline> airlines = new ArrayList<>();

        while (result.next()) {

            Country country = new Country();
            country.setCountry_name(result.getString("country_name"));
            Airline airline = new Airline(result.getInt("airline_id"), result.getString("airline_name"), country);

            airlines.add(airline);
        }

        return airlines;
    }

    @Override
    public void insertRow(Airline object) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_AIRLINE);
        preparedStatement.setString(1, object.getAirline_name());
        preparedStatement.setInt(2, object.getCountry().getCountryId());

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void updateRow(int id, Airline object) throws SQLException {
        preparedStatement = connection.prepareStatement(UPDATE_AIRLINE);
        preparedStatement.setString(1, object.getAirline_name());
        preparedStatement.setInt(2, object.getCountry().getCountryId());
        preparedStatement.setInt(3, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteAll() throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE_ALL);

        preparedStatement.executeUpdate();
    }
}