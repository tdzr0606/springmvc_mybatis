package com.nature.controller.basic;

import com.nature.pojo.system.Admin;
import com.nature.util.CommonResult;
import com.nature.util.DirectoryTools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * springboot
 * BaseController
 * Author: 竺志伟
 * Date:   2017-03-30 15:06
 */
public abstract class BaseController
{
    protected ModelAndView modelAndView = null;
    @Autowired
    protected HttpServletResponse httpServletResponse;
    @Autowired
    protected HttpServletRequest httpServletRequest;

    protected Logger logger = Logger.getLogger(this.getClass());


    /**
     * 获取当前登录信息
     *
     * @return
     */
    protected Admin getLoginInfo()
    {
        if(null != httpServletRequest.getSession().getAttribute(DirectoryTools.SESSION_LOGIN_USER))
        {
            return (Admin) httpServletRequest.getSession().getAttribute(DirectoryTools.SESSION_LOGIN_USER);
        }
        return null;
    }


    protected CommonResult resultDataWrapper(Object obj)
    {
        return resultSuccessWrapper("success", obj);
    }

    protected CommonResult resultWrapper(int code, String message, Object obj)
    {
        CommonResult result = new CommonResult();
        result.setMessage(message);
        result.setData(obj);
        result.setCode(code);
        return result;
    }

    protected CommonResult resultBoolWrapper(boolean bool, String success, String fails, Object obj)
    {
        if(bool)
        {
            return resultSuccessWrapper(success, obj);
        }
        return resultFailsWrapper(fails, obj);
    }

    protected CommonResult resultSuccessWrapper(String message, Object obj)
    {
        return resultWrapper(CommonResult.SUCCESS, message, obj);
    }

    protected CommonResult resultFailsWrapper(String message, Object obj)
    {
        return resultWrapper(CommonResult.FAILS, message, obj);
    }
}
