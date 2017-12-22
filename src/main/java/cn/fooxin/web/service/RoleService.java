package cn.fooxin.web.service;

import cn.fooxin.web.domain.Role;
import org.springframework.data.domain.Page;

/**
 * Created by liujianyin on 2017/11/28.
 */

public interface RoleService extends BaseService<Role> {

    /**
     * 查询所有有效的角色
     *
     * @return
     */
    Page<Role> findAllRole(int page, int limit);

}
