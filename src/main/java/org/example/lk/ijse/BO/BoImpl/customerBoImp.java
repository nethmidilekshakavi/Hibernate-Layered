package org.example.lk.ijse.BO.BoImpl;

import org.example.lk.ijse.BO.custom.CustomerBO;
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.custom.CustomerDao;
import org.example.lk.ijse.Entity.Customer;

import java.sql.SQLException;
import java.util.List;


public class customerBoImp implements CustomerBO {

    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean saveCustomer(Customer customerModel) throws SQLException, ClassNotFoundException {
        return customerDao.save(new Customer(customerModel.getId() ,customerModel.getName(), customerModel.getAddress(), customerModel.getContact()));
    }

    @Override
    public boolean updateCustomer(Customer customerModel) throws SQLException, ClassNotFoundException {
        return customerDao.update(new Customer(customerModel.getId() ,customerModel.getName(), customerModel.getAddress(), customerModel.getContact()));
    }
    @Override
    public boolean deleteCustomer(int id) throws SQLException, ClassNotFoundException {
        return customerDao.delete(id);
    }


    @Override
   public List<Customer> getAllCustomer() throws SQLException {

        List<Customer>list = customerDao.getAll();
        return list;
    }
}
