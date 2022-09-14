package jdbc.DAO.mysql;

import jdbc.DAO.IBaseDAO;
import jdbc.Plane_Manufacturer;

import java.sql.*;
import java.util.ArrayList;

public class Plan_ManufacturerDAO implements IBaseDAO<Plane_Manufacturer> {

    public final String INSERT_MANUFACTURER = "INSERT INTO plane_manufacturers(manufacturer_name) " + "VALUES(?)";
    public final String GET_MANUFACTURER_BY_ID = "SELECT * FROM plane_manufacturers WHERE manufacturer_id = ?";
    public final String GET_ALL_MANUFACTURERS = "SELECT * FROM plane_manufacturers ORDER BY manufacturer_id";
    public final String DELETE_BY_ID = "DELETE FROM plane_manufacturers WHERE manufacturer_id = ?";
    public final String UPDATE_MANUFACTURER = "UPDATE plane_manufacturers SET manufacturer_name =  ? WHERE manufacturer_id = ?";
    public final String DELETE_ALL = "DELETE FROM plane_manufacturers";
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_task", "root", "root");
    PreparedStatement preparedStatement;

    public Plan_ManufacturerDAO() throws SQLException {
    }

    @Override
    public Plane_Manufacturer getById(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(GET_MANUFACTURER_BY_ID);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();

        result.next();
        Plane_Manufacturer manufacturer = new Plane_Manufacturer(result.getInt("manufacturer_id"), result.getString("manufacturer_name"));

        return manufacturer;
    }

    @Override
    public ArrayList<Plane_Manufacturer> getAll() throws SQLException {
        preparedStatement = connection.prepareStatement(GET_ALL_MANUFACTURERS);

        ResultSet result = preparedStatement.executeQuery();

        ArrayList<Plane_Manufacturer> manufacturers = new ArrayList<>();

        while (result.next()) {

            Plane_Manufacturer manufacturer = new Plane_Manufacturer(result.getInt("manufacturer_id"), result.getString("manufacturer_name"));

            manufacturers.add(manufacturer);
        }

        return manufacturers;
    }

    @Override
    public void insertRow(Plane_Manufacturer object) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_MANUFACTURER);
        preparedStatement.setString(1, object.getManufacturer_name());

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void updateRow(int id, Plane_Manufacturer object) throws SQLException {
        preparedStatement = connection.prepareStatement(UPDATE_MANUFACTURER);
        preparedStatement.setString(1, object.getManufacturer_name());
        preparedStatement.setInt(2, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteAll() throws SQLException {

        preparedStatement = connection.prepareStatement(DELETE_ALL);

        preparedStatement.executeUpdate();
    }
}
