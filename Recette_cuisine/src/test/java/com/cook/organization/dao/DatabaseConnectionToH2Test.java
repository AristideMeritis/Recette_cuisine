package com.cook.organization.dao;

import org.junit.jupiter.api.*;
import org.mockito.*;

import java.sql.Connection;

class DatabaseConnectionToH2Test {

    @Mock
    DatabaseConnexion dbCToH2;
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