package com.tdd.ebys2;

import java.util.ArrayList;

/**
 * Created by darthvader on 24.01.2017.
 */
public class DBConnection {

    private final String address;
    private final String username;
    private final String password;

    public DBConnection(String address, String username, String password) {
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public ArrayList executeQuery(String sql) {
        return null;
    }
}
