package com.Harsh;

public class Laptop implements Computer {
//    public Laptop(){
//        System.out.println("Laptop object is created");
//    }


    @Override
    public void compile(){
        System.out.println("Compiling using Laptop");
    }
}
