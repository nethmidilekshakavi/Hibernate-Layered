package org.example.lk.ijse.DTO.Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.lk.ijse.Controller.CustomerController;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CusromerTM extends CustomerController {

    private int id;
    private  String name;
    private  String address;
    private  int contact;


}
