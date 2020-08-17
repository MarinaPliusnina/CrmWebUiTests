package DataBase;

import config.Config;

import java.sql.*;

public class DataBase {

    private String url;
    private String user;
    private String password;

    Connection conn = null;

    public DataBase(){

        readConfig();

    }

    private void readConfig() {

        url= "jdbc:postgresql://" +Config.getProperty("host")+":"+Config.getProperty("port")+"/"+Config.getProperty("dbname");
        user=Config.getProperty("user");
        password = Config.getProperty("pass");
    }

    public Connection connect() throws SQLException {

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } return conn;
    }

    public String queryToString(String sQ) throws SQLException {

        String resultString = "";

        try {

            Statement stat = conn.createStatement();

            ResultSet result = stat.executeQuery(sQ);


            while (result.next()) {

                for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                    resultString += " " + result.getString(i);
                }

            }
        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            if (conn != null) {
                conn.close();
            }
        }

        return resultString;
    }

}