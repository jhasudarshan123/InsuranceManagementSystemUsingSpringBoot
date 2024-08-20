package com.javatpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan
public class SpringBootCrudOperationApplication 
{
public static void main(String[] args) 
{
SpringApplication.run(SpringBootCrudOperationApplication.class, args);
}
}
