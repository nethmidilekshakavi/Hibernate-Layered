package org.example.lk.ijse;

import org.example.lk.ijse.DAO.SuperDao;
import org.example.lk.ijse.DTO.ItemDTO;

public interface CrudDao <T> extends SuperDao {

    boolean save(T entity);

}
