package com.harsh.springdatajpaex;

import com.harsh.springdatajpaex.model.Student;
import com.harsh.springdatajpaex.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaExApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataJpaExApplication.class, args);

        StudentRepo repo = context.getBean(StudentRepo.class);

        Student s1 = context.getBean(Student.class);
        Student s2 = context.getBean(Student.class);
        Student s3 = context.getBean(Student.class);

//        s1.setRollNo(101);
//        s1.setName("Harsh");
//        s1.setMarks(73);
//
//        s2.setRollNo(102);
//        s2.setName("Abhi");
//        s2.setMarks(80);
//
        s3.setRollNo(103);
        s3.setName("Ram");
        s3.setMarks(45);
//
//        repo.save(s1);
//        repo.save(s2);
//        repo.save(s3);

        //System.out.println(repo.findAll()); //return all the values from db
        //System.out.println(repo.findById(101)); //the return type of this method is Optional

//        Optional<Student> s = repo.findById(104); //this will return Optional
//        System.out.println(s.orElse(new Student()));

//        System.out.println(repo.findByName("Harsh"));
//        System.out.println(repo.findByMarks(80));
//        System.out.println(repo.findByMarksGreaterThan(70));

//        repo.save(s3); --> update the repo
        repo.delete(s3);
    }

}
