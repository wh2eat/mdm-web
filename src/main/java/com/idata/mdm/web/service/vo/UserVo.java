package com.idata.mdm.web.service.vo;

import java.util.Date;

public class UserVo {

    private Integer id;

    private String loginName;

    private String name;

    private String password;

    private Date createTime;

    private Date updateTime;

    private Date lastLoginTime;

    public UserVo() {
        // TODO Auto-generated constructor stub
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "UserVo [id=" + id + ", loginName=" + loginName + ", name=" + name + ", password=" + password
                + ", createTime=" + createTime + ", updateTime=" + updateTime + ", lastLoginTime=" + lastLoginTime
                + "]";
    }

}
