package com.junming.spring_boot_crud_example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data   //this annotation is lombok getter, setter and other boilerplate codes
@AllArgsConstructor  //automatically generate a Product constructor with all arguments
@NoArgsConstructor    //automatically generate a Product constructor with no arguments
@Entity   //representing data that can be persisted to the database
@Table(name = "Product_TBL")
@Builder
public class Product {

    @Id   //primary key
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //auto-increment primary key
    private Integer id;

    private String name;
    private Integer quantity;
    private Double price;

}
