package cn.fooxin.web.service.impl;

import cn.fooxin.web.domain.CustomerCase;
import cn.fooxin.web.repository.CustomerCaseRepository;
import cn.fooxin.web.service.CustomerCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liujianyin on 2017/12/26.
 */

@Service
public class CustomerCaseServiceImpl extends BaseServiceImpl<CustomerCase, CustomerCaseRepository> implements CustomerCaseService {

    private CustomerCaseRepository customerCaseRepository;

    @Autowired
    @Override
    public void setRepository(CustomerCaseRepository repository) {
        this.customerCaseRepository = repository;
        this.baseRepository = repository;
    }

    @Override
    public List<CustomerCase> findAll() {
        return customerCaseRepository.findAll();
    }
}
