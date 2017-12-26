package cn.fooxin.web.service.impl;

import cn.fooxin.web.domain.ServiceCenter;
import cn.fooxin.web.repository.ServiceCenterRepository;
import cn.fooxin.web.service.ServiceCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liujianyin on 2017/12/26.
 */

@Service
public class ServiceCenterServiceImpl extends BaseServiceImpl<ServiceCenter, ServiceCenterRepository> implements ServiceCenterService {

    private ServiceCenterRepository serviceCenterRepository;

    @Autowired
    @Override
    public void setRepository(ServiceCenterRepository repository) {
        this.serviceCenterRepository = repository;
        this.baseRepository = repository;
    }

    @Override
    public List<ServiceCenter> findAll() {
        return serviceCenterRepository.findAll();
    }

}
