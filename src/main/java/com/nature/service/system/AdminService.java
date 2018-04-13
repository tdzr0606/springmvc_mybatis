package com.nature.service.system;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.nature.mapper.system.AdminMapper;
import com.nature.pojo.system.Admin;
import com.nature.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * springmvc_mybatis
 * AdminService
 *
 * @Author: 竺志伟
 * @Date: 2018-04-12 14:48
 */
@Service
public class AdminService
{
    @Autowired
    AdminMapper adminMapper;

    
    public Page<Admin> listPage(Integer nowPage, Integer pageSize, String key)
    {
        return new Page<>(PageHelper.startPage(nowPage, pageSize).doSelectPageInfo(new ISelect()
        {
           
            public void doSelect()
            {
                adminMapper.list(key);
            }
        }));
    }

   
    public Admin findById(Integer id)
    {
        return adminMapper.findById(id);
    }

   
    public boolean add(Admin admin)
    {
        return adminMapper.add(admin) == 1;
    }

   
    public boolean modify(Admin admin)
    {
        return adminMapper.modify(admin) == 1;
    }

   
    public boolean deleteById(Integer id)
    {
        return adminMapper.deleteById(id) == 1;
    }


   
    public Admin login(String loginName, String loginPass)
    {
        Map<String, String> map = new HashMap<>();
        map.put("loginName", loginName);
        map.put("password", loginPass);
        return adminMapper.login(map);
    }

   
    public boolean loginNameCheck(String loginName)
    {
        return adminMapper.loginNameCheck(loginName) < 1;
    }

   
    public boolean modifyPass(Integer id, String loginPassN)
    {
        Admin admin = new Admin();
        admin.setId(id);
        admin.setPassword(loginPassN);
        return adminMapper.modifyPassword(admin) == 1;
    }

   
    public void deleteByIds(String[] ids)
    {
        adminMapper.deleteByIds(ids);
    }

}
