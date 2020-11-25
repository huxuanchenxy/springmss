package mss.service.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {
    @GetMapping("user")
    public User user() {
        User u = new User(100L, "u1");
        return u;
    }

    @GetMapping("health.json")
    public String health() {
        return "{\"status\":\"up\"}";
    }

    @GetMapping("userList")
    public List<User> userList(){
        List<User> list = new ArrayList<User>();
        list.add(new User(100L, "u1"));
        list.add(new User(200L, "u2"));
        return list;
    }

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