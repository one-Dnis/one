package com.company.example.movies.dao.connectionpool;

import java.sql.Connection;

public class ConnectionPoolAccess {

    private final ConnectionPool CONNECTION_POOL;
    private Connection connection;

    public ConnectionPoolAccess() throws ConnectionPoolException {
        CONNECTION_POOL = new ConnectionPool();
        this.connection = CONNECTION_POOL.takeConnection();
    }

    public Connection getConnection() {
        return connection;
    }
}
