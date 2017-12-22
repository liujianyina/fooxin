package cn.fooxin.web.domain;


import cn.fooxin.web.utils.Constant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户
 * Created by liujianyin on 2017/11/17.
 */

@Entity
@Table(name = Constant.TABLE_PREFIX + "user")
public class User extends BaseDomain {
    private static final long serialVersionUID = 5217837587969356444L;

    /**
     * 工号或者学号
     */
    @NotNull(message = "number不能为空")
    @Column(nullable = false, updatable = false, unique = true)
    private String number;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    @Column(nullable = false)
    private String password;

    /**
     * 真实姓名
     */
    @NotNull(message = "姓名不能为空")
    @Column(nullable = false, updatable = false)
    private String cname;

    /**
     * 头像地址
     */
    @Column
    private String imgurl = "/static/img/user.png";

    /**
     * 性别
     */
    @Column
    private String sex;

    /**
     * 微信登陆taken
     */
    @Column
    private String wxTaken;

    /**
     * 手机号码
     */
    @Column
    private String phoneNum;

    /**
     * 年级
     */
    @Column
    private String gradle;

    /**
     * 专业
     */
    private String major;

    /**
     * 班级
     */
    private String clz;

    /**
     * 部门
     */
    private String department;

    /**
     * 职称
     */
    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = Constant.TABLE_PREFIX + "user_role", joinColumns = {@JoinColumn(name = "user_sid")}, inverseJoinColumns = {@JoinColumn(name = "role_sid")})
    private List<Role> roleList;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWxTaken() {
        return wxTaken;
    }

    public void setWxTaken(String wxTaken) {
        this.wxTaken = wxTaken;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getGradle() {
        return gradle;
    }

    public void setGradle(String gradle) {
        this.gradle = gradle;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }


    /**
     * 取得用户所有可访问url
     *
     * @return
     */
    public Set<String> getResourceUrls() {
        Set<String> urls = new HashSet<>();

        if (null != roleList && !roleList.isEmpty()) {
            for (Role role : roleList) {
                if (role.status == 1) {
                    urls.addAll(role.getResourceUrls());
                }
            }
        }

        return urls;
    }

    /**
     * 取得用户所有可访问的菜单 sid
     *
     * @return
     */
    public Set<Long> getResourceSids() {
        Set<Long> sids = new HashSet<>();
        if (null != roleList && !roleList.isEmpty()) {
            for (Role role : roleList) {
                if (role.status == 1) {
                    sids.addAll(role.getResourceSids());
                }
            }
        }
        return sids;
    }
}
