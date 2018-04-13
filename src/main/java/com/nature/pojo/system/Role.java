package com.nature.pojo.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限
 */
public class Role implements Serializable
{
    private Integer id;//INT(11) UNSIGNED
    private String roleName;//VARCHAR(255)      角色名称
    private String functionId;//
    @JsonFormat(pattern = "yyyy-MM-dd")  // json转换 format
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 数据提交  format
    private Date createTime;//
    @JsonFormat(pattern = "yyyy-MM-dd")  // json转换 format
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 数据提交  format
    private Date updateTime;//

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    public String getFunctionId()
    {
        return functionId;
    }

    public void setFunctionId(String functionId)
    {
        this.functionId = functionId;
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
}
