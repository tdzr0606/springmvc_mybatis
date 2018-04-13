package com.nature.util;

/**
 * 字典工具类
 * springboot
 * Directory
 * Author: 竺志伟
 * Date:   2017-04-01 16:45
 */
public class DirectoryTools
{
    // 系统分隔符
    public static final String SYS_FILEPATH_SEPARATOR = System.getProperty("file.separator");
    // 系统换行符
    public static final String SYS_LINE_SEPARATOR = System.getProperty("line.separator");
    //SESSION中存储登录用户信息
    public static final String SESSION_LOGIN_USER="loginUser";

    public static final String SESSION_LOGIN_P_FUNCTION = "parentFunction";
    public static final String SESSION_LOGIN_S_FUNCTION = "subFunction";


    //图片验证码 来源 后台登录指定
    public static final String VCODE_WEBADMIN_LOGIN = "webAdminLogin";
}
