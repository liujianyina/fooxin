package cn.fooxin.web.service.impl;

import cn.fooxin.web.domain.Recruit;
import cn.fooxin.web.repository.RecruitRepository;
import cn.fooxin.web.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liujianyin on 2017/12/25.
 */

@Service
public class RecruitServiceImpl extends BaseServiceImpl<Recruit, RecruitRepository> implements RecruitService {

    private RecruitRepository recruitRepository;

    @Autowired
    @Override
    public void setRepository(RecruitRepository repository) {
        this.recruitRepository = repository;
        this.baseRepository = repository;
    }

    @Override
    public List<Recruit> findAll() {
        return recruitRepository.findAll();
    }
}
