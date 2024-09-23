package org.example.lk.ijse.DAO.custom;


import org.example.lk.ijse.CrudDao;
import org.example.lk.ijse.DAO.SuperDao;
import org.example.lk.ijse.Entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerDao extends CrudDao<Customer> {


     boolean save(Customer entity) throws SQLException, ClassNotFoundException;

     boolean update(Customer entity);

     boolean delete(int entity);

    List<Customer> getAll() throws SQLException;
}
