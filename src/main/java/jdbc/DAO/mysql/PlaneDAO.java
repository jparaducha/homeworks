package jdbc.DAO.mysql;

import jdbc.DAO.IPlaneDAO;
import jdbc.Plane;
import jdbc.Plane_Manufacturer;

import java.sql.*;
import java.util.ArrayList;

public class PlaneDAO implements IPlaneDAO {

    public static final String INSERT_PLANE = "INSERT INTO planes(year,modelId) " + "VALUES(?,?)";
    public static final String GET_PLANE_BY_ID = "SELECT * FROM planes INNER JOIN plane_models ON planes.modelId = plane_models.model_id INNER JOIN plane_manufacturers ON plane_models.manufacturer = plane_manufacturers.manufacturer_id JOIN flights ON planes.plane_id = flights.planeId  WHERE plane_id = ? ORDER BY plane_id";
    public static final String GET_ALL_PLANES = "SELECT * FROM planes INNER JOIN plane_models ON planes.modelId = plane_models.model_id INNER JOIN plane_manufacturers ON plane_models.manufacturer = plane_manufacturers.manufacturer_id LEFT JOIN flights ON planes.plane_id = flights.planeId ORDER BY plane_id";
    public static final String DELETE_BY_ID = "DELETE FROM planes WHERE plane_id = ?";
    public static final String UPDATE_PLANE = "UPDATE planes SET year =  ? , modelId = ?";
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_task", "root", "root");
    PreparedStatement preparedStatement;

    public PlaneDAO() throws SQLException {
    }

    @Override
    public Plane getPlaneById(long id) throws SQLException {

        preparedStatement = connection.prepareStatement(GET_PLANE_BY_ID);
        preparedStatement.setLong(1, id);
        ResultSet plane = preparedStatement.executeQuery();

        plane.next();
        Plane_Manufacturer manufacturer = new Plane_Manufacturer(plane.getInt("manufacturer_id"), plane.getString("manufacturer_name"));
        Plane plane1 = new Plane(plane.getInt("plane_id"), plane.getInt("year"), plane.getString(plane.findColumn("model_name")), manufacturer);

        return plane1;
    }

    @Override
    public ArrayList<Plane> getAllPlanes() throws SQLException {
        ArrayList<Plane> planeList = new ArrayList<>();

        preparedStatement = connection.prepareStatement(GET_ALL_PLANES);
        ResultSet planes = preparedStatement.executeQuery();

        while (planes.next()) {
            Plane_Manufacturer manufacturer = new Plane_Manufacturer(planes.getInt("manufacturer_id"), planes.getString("manufacturer_name"));
            planeList.add(new Plane(planes.getInt("plane_id"), planes.getInt("year"), planes.getString(planes.findColumn("model_name")), manufacturer));
        }

        return planeList;
    }

    @Override
    public void insertPlane(int year, int model) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_PLANE);
        preparedStatement.setInt(1, year);
        preparedStatement.setInt(2, model);
        int rs = preparedStatement.executeUpdate();
    }

    @Override
    public void updatePlane(Plane plane) throws SQLException {
        preparedStatement = connection.prepareStatement(UPDATE_PLANE);

        preparedStatement.setInt(1, plane.getPlaneId());
        preparedStatement.setInt(2, plane.getModelId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void deletePlane(long planeId) throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setLong(1, planeId);

        preparedStatement.executeUpdate();
    }
}
