package com.nature.listener;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * 启动时的webContext监听,把一些数据变量放入
 *
 */
public class WebContextListener extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        ServletContext sc=event.getServletContext();
        sc.setAttribute("ctx",sc.getContextPath());//存放虚路径
    }
}
