package cn.fooxin.web.repository;

import cn.fooxin.web.domain.User;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by liujianyin on 2017/11/18.
 */

public interface UserRepository extends BaseRepository<User> {

    @Query("SELECT u FROM User u WHERE u.number=?1 AND u.password=?2")
    User login(String number, String password);

    User findByNumber(String number);

}
