package mss.service.demo;

import lombok.Data;

@Data
public class User {
    private Long userId;
    private String userName;
    public User(Long userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }
}