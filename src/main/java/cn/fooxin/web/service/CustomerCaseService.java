package cn.fooxin.web.service;

import cn.fooxin.web.domain.CustomerCase;

import java.util.List;

/**
 * Created by liujianyin on 2017/12/26.
 */

public interface CustomerCaseService extends BaseService<CustomerCase> {

    List<CustomerCase> findAll();

}
