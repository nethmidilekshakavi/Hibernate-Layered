package org.example.lk.ijse.BO.custom;

import org.example.lk.ijse.BO.SuperBo;
import org.example.lk.ijse.DAO.SuperDao;
import org.example.lk.ijse.DTO.ItemDTO;
import org.example.lk.ijse.Entity.Item;

import java.sql.SQLException;

public interface ItemBo extends SuperBo {

    boolean saveItem(Item entity);

    boolean UpdateItem(Item entity);

    boolean deleteItem(int id) throws SQLException, ClassNotFoundException;
}
