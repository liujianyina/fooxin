package cn.fooxin.web.repository;

import cn.fooxin.web.domain.Solutions;

import java.util.List;

/**
 * Created by liujianyin on 2017/12/26.
 */

public interface SolutionsRepository extends BaseRepository<Solutions> {

    List<Solutions> findAllByType(String type);

}
