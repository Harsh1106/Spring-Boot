package com.learning.app.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{

    public void compile(){
        System.out.println("Compiling in laptop");
    }
}
