package com.nature.util;

import org.apache.commons.codec.binary.Base64;

import java.io.*;

/**
 * 图片字符串转换工具类
 * springmvc_mybatis
 * ImageStringChangeUtils
 *
 * @Author: 竺志伟
 * @Date: 2018-06-01 10:01
 */
public class ImageStringChangeUtils
{
    public static String changeImage2String(String imgFilePath)
    {
        byte[] data = null;
        try
        {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return Base64.encodeBase64String(data);// 返回Base64编码过的字节数组字符串
    }


    public static boolean changeString2Image(String imgStr, String imgFilePath)
    {
        if(imgStr == null) // 图像数据为空
            return false;
        try
        {
            byte[] bytes = Base64.decodeBase64(imgStr);
            for(int i = 0; i < bytes.length; ++i)
            {
                if(bytes[i] < 0)
                {
                    bytes[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }


    public static void main(String args[])
    {
        String imgPath = "/Users/apple/Desktop/b05.png";
        String imgStr = ImageStringChangeUtils.changeImage2String(imgPath);
        System.out.println(imgStr);
        String outImgPath = "/Users/apple/Desktop/11.jpeg";
        System.out.println(ImageStringChangeUtils.changeString2Image(imgStr,outImgPath));
    }
}
