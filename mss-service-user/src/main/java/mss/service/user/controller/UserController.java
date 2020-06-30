package mss.service.user.controller;

import mss.service.user.entity.User;
import mss.service.user.service.UserService;
import mss.tool.global.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping ("/user/{id}")
    public ResponseData<User> getUser(Integer id){
        ResponseData<User> ret = userService.getUserById(id);
        return ret;
    }
}
