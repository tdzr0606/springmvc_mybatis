package com.nature.pojo.record;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Borrow
 * Author:竺志伟
 * Date:2018-03-25 22:01:46
 */

public class Borrow implements Serializable
{
    private Integer recordId;
    private String dealName;
    private String recordTitle;
    private String borrowName;
    private Boolean isBack;
    private Boolean isBackLater;
    private Integer dealId;
    @JsonFormat(pattern = "yyyy-MM-dd")  // json转换 format
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 数据提交  format
    private Date backDate;
    private Integer borrowDayNum;
    private Integer borrowId;
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd")  // json转换 format
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 数据提交  format
    private Date borrowDate;
    private String note;

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public Integer getRecordId()
    {
        return recordId;
    }

    public void setRecordId(Integer recordId)
    {
        this.recordId = recordId;
    }

    public String getDealName()
    {
        return dealName;
    }

    public void setDealName(String dealName)
    {
        this.dealName = dealName;
    }

    public String getRecordTitle()
    {
        return recordTitle;
    }

    public void setRecordTitle(String recordTitle)
    {
        this.recordTitle = recordTitle;
    }

    public String getBorrowName()
    {
        return borrowName;
    }

    public void setBorrowName(String borrowName)
    {
        this.borrowName = borrowName;
    }

    public Boolean getIsBack()
    {
        return isBack;
    }

    public void setIsBack(Boolean isBack)
    {
        this.isBack = isBack;
    }

    public Boolean getIsBackLater()
    {
        return isBackLater;
    }

    public void setIsBackLater(Boolean isBackLater)
    {
        this.isBackLater = isBackLater;
    }

    public Integer getDealId()
    {
        return dealId;
    }

    public void setDealId(Integer dealId)
    {
        this.dealId = dealId;
    }

    public Date getBackDate()
    {
        return backDate;
    }

    public void setBackDate(Date backDate)
    {
        this.backDate = backDate;
    }

    public Integer getBorrowDayNum()
    {
        return borrowDayNum;
    }

    public void setBorrowDayNum(Integer borrowDayNum)
    {
        this.borrowDayNum = borrowDayNum;
    }

    public Integer getBorrowId()
    {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId)
    {
        this.borrowId = borrowId;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Date getBorrowDate()
    {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate)
    {
        this.borrowDate = borrowDate;
    }

}
