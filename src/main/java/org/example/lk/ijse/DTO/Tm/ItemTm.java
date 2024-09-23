package org.example.lk.ijse.DTO.Tm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.lk.ijse.Controller.ItemController;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemTm extends ItemController {


    private int code;
    private String name;
    private int qty;
    private String price;

}
