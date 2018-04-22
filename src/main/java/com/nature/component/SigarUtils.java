package com.nature.component;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * 系统信息 监控Util
 * springmvc_mybatis
 * SigarUtils
 *
 * @Author: 竺志伟
 * @Date: 2018-04-21 10:18
 */
@Component
public class SigarUtils
{
    private static Sigar sigar = null;

    static
    {
        sigar = new Sigar();
    }


    public Map<Integer, String> cpu() throws Exception
    {
        Map<Integer, String> cpuMap = new HashMap<>();
        CpuPerc[] cpuPercs = sigar.getCpuPercList();
        for(int i = 0; i < cpuPercs.length; i++)
        {
            cpuMap.put(i,String.format("%.4f",cpuPercs[i].getUser()*100));
        }
        return cpuMap;
    }


    public Map<String,String> member() throws Exception
    {
        Map<String,String> memberMap = new HashMap<>();
        Mem mem = sigar.getMem();
        memberMap.put("total",String.format("%.4f", (double)(mem.getTotal())/1024f/1024f/1024f));
        memberMap.put("use",String.format("%.4f",(double)(mem.getUsed())/1024f/1024f/1024f));
        memberMap.put("free",String.format("%.4f",(double)(mem.getFree())/1024f/1024f/1024f));
        return memberMap;
    }

}
