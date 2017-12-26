package cn.fooxin.web.domain;

import cn.fooxin.web.utils.Constant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by liujianyin on 2017/12/25.
 */

@Entity
@Table(name = Constant.TABLE_PREFIX + "user")
public class User extends BaseDomain {
    private static final long serialVersionUID = -8398411846182073577L;

    /**
     * 登录名
     */
    @NotNull(message = "用户名不能为空")
    @Column(length = 32, nullable = false)
    private String username;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    @Column(length = 32, nullable = false)
    private String password;

    /**
     * 性别
     */
    @Column(length = 2)
    private String sex;

    /**
     * 真实姓名
     */
    @Column(length = 12)
    private String cname;

    /**
     * 电话号码
     */
    @Column(length = 11)
    private String phoneNum;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = Constant.TABLE_PREFIX + "user_role", joinColumns = {@JoinColumn(name = "user_sid")}, inverseJoinColumns = {@JoinColumn(name = "role_sid")})
    private List<Role> roleList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
