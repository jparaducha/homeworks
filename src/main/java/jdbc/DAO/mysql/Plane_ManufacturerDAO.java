package jdbc.DAO.mysql;

import jdbc.DAO.IBaseDAO;
import jdbc.Plane_Manufacturer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class Plane_ManufacturerDAO implements IBaseDAO<Plane_Manufacturer> {

    public final String INSERT_MANUFACTURER = "INSERT INTO plane_manufacturers(manufacturer_name) " + "VALUES(?)";
    public final String GET_MANUFACTURER_BY_ID = "SELECT * FROM plane_manufacturers WHERE manufacturer_id = ?";
    public final String GET_ALL_MANUFACTURERS = "SELECT * FROM plane_manufacturers ORDER BY manufacturer_id";
    public final String DELETE_BY_ID = "DELETE FROM plane_manufacturers WHERE manufacturer_id = ?";
    public final String UPDATE_MANUFACTURER = "UPDATE plane_manufacturers SET manufacturer_name =  ? WHERE manufacturer_id = ?";
    public final String DELETE_ALL = "DELETE FROM plane_manufacturers";
    private final Logger LOGGER = LogManager.getLogger(Plane_ManufacturerDAO.class);
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_task", "root", "root");

    public Plane_ManufacturerDAO() throws SQLException {
    }

    @Override
    public Plane_Manufacturer getById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_MANUFACTURER_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Plane_Manufacturer manufacturer = new Plane_Manufacturer(result.getInt("manufacturer_id"), result.getString("manufacturer_name"));

            return manufacturer;
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
    public ArrayList<Plane_Manufacturer> getAll() throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(GET_ALL_MANUFACTURERS);

            ResultSet result = preparedStatement.executeQuery();

            ArrayList<Plane_Manufacturer> manufacturers = new ArrayList<>();

            while (result.next()) {

                Plane_Manufacturer manufacturer = new Plane_Manufacturer(result.getInt("manufacturer_id"), result.getString("manufacturer_name"));

                manufacturers.add(manufacturer);
            }

            return manufacturers;
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
    public void insertRow(Plane_Manufacturer object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_MANUFACTURER);
            preparedStatement.setString(1, object.getManufacturer_name());

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
            preparedStatement.setInt(1, id);

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
    public void updateRow(int id, Plane_Manufacturer object) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_MANUFACTURER);
            preparedStatement.setString(1, object.getManufacturer_name());
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
