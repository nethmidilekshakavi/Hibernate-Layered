package org.example.lk.ijse;

import org.example.lk.ijse.DAO.SuperDao;
import org.example.lk.ijse.Entity.Customer;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDao <T> extends SuperDao {

    public boolean save(T entity) throws SQLException, ClassNotFoundException;

    boolean save(Customer entity) throws SQLException, ClassNotFoundException;
}
