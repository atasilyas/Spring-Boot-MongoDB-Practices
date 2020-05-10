package com.atasilyas.springbootmongodbpractices;

import com.atasilyas.springbootmongodbpractices.model.Product;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.sun.javafx.collections.SortableList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.querydsl.QSort;
import org.springframework.data.repository.support.PageableExecutionUtils;

import java.util.ArrayList;
import java.util.List;

public class Practices {


    protected String getDatabaseName() {
        return "mongotest";
    }

    public MongoClient mongo() throws Exception {
        MongoClient client = new MongoClient("localhost");
        client.setWriteConcern(WriteConcern.SAFE);
        return client;
    }

    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }

    public static void main(String[] args) {
        Practices practices = new Practices();
        MongoTemplate mongoTemplate = null;
        try {
            mongoTemplate = practices.mongoTemplate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<Product> products = new ArrayList<>();
        Product product = new Product();

        // find all products using MongoTemplete
        products = mongoTemplate.findAll(Product.class);
        products.forEach(item -> System.out.println(item.toString()));
        System.out.println("*******************************************************************************************************");

        //Finf One by ID
        product = mongoTemplate.findById("5eb772d6ea92c5468b0a9e83", Product.class);
        System.out.println(product.toString());

        //Using Mongo Query find price lesser than 12
        Query query = new Query();
        query.addCriteria(Criteria.where("price").lt("12"));
        products = mongoTemplate.find(query, Product.class);
        products.forEach(item -> System.out.println(item.toString()));

        // using and operator in creteria and inside and using regex(like) and less greater eg...
        Query queryForAndOperator = new Query();
        Criteria criteria = new Criteria();
        criteria.andOperator(
                Criteria.where("price").lte("23232"),
                Criteria.where("name").regex("ipho")
        );
        queryForAndOperator.addCriteria(criteria);
        products = mongoTemplate.find(queryForAndOperator, Product.class);
        products.forEach(item -> System.out.println(item.toString()));


        // and condition with criteeria  functions
        Query query1 = new Query();
        Criteria criteria1 = new Criteria();
        criteria1.andOperator(
                Criteria.where("price").lte("23232"),
                Criteria.where("name").regex("fgfgf"),
                Criteria.where("_id").in("5eb777157e528f45a1008df1")
        );
        query1.addCriteria(criteria1);
        products = mongoTemplate.find(query1, Product.class);
        products.forEach(item -> System.out.println(item.toString()));


        // or condition
        Query queryOr = new Query();
        Criteria criteriaOr = new Criteria();
        criteriaOr.orOperator(
                Criteria.where("price").lte("23232"),
                Criteria.where("_id").in("5eb777157e528f45a1008df1")
        );
        queryOr.addCriteria(criteriaOr);
        products = mongoTemplate.find(queryOr, Product.class);
        products.forEach(item -> System.out.println(item.toString()));


        // like condition  contains :
        Query query2 = new Query();
        Criteria criteria2 = new Criteria();
        criteria2.andOperator(
                Criteria.where("name").regex("atas"));

        query2.addCriteria(criteria2);
        products = mongoTemplate.find(query2, Product.class);
        products.forEach(item -> System.out.println(item.toString()));


        // like conditin start with

        Query query3 = new Query();
        Criteria criteria3 = new Criteria();
        criteria3.andOperator(
                Criteria.where("name").regex("^at"),  // start with
                Criteria.where("name").regex("ilyas$") // end with

        );

        query3.addCriteria(criteria3);
        products = mongoTemplate.find(query3, Product.class);
        products.forEach(item -> System.out.println(item.toString()));


        // sort and limit

        Query query4 = new Query().with(Sort.by(Sort.Direction.DESC, "price"));
        query4.limit(5);  //get only 5 record
        products = mongoTemplate.find(query4, Product.class);
        products.forEach(item -> System.out.println(item.toString()));



        //Pageable

        Pageable pageable = PageRequest.of(4, 10, Sort.by(Sort.Direction.ASC, "price"));

        Query patientsDynamicQuery = new Query().with(pageable);
        // Add criteria's according to your wish to patientsDynamicQuery

        products = mongoTemplate.find(patientsDynamicQuery, Product.class);

        MongoTemplate finalMongoTemplate = mongoTemplate;
        Page<Product> patientPage = PageableExecutionUtils.getPage(
                products,
                pageable,
                () -> finalMongoTemplate.count(patientsDynamicQuery, Product.class));

        //insert delete update

        product = new Product();
        product.setCategoryId("23432545");
        product.setName("samsung s10");
        product.setPrice("2343");
        product.setQuantity("345");
        mongoTemplate.insert(product);

        product.setName("huawei p30 pro");  // update product
        mongoTemplate.save(product);



        product = new Product();
        product.setId("5eb777107e528f45a1008dee");
        mongoTemplate.remove(product);





    }
}
