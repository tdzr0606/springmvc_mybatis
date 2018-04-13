package com.nature.pojo.record;

import java.io.Serializable;

/**
 * zzw_project
 * Label
 *
 * @Author: 竺志伟
 * @Date: 2018-03-05 17:17
 */
public class Label implements Serializable
{
    private Integer id;
    private String title;
    private String note;
    private Boolean isPublic;

    public Boolean getIsPublic()
    {
        return isPublic;
    }

    public void setIsPublic(Boolean aPublic)
    {
        isPublic = aPublic;
    }

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

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }
}
