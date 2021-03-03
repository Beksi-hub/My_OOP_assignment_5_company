package kz.aitu.oop.pratice.assigment5.data.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
