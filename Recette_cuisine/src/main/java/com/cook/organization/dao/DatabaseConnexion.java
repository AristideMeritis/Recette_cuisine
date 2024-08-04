package com.cook.organization.dao;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DatabaseConnexion {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5433/recetteDB";
    private static String DRIVER_CLASS_NAME = "org.postgresql.Driver";
    private static final Logger logger = LogManager.getLogManager().
            getLogger("DatabaseConnectionToH2.class");
    private static final String USER = "ada";
    private static final String PASSWORD = "azerty";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Connection con;
        Class.forName(DRIVER_CLASS_NAME);
        con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        importDataForPersonFromCsv(con);
        return con;
    }

    public static void importDataForPersonFromCsv(Connection con) throws SQLException {
        URL csvRessource =  DatabaseConnexion.class.getResource("/SQL/personne.csv");
        if(csvRessource == null)
             throw new IllegalArgumentException("CSV file not found");

        String csvFilePath = null;
        try {
            csvFilePath = Paths.get(csvRessource.toURI()).toString();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        String sqlParameters = csvFilePath.replace('/','\\');

        String createPersonneSql = "CREATE TABLE PERSONNE(ID INT PRIMARY KEY, NAME VARCHAR(255), Email VARCHAR(255)) AS SELECT * FROM CSVREAD('"+sqlParameters+"');";

         PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(createPersonneSql);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ps.close();
        }

    }
}

