package com.nature.pojo.record;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * zzw_project
 * Record
 *
 * @Author: 竺志伟
 * @Date: 2018-03-05 17:26
 */
public class Record implements Serializable
{
    private Integer id;
    private String title;
    private String fileUrl;
    private Integer typeId;
    private String typeTitle;
    private Integer labelId;
    private String labelTitle;
    private Integer status;
    private String note;
    private String author;
    private String publish;
    private Integer createId;
    private String createName;
    @JsonFormat(pattern = "yyyy-MM-dd")  // json转换 format
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 数据提交  format
    private Date createDate;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getFileUrl()
    {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl)
    {
        this.fileUrl = fileUrl;
    }

    public Integer getTypeId()
    {
        return typeId;
    }

    public void setTypeId(Integer typeId)
    {
        this.typeId = typeId;
    }

    public String getTypeTitle()
    {
        return typeTitle;
    }

    public void setTypeTitle(String typeTitle)
    {
        this.typeTitle = typeTitle;
    }

    public Integer getLabelId()
    {
        return labelId;
    }

    public void setLabelId(Integer labelId)
    {
        this.labelId = labelId;
    }

    public String getLabelTitle()
    {
        return labelTitle;
    }

    public void setLabelTitle(String labelTitle)
    {
        this.labelTitle = labelTitle;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getPublish()
    {
        return publish;
    }

    public void setPublish(String publish)
    {
        this.publish = publish;
    }

    public Integer getCreateId()
    {
        return createId;
    }

    public void setCreateId(Integer createId)
    {
        this.createId = createId;
    }

    public String getCreateName()
    {
        return createName;
    }

    public void setCreateName(String createName)
    {
        this.createName = createName;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }
}
