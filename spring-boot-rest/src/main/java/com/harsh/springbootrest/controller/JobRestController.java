package com.harsh.springbootrest.controller;

import com.harsh.springbootrest.model.JobPost;
import com.harsh.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController //if we are using this instead of @Controller then it says whatever u return is treated as body.
@CrossOrigin(origins = "http://localhost:5173")
public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping(path="jobPosts") //by defining this it will forcefully states that it will return json format file only.
//    @GetMapping(path="jobPosts", produces = "application/json") //by defining this it will forcefully states that it will return json format file only.
//    @ResponseBody //using this annotation it tells that we aren't returning any view instead of it we are actually returning the actual data
    //if we are using @RestController then we don't need to use @ResponseBody annotation to return the body, @RestController handles that issue on itw own.
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs(); //Jacksons library are the reasons for conversions of Objects into JSON
    }

    @GetMapping("jobPost/{id}")
    public JobPost getJob(@PathVariable int id){
        return jobService.getJob(id);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return jobService.search(keyword);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost){ //as a server when want to accept the data then use @RequestBody
        jobService.addJob(jobPost);
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

//Content Negotiation
//    @DeleteMapping(path = "jobPost/{postId}", consumes = {"application/xml"}) //this states that it can only accept the xml types
    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        jobService.deleteJob(postId);
        return "deleted";
    }

    @GetMapping("load")
    public String load(){
        jobService.load();
        return "success";
    }
}
