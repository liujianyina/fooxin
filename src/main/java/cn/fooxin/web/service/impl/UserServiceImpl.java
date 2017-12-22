package cn.fooxin.web.service.impl;

import cn.fooxin.web.domain.Role;
import cn.fooxin.web.domain.User;
import cn.fooxin.web.repository.UserRepository;
import cn.fooxin.web.service.UserService;
import cn.fooxin.web.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Map;

/**
 * Created by liujianyin on 2017/11/18.
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
    public User login(String number, String password) {
        return userRepository.login(number, Utils.getMD5String(password));
    }

    @Override
    public Page<User> queryUserBySids(int page, int limit, List<Long> sids) {

        Specification<User> specification = (root, query, builder) -> {
            return root.get("sid").in(sids);
        };

        Pageable pageable = new PageRequest(page - 1, limit);

        return userRepository.findAll(specification, pageable);
    }

    public void batchSaveTeacher(List<Map<String, String>> list, List<Role> roles) {
        list.forEach(e -> {

            User user = new User();
            user.setNumber(e.get("职工号"));
            user.setCname(e.get("姓名"));
            user.setPassword(Utils.getMD5String(e.get("职工号")));
            user.setRoleList(roles);

            this.save(user);
        });

    }

    @Override
    public void batchSaveStudent(List<Map<String, String>> list, List<Role> roles) {

        list.forEach(e -> {

            User user = new User();
            user.setNumber(e.get("学号"));
            user.setCname(e.get("▲姓名"));
            user.setPassword(Utils.getMD5String(e.get("学号")));
            user.setRoleList(roles);

            this.save(user);
        });

    }

    @Override
    public User findByNumber(String number) {
        return userRepository.findByNumber(number);
    }

    @Override
    public Page<User> userSearch(String keyWord, List<Long> userSids, int page, int limit) {
        return userRepository.findAll((root, query, cb) -> {

            Predicate p1 = root.get("sid").in(userSids);  //只能在教师集合中取值
            if (!Utils.isEmpty(keyWord)) {
                Predicate p2 = cb.like(root.get("cname"), "%" + keyWord + "%");
                Predicate p3 = cb.like(root.get("number"), "%" + keyWord + "%");
                query.where(cb.and(p1, cb.or(p2, p3)));
            } else {
                query.where(cb.and(p1));
            }

            return query.getRestriction();
        }, new PageRequest(page - 1, limit));
    }
}
