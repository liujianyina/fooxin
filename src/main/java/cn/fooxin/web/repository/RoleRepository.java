package cn.fooxin.web.repository;


import cn.fooxin.web.domain.Role;

import java.util.List;

/**
 * Created by liujianyin on 2017/11/28.
 */

public interface RoleRepository extends BaseRepository<Role> {

    List<Role> findAllByStatus(int status);

}

