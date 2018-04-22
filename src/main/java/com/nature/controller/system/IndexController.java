package com.nature.controller.system;

import com.nature.controller.basic.BaseController;
import com.nature.service.system.AdminService;
import com.nature.util.CommonResult;
import com.nature.component.SigarUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return resultSuccessWrapper("成功",sigarUtils.cpu());
    }

    @RequestMapping(value = "/member")
    @ResponseBody
    public CommonResult member() throws Exception
    {
        return resultSuccessWrapper("成功",sigarUtils.member());
    }
}
