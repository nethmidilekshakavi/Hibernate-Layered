package org.example.lk.ijse.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.lk.ijse.Controller.ItemController;
import org.example.lk.ijse.Entity.Item;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO extends ItemController {
    private int code;
    private String name;
    private int qty;
    private String price;


}
