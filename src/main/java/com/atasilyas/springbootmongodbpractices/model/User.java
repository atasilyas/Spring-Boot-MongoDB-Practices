package com.atasilyas.springbootmongodbpractices.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
@Data
@EqualsAndHashCode(of = {"id"})
public class User {

    @Id
    private String id;

    @Field(name = "name", targetType = FieldType.STRING)
    private String name;

    @Field(name = "age", targetType = FieldType.INT32)
    private int age;

    @Field(name = "isActive", targetType = FieldType.BOOLEAN)
    private Boolean active;

    @DBRef
    @Field(name = "userProducts")
    private List<Product> productList = new ArrayList<>();

    @DBRef
    @Field(name = "userAccount")
    private Account account;

}
