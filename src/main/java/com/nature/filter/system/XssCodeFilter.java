package com.nature.filter.system;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 防止攻击filter
 * km_leader
 * XssCodeFilter
 *
 * @author:竺志伟
 * @date :2018-01-09 15:27:26
 * @Author: 竺志伟
 * @Date: 2018 -01-09 15:25
 */
public class XssCodeFilter implements Filter
{
    FilterConfig filterConfig = null;
    Logger logger = Logger.getLogger(XssCodeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException
    {
        logger.info(String.format("过滤请求地址：%s", ((HttpServletRequest) servletRequest).getRequestURI()));
        filterChain.doFilter(new XssCodeWrapper((HttpServletRequest) servletRequest), servletResponse);
    }

    @Override
    public void destroy()
    {
        this.filterConfig = null;
    }
}
