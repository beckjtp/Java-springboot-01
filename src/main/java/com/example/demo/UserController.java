package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

//    @GetMapping("/users")
//    public List<UsersResponse>  getAllUser(){
//        List<UsersResponse> users = new ArrayList<>();
//        users.add(new UsersResponse(1,"User 1" ));
//        users.add(new UsersResponse(2,"User 2"));
////        UsersResponse[] usersResponses = new UsersResponse[2];
////        usersResponses[0] = new UsersResponse(1, "User 1");
////        usersResponses[1] = new UsersResponse(2, "User 2");
//        return users;
//    }
    @GetMapping("/users")
    public String getAllUser
    (@RequestParam(value = "page",required = false,defaultValue = "1")int page,
     @RequestParam(value = "itemperpage",required = false,defaultValue = "10")int itemPerPage)
    {
        return "page = " + page +"itemPerPage = "+ itemPerPage;
    }
    @GetMapping("/users/{id}")
    public UsersResponse getUserById(@PathVariable int id){
        return new UsersResponse(id,"User "+id);
    }
//    @GetMapping("/users/page{page}")
//    public UsersResponse getAllUserPaging(@PathVariable int page){
//        return UsersResponse(id,"User"+id);
//
//    }
}
