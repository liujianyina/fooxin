package cn.fooxin.web.service;

import cn.fooxin.web.domain.Recruit;
import org.springframework.data.domain.Page;

/**
 * Created by liujianyin on 2017/12/25.
 */

public interface RecruitService extends BaseService<Recruit> {

    Page<Recruit> queryPage(int page, int size);

}
