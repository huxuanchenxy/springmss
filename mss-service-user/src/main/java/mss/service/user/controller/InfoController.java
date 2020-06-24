package mss.service.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @RequestMapping("/hello")
    public String say(){
        return "Hello SpringBoot!";
    }
}
