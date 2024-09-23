package org.example.lk.ijse.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ItemDTO {

    @Id
    private int code;
    private String name;
    private int qty;
    private String price;


}
