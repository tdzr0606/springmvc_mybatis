package com.nature.listener;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * 启动时的webContext监听,把一些数据变量放入
 */
public class WebContextListener extends ContextLoaderListener
{
    private Logger logger = Logger.getLogger(WebContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        super.contextInitialized(event);
        ServletContext sc = event.getServletContext();
        sc.setAttribute("ctx", sc.getContextPath());//存放虚路径

        // 添加 sigar 路径到 java运行路径
        try
        {
            String path = System.getProperty("java.library.path");
            String sigarLibPath = sc.getRealPath("/") + "sigar/";
            //为防止java.library.path重复加，此处判断了一下
            if(!path.contains(sigarLibPath))
            {
                if(isOSWin())
                {
                    path += ";" + sigarLibPath;
                }
                else
                {
                    path += ":" + sigarLibPath;
                }
                System.setProperty("java.library.path", path);
            }
            logger.info("sigar路径配置");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            logger.error("sigar路径配置错误",e);
        }

    }


    private static boolean isOSWin()
    {
        //OS 版本判断
        String OS = System.getProperty("os.name").toLowerCase();
        if(OS.indexOf("win") >= 0)
        {
            return true;
        }
        else
            return false;
    }
}
