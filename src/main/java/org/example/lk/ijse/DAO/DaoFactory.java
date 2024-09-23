package org.example.lk.ijse.DAO;
import org.example.lk.ijse.DAO.DAOImpl.CustomerDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS,QUERY_DAO,MEAL,EMPLOYEE,INGREDIENTS,SUPPLIER
    }

    public SuperDao getDAO(DAOTypes types){
        switch (types) {
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
               /* return new ItemDaoImpl();*/

        }
        return null;
    }
}
