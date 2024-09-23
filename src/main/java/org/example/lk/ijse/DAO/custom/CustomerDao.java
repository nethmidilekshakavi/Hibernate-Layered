package org.example.lk.ijse.DAO.custom;


import org.example.lk.ijse.CrudDao;
import org.example.lk.ijse.DTO.ItemDTO;
import org.example.lk.ijse.Entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao extends CrudDao<Customer> {

     boolean save(ItemDTO entity);

     boolean update(Customer entity);

     boolean delete(int entity);

    List<Customer> getAll() throws SQLException;
}
