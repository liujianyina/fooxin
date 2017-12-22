package cn.fooxin.web.domain;


import cn.fooxin.web.utils.Constant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色
 * Created by liujianyin on 2017/11/17.
 */

@Entity
@Table(name = Constant.TABLE_PREFIX + "role")
public class Role extends BaseDomain {
    private static final long serialVersionUID = -1643154207778712985L;

    /**
     * 角色名称
     */
    @Column
    private String cname;
    /**
     * 备注
     */
    @Column
    private String note;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = Constant.TABLE_PREFIX + "role_resource",
            joinColumns = {@JoinColumn(name = "role_sid")},
            inverseJoinColumns = {@JoinColumn(name = "resource_sid")})
    private List<Resource> resourceList;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Resource> getResourceList() {
        Set<Resource> resources = new HashSet<>();
        for (Resource r : resourceList) {
            resources.add(r);
        }

        List<Resource> result = new ArrayList<>();
        result.addAll(resources);

        return result;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    /**
     * 获取角色所有关联的资源url
     *
     * @return
     */
    public Set<String> getResourceUrls() {
        Set<String> names = new HashSet<>();
        for (Resource r : resourceList) {
            names.add(r.getUrl());
        }

        return names;
    }

    /**
     * 获取角色所有关联的资源SID
     *
     * @return
     */
    public Set<Long> getResourceSids() {
        Set<Long> sids = new HashSet<>();
        for (Resource r : resourceList) {
            sids.add(r.getSid());
        }

        return sids;
    }

}
