package cn.fooxin.web.service.impl;

import cn.fooxin.web.domain.Solutions;
import cn.fooxin.web.repository.SolutionsRepository;
import cn.fooxin.web.service.SolutionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liujianyin on 2017/12/26.
 */

@Service
public class SolutionsServiceImpl extends BaseServiceImpl<Solutions, SolutionsRepository> implements SolutionsService {

    private SolutionsRepository solutionsRepository;

    @Autowired
    @Override
    public void setRepository(SolutionsRepository repository) {
        this.solutionsRepository = repository;
        this.baseRepository = repository;
    }

    @Override
    public List<Solutions> findAllByType(String type) {
        return solutionsRepository.findAllByType(type);
    }
}
