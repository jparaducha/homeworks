package jdbc.DAO.mysql;

import jdbc.City;
import jdbc.Country;
import jdbc.DAO.IBaseDAO;

import java.sql.*;
import java.util.ArrayList;

public class CityDAO implements IBaseDAO<City> {

    public final String INSERT_CITY = "INSERT INTO cities(city_name, countryId) " + "VALUES(?,?)";
    public final String GET_CITY_BY_ID = "SELECT * FROM cities LEFT JOIN countries ON countries.country_id = cities.countryId WHERE city_id = ?";
    public final String GET_ALL_CITIES = "SELECT * FROM cities LEFT JOIN countries ON countries.country_id = cities.countryId ORDER BY city_id"; // LEFT JOIN airlines ON countries.country_id = airlines.countryId
    public final String DELETE_BY_ID = "DELETE FROM cities WHERE city_id = ?";
    public final String UPDATE_CITY = "UPDATE cities SET city_name =  ?, countryId = ? WHERE city_id = ?";
    public final String DELETE_ALL = "DELETE FROM cities";
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_task", "root", "root");
    PreparedStatement preparedStatement;

    public CityDAO() throws SQLException {
    }

    @Override
    public City getById(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(GET_CITY_BY_ID);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();

        result.next();
        Country country = new Country(result.getString("country_name"), result.getInt("countryId"));
        City city = new City(result.getInt("city_id"), result.getString("city_name"), country);

        return city;
    }

    @Override
    public ArrayList<City> getAll() throws SQLException {

        preparedStatement = connection.prepareStatement(GET_ALL_CITIES);
        ResultSet result = preparedStatement.executeQuery();

        ArrayList<City> cities = new ArrayList<>();

        while (result.next()) {
            Country country = new Country(result.getString("country_name"), result.getInt("countryId"));
            City city = new City(result.getInt("city_id"), result.getString("city_name"), country);

            cities.add(city);
        }

        return cities;
    }

    @Override
    public void insertRow(City object) throws SQLException {

        preparedStatement = connection.prepareStatement(INSERT_CITY);
        preparedStatement.setString(1, object.getCity_name());
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
    public void updateRow(int id, City object) throws SQLException {

        preparedStatement = connection.prepareStatement(UPDATE_CITY);
        preparedStatement.setString(1, object.getCity_name());
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
