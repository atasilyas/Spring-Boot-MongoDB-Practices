package com.atasilyas.springbootmongodbpractices.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.repository.Aggregation;


@Document(collection = "account")
@Data
@EqualsAndHashCode(of = {"id"})
public class Account
{
    @Id
    private String id;

    @Field(name = "name", targetType = FieldType.STRING)
    private String username;

    @Field(name = "pass", targetType = FieldType.STRING)
    private String password;

    @Field(name = "full_name", targetType = FieldType.STRING)
    private  String fullName;

    @Field(name = "status", targetType = FieldType.BOOLEAN)
    private  boolean status;
}
