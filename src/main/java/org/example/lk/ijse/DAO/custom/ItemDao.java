package org.example.lk.ijse.DAO.custom;
import org.example.lk.ijse.CrudDao;
import org.example.lk.ijse.DTO.ItemDTO;
import org.example.lk.ijse.Entity.Item;

public interface ItemDao extends CrudDao<Item> {

    boolean update(Item entity);

    boolean delete(int code);
}
