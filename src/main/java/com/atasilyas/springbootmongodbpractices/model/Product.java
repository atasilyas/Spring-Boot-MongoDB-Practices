package com.atasilyas.springbootmongodbpractices.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "product")
@Data
@EqualsAndHashCode(of = {"id"})
public class Product
{
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    private String name;

    private String price;

    private  String quantity;

    private  String categoryId;

}
