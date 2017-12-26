package cn.fooxin.web.service.impl;

import cn.fooxin.web.domain.User;
import cn.fooxin.web.repository.UserRepository;
import cn.fooxin.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liujianyin on 2017/12/25.
 */

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserService {

    private UserRepository userRepository;

    @Autowired
    @Override
    public void setRepository(UserRepository repository) {
        this.userRepository = repository;
        this.baseRepository = repository;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

}
