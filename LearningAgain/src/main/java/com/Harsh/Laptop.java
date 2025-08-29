package com.Harsh;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
    public Laptop(){
        System.out.println("Lapotp object created");
    }
    @Override
    public void compile(){
        System.out.println("Compiling using Laptop");
    }
}
