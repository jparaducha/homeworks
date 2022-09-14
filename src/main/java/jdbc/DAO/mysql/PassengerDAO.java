package jdbc.DAO.mysql;

import jdbc.DAO.IBaseDAO;
import jdbc.Passenger;

import java.sql.*;
import java.util.ArrayList;

public class PassengerDAO implements IBaseDAO<Passenger> {

    public final String INSERT_PASSENGER = "INSERT INTO passengers(passenger_name) " + "VALUES(?)";
    public final String GET_PASSENGER_BY_ID = "SELECT * FROM passengers  WHERE passenger_id = ?";
    public final String GET_ALL_PASSENGERS = "SELECT * FROM passengers  ORDER BY passenger_id";
    public final String DELETE_BY_ID = "DELETE FROM passengers WHERE passenger_id = ?";
    public final String UPDATE_PASSENGER = "UPDATE passengers SET passenger_name =  ? WHERE passenger_id = ?";
    public final String DELETE_ALL = "DELETE FROM passengers";
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_task", "root", "root");
    PreparedStatement preparedStatement;

    public PassengerDAO() throws SQLException {
    }

    @Override
    public Passenger getById(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(GET_PASSENGER_BY_ID);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();

        result.next();

        Passenger passenger = new Passenger(result.getInt("passenger_id"), result.getString("passenger_name"));

        return passenger;
    }

    @Override
    public ArrayList<Passenger> getAll() throws SQLException {
        preparedStatement = connection.prepareStatement(GET_ALL_PASSENGERS);

        ResultSet result = preparedStatement.executeQuery();

        ArrayList<Passenger> passengers = new ArrayList<>();

        while (result.next()) {
            Passenger passenger = new Passenger(result.getInt("passenger_id"), result.getString("passenger_name"));

            passengers.add(passenger);
        }

        return passengers;
    }

    @Override
    public void insertRow(Passenger object) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_PASSENGER);
        preparedStatement.setString(1, object.getPassenger_name());

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {

        preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void updateRow(int id, Passenger object) throws SQLException {

        preparedStatement = connection.prepareStatement(UPDATE_PASSENGER);
        preparedStatement.setString(1, object.getPassenger_name());
        preparedStatement.setInt(2, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteAll() throws SQLException {

        preparedStatement = connection.prepareStatement(DELETE_ALL);

        preparedStatement.executeUpdate();
    }
}