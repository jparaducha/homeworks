package jdbc.DAO.mysql;

import jdbc.City;
import jdbc.Country;
import jdbc.DAO.IBaseDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CountryDAO implements IBaseDAO<Country> {

    public final String INSERT_COUNTRY = "INSERT INTO countries(country_name) " + "VALUES(?)";
    public final String GET_COUNTRY_BY_ID = "SELECT * FROM countries LEFT JOIN cities ON countries.country_id = cities.countryId WHERE country_id = ?";
    public final String GET_ALL_COUNTRIES = "SELECT * FROM countries LEFT JOIN cities ON countries.country_id = cities.countryId ORDER BY country_id"; // LEFT JOIN airlines ON countries.country_id = airlines.countryId
    public final String DELETE_BY_ID = "DELETE FROM countries WHERE country_id = ?";
    public final String UPDATE_COUNTRY = "UPDATE countries SET country_name =  ? WHERE country_id = ?";
    public final String DELETE_ALL = "DELETE FROM countries";
    private final Logger LOGGER = LogManager.getLogger(CountryDAO.class);
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_task", "root", "root");

    public CountryDAO() throws SQLException {
    }

    @Override
    public Country getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement(GET_COUNTRY_BY_ID);

            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            Country country = new Country();
            result.next();

            country.setCountry_name(result.getString("country_name"));
            ArrayList<City> cities = new ArrayList<>();

            City city = new City(result.getInt("city_id"), result.getString("city_name"), result.getInt("country_id"));

            cities.add(city);
            while (result.next()) {
                city = new City(result.getInt("city_id"), result.getString("city_name"), result.getInt("country_id"));

                cities.add(city);
            }

            country.setCities(cities);

            return country;
        } catch (SQLException e) {
            LOGGER.error(e);
            return null;
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public ArrayList<Country> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement(GET_ALL_COUNTRIES, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = preparedStatement.executeQuery();

            Country country;
            ArrayList<Country> countries = new ArrayList<>();
            ArrayList<City> cities = new ArrayList<>();
            Set<City> citiesSet = new HashSet<>();
            //Set<Airline> airlinesSet;
            //ArrayList<Airline> airlines;

            while (rs.next()) {
                String currCountry = rs.getString("country_name");
                country = new Country();
                cities = new ArrayList<>();
                //airlines = new ArrayList<>();
                citiesSet = new HashSet<>();
                //airlinesSet = new HashSet<>();

                country.setCountry_name(rs.getString("country_name"));
                //cities.add(new City(rs.getString("city_name")));

                while (currCountry.equals(rs.getString("country_name"))) {
                    //if (rs.getString("airline_name") != null) {
                    //airlines.add(new Airline(rs.getString("airline_name")));
                    //}

                    if (rs.getString("city_name") != null) {
                        cities.add(new City(rs.getString("city_name")));
                    }
                    rs.next();
                }
                if (!rs.isFirst() && !rs.isLast()) {
                    rs.previous();
                }

                citiesSet.addAll(cities);
                cities = new ArrayList<>(citiesSet);
            /*
            airlinesSet.addAll(airlines);

            airlines = new ArrayList<>(airlinesSet);

            country.setAirlines(airlines);
            */
                country.setCities(cities);

                countries.add(country);
            }

            return countries;
        } catch (SQLException e) {
            LOGGER.error(e);
            return null;
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public void insertRow(Country object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement(INSERT_COUNTRY);
            preparedStatement.setString(1, object.getCountry_name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public void updateRow(int id, Country object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_COUNTRY);
            preparedStatement.setString(1, object.getCountry_name());
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public void deleteAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement(DELETE_ALL);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }
}
