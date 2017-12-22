package cn.fooxin.web.domain;

import cn.fooxin.web.utils.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

/**
 * Created by liujianyin on 2017/11/17.
 */

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseDomain implements BaseDomainInterface {

    /**
     * 标识SID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", nullable = false, updatable = false)
    protected Long sid;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "create_time", nullable = false, updatable = false)
    protected Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "update_time", nullable = false)
    protected Date updateTime;
    /**
     * 状态：-1.已删除；0.无效；1.有效
     */
    @Column(nullable = false)
    protected int status = 1;

    public BaseDomain() {
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Date getCreateTime() {
        if (Utils.isNull(createTime)) {
            return new Date();
        } else {
            DateTime date = new DateTime(createTime, DateTimeZone.UTC);
            return date.toDate();
        }
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        DateTime date = new DateTime(updateTime, DateTimeZone.UTC);
        return date.toDate();
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public Map<String, Object> toMap() {
        return Utils.toMap(this, null, null);
    }

    @Override
    public Map<String, Object> toMapWithInclude(String[] fields) {
        return Utils.toMap(this, fields, null);
    }

    @Override
    public Map<String, Object> toMapWithExclude(String[] fields) {
        return Utils.toMap(this, null, fields);
    }

    /**
     * 取得实体对象对应的表名
     *
     * @return
     */
    public String getTableName() {
        Table ann = this.getClass().getAnnotation(Table.class);
        if (null != ann) {
            if (!Utils.isEmpty(ann.name())) {
                return ann.name();
            }
        }
        return "";
    }

    /**
     * 取得实体类名
     *
     * @return
     */
    public String getClsName() {
        return this.getClass().getSimpleName();
    }


}
