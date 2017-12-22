package cn.fooxin.web.service;

import cn.fooxin.web.domain.Resource;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by liujianyin on 2017/11/18.
 */

public interface ResourceService extends BaseService<Resource> {

    /**
     * 根据父级sid查找所有子菜单
     *
     * @param parentSid
     * @return
     */
    List<Resource> findByParentSid(Long parentSid);

    /**
     * 将给定的资源列表组装为树型
     *
     * @param resources
     * @return
     */
    List<Resource> parseResourceTree(List<Resource> resources);

    /**
     * 查询所有有效的资源列表
     *
     * @return
     */
    List<Resource> findAllValid();

    /**
     * 查询一级菜单
     *
     * @return
     */
    List<Resource> findRoot();

    /**
     * 根据类别查询有效的资源列表
     *
     * @param type
     * @return
     */
    List<Resource> findValidByType(Integer type);

    /**
     * 根据类别查询有效的资源列表
     *
     * @param types
     * @return
     */
    List<Resource> findValidByType(Integer[] types);

    Page<Resource> pageQuery(int page, int limit);

}
