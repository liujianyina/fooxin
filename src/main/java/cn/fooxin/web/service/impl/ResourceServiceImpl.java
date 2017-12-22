package cn.fooxin.web.service.impl;

import cn.fooxin.web.domain.Resource;
import cn.fooxin.web.repository.ResourceRepository;
import cn.fooxin.web.service.ResourceService;
import cn.fooxin.web.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liujianyin on 2017/11/18.
 */

@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource, ResourceRepository> implements ResourceService {

    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    @Override
    public void setRepository(ResourceRepository repository) {
        this.resourceRepository = repository;
        this.baseRepository = repository;
    }

    @Override
    public List<Resource> findByParentSid(Long parentSid) {
        return resourceRepository.findByParentSid(parentSid);
    }

    @Override
    public List<Resource> parseResourceTree(List<Resource> resources) {
        List<Resource> first = new ArrayList<>();

        for (Resource r : resources) {
            if (Utils.isNull(r.getParentSid()) || r.getParentSid().equals(-1L)) {
                first.add(r);
            }
        }

        resources.removeAll(first);
        for (Resource r : first) {
            r.setChildren(getChildren(r, resources));
        }

        Collections.sort(first);

        return first;
    }

    private List<Resource> getChildren(Resource parent, List<Resource> resources) {

        List<Resource> children = new ArrayList<>();

        for (Resource r : resources) {

            if (r.getParentSid().equals(parent.getSid())) {
                children.add(r);
                r.setChildren(getChildren(r, resources));
            }

        }

        Collections.sort(children);
        return children;
    }


    @Override
    public List<Resource> findRoot() {
        return resourceRepository.findRoot();
    }

    @Override
    public List<Resource> findAllValid() {
        return resourceRepository.findAllValid();
    }

    @Override
    public List<Resource> findValidByType(Integer type) {
        return resourceRepository.findValidByType(type);
    }

    @Override
    public List<Resource> findValidByType(Integer[] types) {
        return resourceRepository.findValidByType(types);
    }

    @Override
    public Page<Resource> pageQuery(int page, int limit) {
        return resourceRepository.findAll(new PageRequest(page - 1, limit));
    }
}
