package org.example.lk.ijse.BO.BoImpl;

import org.example.lk.ijse.BO.custom.ItemBo;
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.custom.ItemDao;
import org.example.lk.ijse.Entity.Item;
import java.sql.SQLException;
import java.util.List;

public class ItemBOImpl implements ItemBo {

    ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.ITEM);

    @Override
    public boolean saveItem(Item entity){
        return itemDao.save(new Item(entity.getCode(),entity.getName(),entity.getQty(),entity.getPrice()));
    }

    @Override
    public boolean UpdateItem(Item entity){
        return itemDao.update(new Item(entity.getCode(),entity.getName(),entity.getQty(),entity.getPrice()));
    }

    @Override
    public boolean deleteItem(int id) {
        return itemDao.delete(id);
    }

    @Override
    public List<Item> getAllItem() throws SQLException {

        List<Item>list = itemDao.getAll();
        return list;

    }

}
