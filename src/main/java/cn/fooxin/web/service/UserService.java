package cn.fooxin.web.service;


import cn.fooxin.web.domain.Role;
import cn.fooxin.web.domain.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by liujianyin on 2017/11/18.
 */

public interface UserService extends BaseService<User> {

    /**
     * 用户登录
     *
     * @param number   工号或者学号
     * @param password 密码
     * @return
     */
    User login(String number, String password);

    /**
     * 分页查询角色下所有用户
     *
     * @param page
     * @param limit
     * @return
     */
    Page<User> queryUserBySids(int page, int limit, List<Long> roleSids);

    /**
     * 批量导入教师用户
     *
     * @param list
     * @param roles
     */
    void batchSaveTeacher(List<Map<String, String>> list, List<Role> roles);

    /**
     * 批量导入学生用户
     *
     * @param list
     * @param roles
     */
    void batchSaveStudent(List<Map<String, String>> list, List<Role> roles);

    /**
     * 按照number查询用户
     *
     * @param number
     * @return
     */
    User findByNumber(String number);

    Page<User> userSearch(String keyWord, List<Long> userSids, int page, int limit);


}
