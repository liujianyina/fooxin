package cn.fooxin.web.service;

import cn.fooxin.web.domain.Solutions;

import java.util.List;

/**
 * Created by liujianyin on 2017/12/26.
 */

public interface SolutionsService extends BaseService<Solutions> {


    List<Solutions> findAllByType(String type);

}
