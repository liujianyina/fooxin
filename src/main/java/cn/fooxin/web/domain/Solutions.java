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
@Table(name = Constant.TABLE_PREFIX + "solutions")
public class Solutions extends BaseDomain {
    private static final long serialVersionUID = 6824842856673552089L;

    /**
     * 类别
     */
    @NotNull(message = "类别不能为空")
    @Column(nullable = false)
    private String type;

    /**
     * 标题
     */
    @NotNull(message = "标题不能为空")
    @Column(nullable = false, length = 30)
    private String title;

    /**
     * 图片路径
     */
    private String imgUrl;


    /**
     * 简介
     */
    private String introduction;

    /**
     * 主要内容
     */
    private String content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
