package cn.fooxin.web.repository;

import cn.fooxin.web.domain.Resource;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by liujianyin on 2017/11/17.
 */

public interface ResourceRepository extends BaseRepository<Resource> {

    /**
     * 根据父级sid查找所有子菜单
     *
     * @param parentSid
     * @return
     */
    @Query("SELECT r FROM Resource r WHERE r.parentSid = ?1 ORDER BY sort ASC")
    List<Resource> findByParentSid(Long parentSid);

    /**
     * 查询根节点
     *
     * @return
     */
    @Query("SELECT r FROM Resource r WHERE (r.parentSid IS NULL OR r.parentSid = -1) AND r.type IN (1,2) ORDER BY sort ASC ")
    List<Resource> findRoot();

    /**
     * 根据类别查询有效的资源列表
     *
     * @return
     */
    @Query("SELECT r FROM Resource r WHERE r.status = 1 ORDER BY sort ASC")
    List<Resource> findAllValid();


    /**
     * 根据类别查询有效的资源列表
     *
     * @param type
     * @return
     */
    @Query("SELECT r FROM Resource r WHERE r.type = ?1 AND r.status = 1 ORDER BY sort ASC")
    List<Resource> findValidByType(Integer type);


    @Query("SELECT r FROM Resource r WHERE r.type IN ?1 AND r.status = 1 ORDER BY sort ASC")
    List<Resource> findValidByType(Integer[] types);

}
