package cn.fooxin.web.service;

import cn.fooxin.web.domain.ServiceCenter;

import java.util.List;

/**
 * Created by liujianyin on 2017/12/26.
 */

public interface ServiceCenterService extends BaseService<ServiceCenter> {

    List<ServiceCenter> findAll();

}
