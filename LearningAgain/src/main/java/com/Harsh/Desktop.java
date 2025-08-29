package com.Harsh;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("com2") //defining unique name to our custom bean
@Component
@Primary
@Scope("prototype")
public class Desktop implements Computer{
    public Desktop() {
        System.out.println("Desktop object created...");
    }

    @Override
    public void compile(){
        System.out.println("Compiling using Desktop");
    }
}
