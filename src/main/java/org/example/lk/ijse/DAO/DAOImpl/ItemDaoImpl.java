package org.example.lk.ijse.DAO.DAOImpl;

import org.example.lk.ijse.DAO.custom.ItemDao;
import org.example.lk.ijse.Entity.Item;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
