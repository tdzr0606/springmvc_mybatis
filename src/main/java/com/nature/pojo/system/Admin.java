package com.nature.pojo.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员表
 */
public class Admin implements Serializable
{
    private Integer id;
    private String userName;// 用户名称
    private String loginName;
    private String password;// 登陆帐号
    @JsonFormat(pattern = "yyyy-MM-dd")  // json转换 format
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 数据提交  format
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd")  // json转换 format
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 数据提交  format
    private Date updateTime;
    private Integer roleId;// 所属角色
    private String linkMobile;

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getLinkMobile()
    {
        return linkMobile;
    }

    public void setLinkMobile(String linkMobile)
    {
        this.linkMobile = linkMobile;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public Integer getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }
}
