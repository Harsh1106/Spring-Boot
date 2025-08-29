package com.Harsh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component
public class Alien {
    @Value("21")
    private int age;
//    private Laptop lap;
//    @Autowired
//    @Qualifier("com2")
    private Computer com;

    public Alien(){
        System.out.println("Alien Object Created");
    }

//    @ConstructorProperties({"age", "lap1"})
//    public Alien(int age){
//        System.out.println("Para Constructor Called");
//        this.age = age;
//    }

//    public Alien(int age, Laptop lap) {
//        this.age = age;
//        this.lap = lap;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
//        System.out.println("Setter called");
// firstly the object will be created then constructor called then the setter will be called
        this.age = age;
    }

//    public Laptop getLap() {
//        return lap;
//    }
//
//    public void setLap(Laptop lap) {
//        this.lap = lap;
//    }


    public Computer getCom() {
        return com;
    }

    @Autowired
    @Qualifier("laptop")
    public void setCom(Computer com) {
        this.com = com;
    }

    public void code(){
        System.out.println("Coding");
//        lap.compile();
        com.compile();
    }
}
