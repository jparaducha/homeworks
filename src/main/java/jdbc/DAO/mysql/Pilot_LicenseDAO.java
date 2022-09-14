package jdbc.DAO.mysql;

import jdbc.DAO.IBaseDAO;
import jdbc.Pilot_License;

import java.sql.*;
import java.util.ArrayList;

public class Pilot_LicenseDAO implements IBaseDAO<Pilot_License> {

    public final String INSERT_PILOTLICENSE = "INSERT INTO pilot_licenses(issued_on, expires, pilotId) " + "VALUES(?,?,?)";
    public final String GET_PILOTLICENSE_BY_ID = "SELECT * FROM pilot_licenses WHERE license_id = ?";
    public final String GET_ALL_PILOTLICENSES = "SELECT * FROM pilot_licenses ORDER BY license_id";
    public final String DELETE_BY_ID = "DELETE FROM pilot_licenses WHERE license_id = ?";
    public final String UPDATE_PILOTLICENSE = "UPDATE pilot_licenses SET issued_on =  ?, expires = ?, pilotId = ? WHERE license_id = ?";
    public final String DELETE_ALL = "DELETE FROM pilot_licenses";
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_task", "root", "root");
    PreparedStatement preparedStatement;

    public Pilot_LicenseDAO() throws SQLException {
    }

    @Override
    public Pilot_License getById(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(GET_PILOTLICENSE_BY_ID);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();

        Pilot_License license;

        result.next();
        license = new Pilot_License(result.getInt("license_id"), result.getString("issued_on"), result.getString("expires"), result.getInt("pilotId"));

        return license;
    }

    @Override
    public ArrayList<Pilot_License> getAll() throws SQLException {
        preparedStatement = connection.prepareStatement(GET_ALL_PILOTLICENSES);
        ResultSet result = preparedStatement.executeQuery();

        ArrayList<Pilot_License> licenses = new ArrayList<>();
        Pilot_License license;

        while (result.next()) {
            license = new Pilot_License(result.getInt("license_id"), result.getString("issued_on"), result.getString("expires"), result.getInt("pilotId"));

            licenses.add(license);
        }

        return licenses;
    }

    @Override
    public void insertRow(Pilot_License object) throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_PILOTLICENSE);
        preparedStatement.setString(1, object.getIssued_on());
        preparedStatement.setString(2, object.getExpires());
        preparedStatement.setInt(3, object.getPilot_id());

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {

        preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void updateRow(int id, Pilot_License object) throws SQLException {

        preparedStatement = connection.prepareStatement(UPDATE_PILOTLICENSE);
        preparedStatement.setString(1, object.getIssued_on());
        preparedStatement.setString(2, object.getExpires());
        preparedStatement.setInt(3, object.getPilot_id());
        preparedStatement.setInt(4, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteAll() throws SQLException {

        preparedStatement = connection.prepareStatement(DELETE_ALL);

        preparedStatement.executeUpdate();
    }
}
