package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public PagingResponse getAllUser(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(name = "item_per_page" ,defaultValue = "10") int itemPerPage) {

        PagingResponse pagingResponse = new PagingResponse(page, itemPerPage);
        List<UsersResponse> usersResponseList = new ArrayList<>();
        usersResponseList.add(new UsersResponse(1, "User 1"));
        usersResponseList.add(new UsersResponse(2, "User 2"));
        usersResponseList.add(new UsersResponse(3, "User 3"));
        pagingResponse.setUsersResponse(usersResponseList);
        return pagingResponse;
    }
//    @GetMapping("/users")
//    public String getAllUser
//    (@RequestParam(value = "page",required = false,defaultValue = "1")int page,
//     @RequestParam(value = "itemperpage",required = false,defaultValue = "10")int itemPerPage)
//    {
//        return "page = " + page +"itemPerPage = "+ itemPerPage;
//    }
    @GetMapping("/users/{id}")
    public UsersResponse getUserById(@PathVariable int id){
        return new UsersResponse(id,"User "+id);
    }
//    @GetMapping("/users/page{page}")
//    public UsersResponse getAllUserPaging(@PathVariable int page){
//        return UsersResponse(id,"User"+id);
//
//    }

    @PostMapping("/users")
    public UsersResponse createNewUser(@RequestBody NewUserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());
        user = userRepository.save(user);
        return new UsersResponse(user.getId(),user.getName()+ user.getAge());
    }
}
