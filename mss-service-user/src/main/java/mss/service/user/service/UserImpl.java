package mss.service.user.service;

import mss.service.user.dao.UserDao;
import mss.service.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements  UserService {
    @Autowired
    private UserDao userDao;

//    @Override
//    public ResponseData<User> getUserById(Integer id) {
//        ResponseData<User> ret = ResponseData.fail("not found");
//        User obj =  userDao.findById(id).orElse(null);
//        if(obj != null){
//            ret = ResponseData.success(obj);
//        }
//        return  ret;
//    }

    @Override
    public User getUserById(Integer id) {

        User ret =  userDao.findById(id).orElse(null);
//        if(obj != null){
//            ret = Result.ofSuccess(obj);
//        }
        return  ret;
    }
}
