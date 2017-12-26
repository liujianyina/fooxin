package cn.fooxin.web.domain;

import cn.fooxin.web.utils.Constant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by liujianyin on 2017/12/25.
 */


@Entity
@Table(name = Constant.TABLE_PREFIX + "recruit")
public class Recruit extends BaseDomain {
    private static final long serialVersionUID = 6113989056508917511L;

    /**
     * 标题
     */
    @NotNull
    @Column(nullable = false, length = 32)
    private String title;


    /**
     * 岗位描述
     */
    private String description;

    /**
     * 任职资格
     */
    private String qualifications;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
