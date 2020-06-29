package mss.service.user.controller;

import mss.service.user.entity.User;
import mss.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping ("/user/{id}")
    public String getUser(Integer id){
        User user = userService.getUserById(id);
        String ret = user.getAccName();
        return ret;
    }
}
