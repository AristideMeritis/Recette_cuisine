package cook.organization.dao;

import java.net.URL;
import java.sql.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DatabaseConnectionToH2 {

    private static final String JDBC_URL = "jdbc:h2:~/recipedb;AUTO_SERVER=TRUE";
    private static String DRIVER_CLASS_NAME = "org.h2.Driver";
    private static final Logger logger = LogManager.getLogManager().
            getLogger("DatabaseConnectionToH2.class");
    private static final String USER = "sa";
    private static final String PASSWORD = "";


    public static Connection getConnectionToH2() throws SQLException, ClassNotFoundException {

        Connection con;
        Class.forName(DRIVER_CLASS_NAME);
        con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        importDataForPersonFromCsv(con);
        return con;
    }

    public static void importDataForPersonFromCsv(Connection con) {
        URL csvRessource =  DatabaseConnectionToH2.class.getResource("/personne.csv");
        if(csvRessource == null)
             throw new IllegalArgumentException("CSV file not found");

        String csvFilePath = csvRessource.getPath();
        String createPersonnesql = "CREATE TABLE PERSONNE AS SELECT * FROM CSVREAD(?)";

        try (PreparedStatement ps = con.prepareStatement(createPersonnesql)){
            ps.setString(1,csvFilePath);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

