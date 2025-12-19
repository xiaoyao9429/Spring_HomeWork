package com.zhiwen.spgl.DateBase;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class product {

    Integer id;
    String name;
    Double price;
    String description;
    String product_image;
    Integer stock;
    Integer category_id;
}
