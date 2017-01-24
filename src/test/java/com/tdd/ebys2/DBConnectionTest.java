package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;

/**
 * Created by darthvader on 24.01.2017.
 */
public class DBConnectionTest {
    private DBConnection dbcon;

    @Before
    public void setup() {
        //Setup
        dbcon = new DBConnection("someAdress", "username", "password");
    }

    @Test
    public void createDBConnectionTest() {
        //Verify
        assertTrue("Failed to create DBConnection object", dbcon instanceof DBConnection);
    }

    @Test
    public void getConnectionTest() throws SQLException {
        //TODO
    }

    @Test
    public void executeQueryTest() {
        //TODO
    }

    @Test
    public void closeConnectionTest() {
        //TODO

    }
}
