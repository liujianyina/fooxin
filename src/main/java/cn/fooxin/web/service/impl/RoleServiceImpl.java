package cn.fooxin.web.service.impl;

import cn.fooxin.web.domain.Role;
import cn.fooxin.web.repository.RoleRepository;
import cn.fooxin.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by liujianyin on 2017/11/28.
 */

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleRepository> implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    @Override
    public void setRepository(RoleRepository repository) {
        this.roleRepository = repository;
        this.baseRepository = repository;
    }

    @Override
    public Page<Role> findAllRole(int page, int limit) {
        return roleRepository.findAll(new PageRequest(page - 1, limit));
    }
}
