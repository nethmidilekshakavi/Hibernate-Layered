package org.example.lk.ijse.BO.BoImpl;

import org.example.lk.ijse.BO.custom.ItemBo;
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.custom.ItemDao;
import org.example.lk.ijse.Entity.Item;

public class ItemBOImpl implements ItemBo {

    ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.ITEM);

    @Override
    public boolean saveItem(Item entity){
        return itemDao.save(new Item(entity.getCode(),entity.getName(),entity.getQty(),entity.getPrice()));
    }

}
