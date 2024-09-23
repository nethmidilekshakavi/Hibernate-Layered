package org.example.lk.ijse.DAO.DAOImpl;

import org.example.lk.ijse.DAO.custom.CustomerDao;
import org.example.lk.ijse.Entity.Customer;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {


    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {

        Session sessions = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = sessions.beginTransaction();


        sessions.save(entity);

        transaction.commit();
        sessions.close();

        return false;
    }

    @Override
    public boolean update(Customer entity){

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();

        return false;
    }

    @Override
    public boolean delete(int entity){

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        NativeQuery nativeQuery = session.createNativeQuery("delete from Customer where id = ?1");
        nativeQuery.setParameter(1,entity);
        nativeQuery.executeUpdate();


        transaction.commit();
        session.close();

        return false;
    }

    @Override
    public List<Customer> getAll() throws SQLException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Customer>list = session.createQuery("from Customer",Customer.class).list();


        transaction.commit();
        session.close();


        return list;
    }

}
