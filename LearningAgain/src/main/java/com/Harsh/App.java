package com.Harsh;

import com.Harsh.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

       /* Desktop dt1 = context.getBean( Desktop.class);
        Desktop dt2 = context.getBean(Desktop.class);
        System.out.println(dt1 == dt2);
The answer "false" is correct because when a bean has a prototype scope, each call to context.getBean returns a new instance, so dt1 and dt2 refer to different objects, making the comparison dt1 == dt2 evaluate to false. This demonstrates your understanding of bean scopes in Spring Framework.
        */
//        Desktop dt = context.getBean("yoyo",Desktop.class);
//        Desktop dt = context.getBean(Desktop.class);
//        dt.compile();
//
//        Desktop dt1 = context.getBean(Desktop.class);
//        dt1.compile();

        Alien obj1 = context.getBean(Alien.class);
        System.out.println(obj1.getAge());
        obj1.code();


//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//  in line number 10 the object is getting created which are listed in side the xml file with bean tag
//  in below lines we are just calling/using the obejct which has been already created.
//        Alien obj1 = context.getBean("alien", Alien.class);
//        obj.setAge(21);
//        System.out.println(obj1.getAge());
//        obj1.code();

//        Alien obj1 = (Alien)context.getBean("alien");
//        System.out.println(obj1.age);
//        obj1.code();

//        Computer com = context.getBean(Computer.class);

//        Desktop obj = context.getBean(Desktop.class);
    }
}
