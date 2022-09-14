package jdbc.DAO.mysql;

import jdbc.DAO.IBaseDAO;
import jdbc.Pilot;
import jdbc.Pilot_License;

import java.sql.*;
import java.util.ArrayList;

public class PilotDAO implements IBaseDAO<Pilot> {

    public final String INSERT_PILOT = "INSERT INTO pilots(pilot_name, pilot_age, licenseId) " + "VALUES(?,?,?)";
    public final String GET_PILOT_BY_ID = "SELECT * FROM pilots LEFT JOIN pilot_licenses ON pilots.licenseId = pilot_licenses.license_id WHERE id_pilot = ?";
    public final String GET_ALL_PILOTS = "SELECT * FROM pilots ORDER BY id_pilot";
    public final String DELETE_BY_ID = "DELETE FROM pilots WHERE id_pilot = ?";
    public final String UPDATE_PILOT = "UPDATE pilots SET pilot_name =  ?, pilot_age = ?, licenseId = ? WHERE id_pilot = ?";
    public final String DELETE_ALL = "DELETE FROM pilots";
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_task", "root", "root");
    PreparedStatement preparedStatement;

    public PilotDAO() throws SQLException {
    }

    @Override
    public Pilot getById(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(GET_PILOT_BY_ID);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();

        result.next();
        Pilot_License license = new Pilot_License(result.getInt("license_id"), result.getString("issued_on"), result.getString("expires"), result.getInt("pilotId"));

        Pilot pilot = new Pilot(result.getInt("id_pilot"), result.getString("pilot_name"), result.getInt("pilot_age"), license);

        return pilot;
    }

    @Override
    public ArrayList<Pilot> getAll() throws SQLException {
        preparedStatement = connection.prepareStatement(GET_ALL_PILOTS);
        ResultSet result = preparedStatement.executeQuery();

        ArrayList<Pilot> pilots = new ArrayList<>();

        while (result.next()) {

            Pilot_License license = new Pilot_License(result.getInt("license_id"), result.getString("issued_on"), result.getString("expires"), result.getInt("pilotId"));

            Pilot pilot = new Pilot(result.getInt("id_pilot"), result.getString("pilot_name"), result.getInt("pilot_age"), license);

            pilots.add(pilot);
        }

        return pilots;
    }

    @Override
    public void insertRow(Pilot object) throws SQLException {

        preparedStatement = connection.prepareStatement(INSERT_PILOT);
        preparedStatement.setString(1, object.getPilot_name());
        preparedStatement.setInt(2, object.getPilot_age());
        preparedStatement.setInt(3, object.getLicense().getLicense_id());

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {

        preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void updateRow(int id, Pilot object) throws SQLException {

        preparedStatement = connection.prepareStatement(UPDATE_PILOT);
        preparedStatement.setString(1, object.getPilot_name());
        preparedStatement.setInt(2, object.getPilot_age());
        preparedStatement.setInt(3, object.getLicense().getLicense_id());
        preparedStatement.setInt(4, id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteAll() throws SQLException {

        preparedStatement = connection.prepareStatement(DELETE_ALL);

        preparedStatement.executeUpdate();
    }
}
