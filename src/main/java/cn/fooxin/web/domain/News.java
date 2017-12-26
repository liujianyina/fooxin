package cn.fooxin.web.domain;

import cn.fooxin.web.utils.Constant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * 新闻实体
 * Created by liujianyin on 2017/12/25.
 */

@Entity
@Table(name = Constant.TABLE_PREFIX + "news")
public class News extends BaseDomain {
    private static final long serialVersionUID = -8192467734453807859L;

    /**
     * 新闻类型
     */
    @NotNull(message = "新闻类型不能为空")
    @Column(length = 16, nullable = false)
    private String type;

    /**
     * 点击次数
     */
    private int count = 0;

    /**
     * 标题
     */
    private String title;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 内容
     */
    private String content;

    /**
     * 首页图片的内容
     */
    private String imgUrl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
