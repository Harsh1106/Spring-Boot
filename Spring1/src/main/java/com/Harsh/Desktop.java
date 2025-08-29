package com.Harsh;

public class Desktop implements Computer{
    public Desktop() {
        System.out.println("Inside Desktop Constructor");
    }

    @Override
    public void compile(){
        System.out.println("Compiling using Desktop");
    }
}
