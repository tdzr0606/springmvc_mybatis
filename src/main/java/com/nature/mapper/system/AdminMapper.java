package com.nature.mapper.system;

import com.nature.util.MyMapper;
import com.nature.pojo.system.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * springboot
 * AdminMapper
 * Author: 竺志伟
 * Date:   2017-04-02 12:38
 */
public interface AdminMapper extends MyMapper<Admin>
{
    /**
     * 查询所有数据
     *
     * @return
     */
    public List<Admin> list(@Param(value = "key") String key);


    /**
     * 添加新用户
     *
     * @param user
     */
    public int add(Admin user);

    /**
     * 更新用户
     *
     * @param user
     */
    public int modify(Admin user);


    /**
     * 删除用户
     *
     * @param id
     */
    public int deleteById(@Param(value = "id") Integer id);


    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public Admin findById(@Param(value = "id") Integer id);


    /**
     * 登录验证
     * @param map
     * @return
     */
    public Admin login(Map<String, String> map);

    /**
     * 登录名 唯一性 验证
     * @param loginName
     * @return
     */
    public int loginNameCheck(String loginName);

    /**
     *
     * @param admin
     * @return
     */
    public int modifyPassword(Admin admin);

    public void deleteByIds(@Param(value = "ids") String[] ids);

}
