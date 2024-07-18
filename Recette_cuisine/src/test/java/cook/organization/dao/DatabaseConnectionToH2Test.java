package cook.organization.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DatabaseConnectionToH2Test {

    @Mock
    DatabaseConnectionToH2 dbCToH2;
    Connection con;
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

   /*  @Test
    @DisplayName("Test connection with the database")
   void TestgetConnectionToH2() throws SQLException {
       assertNotNull(dbCToH2);
        try {
            when(dbCToH2.getConnectionToH2()).thenReturn(con);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            when(dbCToH2.getConnectionToH2()).thenThrow(new SQLClientInfoException());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }*/
}