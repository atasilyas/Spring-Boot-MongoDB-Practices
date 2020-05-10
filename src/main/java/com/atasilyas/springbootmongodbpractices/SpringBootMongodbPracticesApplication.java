package com.atasilyas.springbootmongodbpractices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringBootMongodbPracticesApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootMongodbPracticesApplication.class, args);
    }

}
