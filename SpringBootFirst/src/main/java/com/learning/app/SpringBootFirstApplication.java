package com.learning.app;

import com.learning.app.model.Alien;
import com.learning.app.model.Laptop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.learning.app.service.LaptopService;

@SpringBootApplication
public class SpringBootFirstApplication	 {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootFirstApplication.class, args);
//		Alien obj = context.getBean(Alien.class);
//		System.out.println(obj.getAge());
//		obj.code();

		LaptopService service = context.getBean(LaptopService.class);

		Laptop lap = context.getBean(Laptop.class);
		service.addLaptop(lap);


//		getBean() will only works if IoC has bean of that class.
//		to create the bean of class we must use @Component annotation of the respective class.
//		Alien obj = context.getBean(Alien.class);
//		obj.code();

//		Alien obj1 = context.getBean(Alien.class);
//		obj1.code();

		// because spring is by default singleton in nature we can explicitly change that
//		for changing the behaviour we can use this annotation over the Alien class @Scope("prototype").
	}

}
