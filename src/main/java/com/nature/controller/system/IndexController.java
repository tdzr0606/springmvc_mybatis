package com.nature.controller.system;

import com.nature.controller.basic.BaseController;
import com.nature.service.system.AdminService;
import com.nature.util.CommonResult;
import com.nature.component.SigarUtils;
import com.nature.util.ImageStringChangeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.TransformerException;
import java.util.Random;

/**
 * springmvc_mybatis
 * IndexController
 *
 * @Author: 竺志伟
 * @Date: 2018-04-12 14:48
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    AdminService adminService;
    @Autowired
    SigarUtils sigarUtils;
    @Autowired
    HttpServletRequest request;

    Logger logger = LoggerFactory.getLogger(IndexController.class);


    @RequestMapping(value = "/")
    public String toIndex()
    {
        return "index_vm";
    }

    @RequestMapping(value = "/webAdmin")
    public String toWebAdminIndex()
    {
        return "/webAdmin/index_vm";
    }


    @RequestMapping(value = "/cpu")
    @ResponseBody
    public CommonResult cpu() throws Exception
    {
        return resultSuccessWrapper("成功", sigarUtils.cpu());
    }

    @RequestMapping(value = "/member")
    @ResponseBody
    public CommonResult member() throws Exception
    {
        return resultSuccessWrapper("成功", sigarUtils.member());
    }


    // 设置 session
    @RequestMapping(value = "/sessionSet")
    @ResponseBody
    public CommonResult session()
    {
        logger.info(String.format("%s:%s,sessio 设置", request.getRemoteAddr(), request.getRemotePort()));
        request.getSession().setAttribute("user", new Random().nextInt(1000));
        return resultSuccessWrapper("成功", null);
    }

    // 获取session
    @RequestMapping(value = "/sessionGet")
    @ResponseBody
    public CommonResult sessionGet()
    {
        logger.info(String.format("%s:%s,sessio 获取", request.getRemoteAddr(), request.getRemotePort()));
        return resultSuccessWrapper("session",
                request.getRemoteHost() + "-" + request.getSession().getAttribute("user"));
    }


    /**
     * 测试mybatis 查询
     * Mybatis common result.
     *
     * @return the common result
     * @author:竺志伟
     * @date :2018-05-29 09:45:47
     */
    @RequestMapping(value = "/mybatis")
    @ResponseBody
    public CommonResult mybatis()
    {
        return resultSuccessWrapper("用户查询成功", adminService.listPage(1, 10, null));
    }


    /**
     * 进入 签名页面
     * To js sign string.
     *
     * @return the string
     * @author:竺志伟
     * @date :2018-06-01 09:27:27
     */
    @RequestMapping(value = "/toJsSign")
    public String toJsSign()
    {
        return "/jsSign_jsp";
    }


    /**
     * 图片保存
     * Js sign save common result.
     *
     * @param imgData the img data
     * @return the common result
     * @author:竺志伟
     * @date :2018-06-01 10:04:56
     */
    @RequestMapping(value = "/jsSignSave")
    @ResponseBody
    public CommonResult jsSignSave(
            @RequestParam(value = "imgData", required = true, defaultValue = "") String imgData)
    {
        imgData = imgData.replace("data:image/png;base64,","");
        ImageStringChangeUtils.changeString2Image(imgData, ContextLoader.getCurrentWebApplicationContext()
                .getServletContext().getRealPath("/")+"images/111.png");
        return resultSuccessWrapper("图片保存成功",null);
    }
}
