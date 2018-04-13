package com.nature.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * springboot
 * Tools
 * Author: 竺志伟
 * Date:   2017-04-01 16:36
 */
public class Tools
{

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmptyString(String str)
    {
        return (null == str || str.trim().length() == 0);
    }

    /**
     * 获取默认的时间字符串
     *
     * @return
     */
    public static String getDateString()
    {
        return getDateString(null, null);
    }

    /**
     * 获取默认的时间字符串
     *
     * @return
     */
    public static String getDateTimeString()
    {
        return getDateString(null, "yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 根据自定义格式获取时间字符串
     *
     * @param date
     * @param formateStr
     * @return
     */
    public static String getDateString(Date date, String formateStr)
    {
        String returnValue = null;
        try
        {
            if(null == date)
            {
                date = new Date();
            }
            if(isEmptyString(formateStr))
            {
                formateStr = "yyyy-MM-dd";
            }
            returnValue = new SimpleDateFormat(formateStr).format(date);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return returnValue;
        }
    }

}
