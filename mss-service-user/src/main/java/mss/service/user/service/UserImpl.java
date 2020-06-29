package mss.service.user.service;

import mss.service.user.dao.UserDao;
import mss.service.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements  UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.findById(id).orElse(null);
    }
}
