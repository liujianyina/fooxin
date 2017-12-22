package cn.fooxin.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * repository基础封装接口
 * Created by liujianyin on 2017/11/17.
 */

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

}
