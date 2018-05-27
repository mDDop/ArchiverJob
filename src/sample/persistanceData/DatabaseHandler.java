package sample.persistanceData;


import javafx.collections.ObservableList;
import javax.swing.*;
import java.sql.*;


public final class DatabaseHandler {

    private static DatabaseHandler handler;

    private static final String DB_URL = "jdbc:derby:database;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;

    public DatabaseHandler() {
        createConnection();
        setJobsTable();
    }

    void createConnection(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setJobsTable(){
        String tableName = "JOB";
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, tableName.toUpperCase(), null);

            if (tables.next()){
                System.out.println("Table "+ tableName + " already exist.");
            } else {
                String createQuery ="CREATE TABLE " + tableName +
                        " (id int not null GENERATED ALWAYS AS IDENTITY primary key, " +
                        "name_company varchar(200), " +
                        "position_job varchar(50), " +
                        "address_job varchar(200), " +
                        "email varchar(200), " +
                        "phone varchar(20), " +
                        "date_sent date, " +
                        "link varchar(200))";
                System.out.println(createQuery);
                stmt.execute(createQuery);
                System.out.println("Table created");
                System.out.println(tables.getMetaData().getTableName(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet execQuery(String execQuery){
        ResultSet result;
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(execQuery);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    public boolean setAction(String insertQuery){
        try {
            stmt = conn.createStatement();
            stmt.execute(insertQuery);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error occured", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {

        }
    }

    public ObservableList setlectAllJobs() throws SQLException {
        String selectAllJobs = "SELECT * FROM JOB";
        ObservableList listJobs;
        stmt = conn.createStatement();
        listJobs = (ObservableList) stmt.executeQuery(selectAllJobs);
        System.out.println(listJobs.toString());
        return listJobs;

    }


}
