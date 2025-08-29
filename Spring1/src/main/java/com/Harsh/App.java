package com.Harsh;
import com.Harsh.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
// Java Based Config
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Desktop dt = context.getBean("desktop",Desktop.class);
//   the above name is used by the "Bean Name". the bean name   and the method name should be same
//        Desktop dtNew = context.getBean("com1",Desktop.class); //the bean name is changed and we are using a array of bean name
// and we can use any name specified in the Bean array
//        dt.compile();

//        on changing the Scope we will result with the 2 object
//Singleton: Like a single water bottle shared by everyone — the same object reused.
//Prototype: Like a vending machine that gives a new bottle every time — always a new object.
//        Desktop dt = context.getBean(Desktop.class);
//        dt.compile();
// In singleton, Spring creates one instance for the entire container. In prototype, a new instance is created every time it's requested.
//        Desktop dt1 = context.getBean(Desktop.class);
//        dt1.compile();




// XML Based Config
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //above line creates a container(IoC) for us
        //object is created in line 9 in below lines we are just using that object
        Alien obj1 = context.getBean(Alien.class);
//        obj1.setAge(21);
        System.out.println(obj1.getAge()); //->21
        obj1.code();

//        Alien obj2 =(Alien) context.getBean("alien1");
//        System.out.println(obj2.age); //-> 21 same value because by default it is singleton we can change the scope
//        obj2.code();

//        Laptop obj3 =(Laptop) context.getBean("lap");

//        Desktop obj = context.getBean(Desktop.class);
//
//        Computer comp = context.getBean(Computer.class);

    }
}
