package com.Harsh;

import java.beans.ConstructorProperties;

public class Alien {
    private int age;
//    private Laptop lap;
    private Computer com;

    public Alien(){
        System.out.println("Alien Object Created");
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }
//    @ConstructorProperties({"age", "lap"})
//    public Alien(int age, Laptop lap) {
//        System.out.println("Para Constructor Called");
//        this.lap = lap;
//        this.age = age;
//    }
//
    public int getAge() {
        return age;
    }
//firstly it will create the object then it will call the setter method and then only it will execute other parts
    public void setAge(int age) {
//        System.out.println("setter called");
        this.age = age;
    }
//
//    public Laptop getLap() {
//        return lap;
//    }
//
//    public void setLap(Laptop lap) {
//        this.lap = lap;
//    }
//
    public void code(){
        System.out.println("Coding");
        com.compile();
    }
}
