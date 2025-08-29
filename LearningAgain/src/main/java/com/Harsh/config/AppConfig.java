package com.Harsh.config;

import com.Harsh.Alien;
import com.Harsh.Computer;
import com.Harsh.Desktop;
import com.Harsh.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.Harsh")
public class AppConfig {

//    @Bean
//    public Alien alien(@Qualifier("desktop") Computer com){
//        Alien obj = new Alien();
//        obj.setAge(25);
//        obj.setCom(com);
//        return  obj;
//    }
//
////    @Bean(name = {"com2", "desltop1", "yoyo"}) --> array of name of beans
//    @Bean  //single name of bean which is desktop
////    @Scope("prototype")
//    public Desktop desktop(){
//        return  new Desktop();
//    }
//
//    @Bean
//    public Laptop laptop(){
//        return new Laptop();
//    }
}
