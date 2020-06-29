package mss.service.user.service;

import mss.service.user.entity.User;

//Service层接收调用，调用dao,服务controller
//StudentService定义了一系列接口，StudentServiceImpl实现接口
public interface UserService {
    User getUserById(Integer id);//通过id获得该条数
}


