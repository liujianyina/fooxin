package cn.fooxin.web.domain;

import cn.fooxin.web.utils.Constant;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by liujianyin on 2017/12/26.
 */

@Entity
@Table(name = Constant.TABLE_PREFIX + "serviceCenter")
public class ServiceCenter extends BaseDomain {


    /**
     * 标题
     */
    @NotNull(message = "标题不能为空")
    @Column(nullable = false, updatable = false, length = 30)
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片
     */
    private String imgUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
