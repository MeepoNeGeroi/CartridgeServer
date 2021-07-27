package org.example.model.dao;

public interface DAO {
    int read();

    default int create() {
        return 0;
    }
}