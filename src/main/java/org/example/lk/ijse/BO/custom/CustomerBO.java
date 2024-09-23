package org.example.lk.ijse.BO.custom;

import org.example.lk.ijse.BO.SuperBo;
import org.example.lk.ijse.Entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerBO extends SuperBo {
    boolean saveCustomer(Customer customerModel) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(Customer customerModel) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(int id) throws SQLException, ClassNotFoundException;

    List<Customer> getAllCustomer() throws SQLException;
}
