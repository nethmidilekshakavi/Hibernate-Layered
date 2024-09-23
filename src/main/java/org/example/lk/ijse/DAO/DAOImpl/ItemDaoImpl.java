package org.example.lk.ijse.DAO.DAOImpl;

import org.example.lk.ijse.DAO.custom.ItemDao;
import org.example.lk.ijse.Entity.Item;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean save(Item entity){

        Session sessions = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = sessions.beginTransaction();


        sessions.save(entity);

        transaction.commit();
        sessions.close();

        return false;

    }

    @Override
    public boolean update(Item entity){

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();

        return false;
    }

    @Override
    public boolean delete(int code){

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery nativeQuery = session.createNativeQuery("delete from Item where code = ?1");
        nativeQuery.setParameter(1,code);
        nativeQuery.executeUpdate();

        transaction.commit();
        session.close();

        return false;
    }

}
