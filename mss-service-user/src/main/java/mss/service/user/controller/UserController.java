package mss.service.user.controller;

import mss.global.handler.IgnorReponseAdvice;
import mss.global.handler.ResponseData;
import mss.service.user.entity.User;
import mss.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {




    @GetMapping("test1")
    public String test1(){
        return "test1";
    }

    @GetMapping("test2")
    public ResponseData test2(){
        return ResponseData.success("test2");
    }

    @IgnorReponseAdvice
    @GetMapping("test3")
    public String test3() {
        return "test3";
    }

    @GetMapping("test4")
    public String test4() {
        Integer x = 1 / 0;
        return x.toString();
    }

    @GetMapping("test5")
    public String test5() throws Exception {
        throw new Exception("自定义异常信息");
    }
}
