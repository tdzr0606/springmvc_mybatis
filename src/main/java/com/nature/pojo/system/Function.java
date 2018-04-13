package com.nature.pojo.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 功能
 */
public class Function implements Serializable
{
    private Integer id;
    private String functionName;
    private String url;
    private Integer parentId;
    @JsonFormat(pattern = "yyyy-MM-dd")  // json转换 format
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 数据提交  format
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd")  // json转换 format
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 数据提交  format
    private Date updateTime;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFunctionName()
    {
        return functionName;
    }

    public void setFunctionName(String functionName)
    {
        this.functionName = functionName;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Integer getParentId()
    {
        return parentId;
    }

    public void setParentId(Integer parentId)
    {
        this.parentId = parentId;
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
