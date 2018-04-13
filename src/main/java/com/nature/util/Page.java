package com.nature.util;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class Page<T>
{

    private int count;
    private int code;
    private String msg;
    private List<T> data;
    private int limit;
    private int totalPage;
    private int page;


    public Page()
    {
        this.code = 0;
        this.msg = "";
        this.page = 1;
        this.limit = 1;
        this.count = 1;
        this.totalPage = 0;
        this.data = null;
    }

    public Page(int nowPage,int count,int totalPage,int pageSize,List<T> dataList)
    {
        this.code = 0;
        this.msg = "";
        this.page = nowPage;
        this.limit = pageSize;
        this.count = count;
        this.totalPage = totalPage;
        this.data = dataList;
    }

    public Page(PageInfo<T> pageInfo)
    {
        this.code = 0;
        this.msg = "";
        this.data = pageInfo.getList();
        this.page = pageInfo.getPageNum();
        this.limit = pageInfo.getPageSize();
        this.count = (int) pageInfo.getTotal();
        this.totalPage = pageInfo.getPages();
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public List<T> getData()
    {
        return data;
    }

    public void setData(List<T> data)
    {
        this.data = data;
    }

    public int getLimit()
    {
        return limit;
    }

    public void setLimit(int limit)
    {
        this.limit = limit;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public int getTotalPage()
    {
        totalPage = count / limit;
        if(count % limit != 0)
            totalPage++;
        return totalPage;
    }

}