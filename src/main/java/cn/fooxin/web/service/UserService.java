package cn.fooxin.web.service;

import cn.fooxin.web.domain.User;

/**
 * Created by liujianyin on 2017/12/25.
 */

public interface UserService extends BaseService<User> {

    User login(String username, String password);

}
