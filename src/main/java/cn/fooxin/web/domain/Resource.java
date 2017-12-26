package cn.fooxin.web.domain;


import cn.fooxin.web.utils.Constant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 菜单
 * Created by liujianyin on 2017/11/17.
 */

@Entity
@Table(name = Constant.TABLE_PREFIX + "resource")
public class Resource extends BaseDomain implements Comparable<Resource> {
    private static final long serialVersionUID = 3318095271168375713L;

    /**
     * 菜单名称
     */
    @Column
    private String cname;

    /**
     * 菜单链接
     */
    @Column
    private String url;

    /**
     * 排序
     */
    @Column
    @OrderBy("ASC")
    private Integer sort;

    /**
     * 父级SID
     */
    @Column
    private Long parentSid;

    /**
     * 前端class属性
     */
    @Column
    private String cls;

    /**
     * 资源类型
     */
    @Column
    private Integer type;

    /**
     * 是否显示
     */
    private int display = 1;

    @Transient
    private List<Resource> children = new ArrayList<>();

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getParentSid() {
        return parentSid;
    }

    public void setParentSid(Long parentSid) {
        this.parentSid = parentSid;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public List<Resource> getChildren() {
        return children;
    }

    public void setChildren(List<Resource> children) {
        this.children = children;
    }


    /**
     * 添加子菜单
     *
     * @param resource
     */
    public void addChild(Resource resource) {
        if (!children.contains(resource)) {
            children.add(resource);
            Collections.sort(children);
        }
    }

    /**
     * 删除子菜单
     *
     * @param resource
     */
    public void removeChild(Resource resource) {
        this.children.remove(resource);
    }

    /**
     * 将列表中的所有菜单加入到子菜单列表中
     *
     * @param list
     */
    public void addAllChildren(List<Resource> list) {
        if (null != list && !list.isEmpty()) {
            for (Resource r : list) {
                Long parentSid = r.getParentSid();
                if (null != parentSid && parentSid.equals(sid) && !children.contains(r)) {
                    addChild(r);
                }
            }

            Collections.sort(children);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sid == null) ? 0 : sid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Resource)) {
            return false;
        }
        Resource other = (Resource) obj;
        if (sid == null) {
            if (other.sid != null) {
                return false;
            }
        } else if (!sid.equals(other.sid)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Resource o) {
        return this.sort.compareTo(o.getSort());
    }


    /**
     * 资源类型
     */
    public enum RESOURCE_TYPE {
        /**
         * 系统菜单资源，需要授权才能访问
         */
        MENU(1),

        /**
         * 非系统菜单资源，需要授权才能访问
         */
        NONE_MENU(2),

        /**
         * 可匿名访问资源，无需授权也能访问
         */
        ANONYMOUS(3);

        private int value;

        RESOURCE_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


}
