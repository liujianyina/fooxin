package cn.fooxin.web.domain;

import cn.fooxin.web.utils.Constant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by liujianyin on 2017/12/26.
 */

@Entity
@Table(name = Constant.TABLE_PREFIX + "product")
public class Product extends BaseDomain {
    private static final long serialVersionUID = -8612727653591242759L;
    
    /**
     * 标题
     */
    @NotNull(message = "标题不能为空")
    @Column(length = 32, nullable = false)
    private String title;


    /**
     * 小标题
     */
    @Column(length = 16)
    private String smallTitle;

    /**
     * 查看地址
     */
    @Column(length = 20)
    private String viewAddr;

    /**
     * 详情
     */
    private String detals;

    /**
     * 图片url
     */
    private String imgUrl;

    /**
     * 前段class
     */
    private String clz;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSmallTitle() {
        return smallTitle;
    }

    public void setSmallTitle(String smallTitle) {
        this.smallTitle = smallTitle;
    }

    public String getViewAddr() {
        return viewAddr;
    }

    public void setViewAddr(String viewAddr) {
        this.viewAddr = viewAddr;
    }

    public String getDetals() {
        return detals;
    }

    public void setDetals(String detals) {
        this.detals = detals;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }
}
