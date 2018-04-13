package com.nature.resover;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Locale;
import java.util.Map;

/**
 * Created by luo on 2015/8/31.
 */
public class MultiViewResover implements ViewResolver
{
    private Map<String, ViewResolver> resolvers;

    @Override
    public View resolveViewName(String viewName, Locale locale)
            throws Exception
    {
        int n = viewName.lastIndexOf("_");
        if (viewName.startsWith("redirect:")) {
            String redirectUrl = viewName.substring("redirect:".length());
            RedirectView view = new RedirectView(redirectUrl,false,true);
            return view;
        }
        // viewName(modelAndView中的名字)看其有没有下划线
        else if (n == (-1))
        {

            View view = new RedirectView(viewName);
            return view; // 直接返回这个视图
        }
        else
        {
            // 有的话截取下划线后面的字符串 这里一般是jsp,ftl,vm与配置文件中的<entry key="ftl">的key匹配
            String suffix = viewName.substring(n + 1);
            // 根据下划线后面的字符串去获取托管的视图解析类对象
            ViewResolver resolver = resolvers.get(suffix);
            // 取下划线前面的部分 那时真正的资源名.比如我们要使用hello.jsp 那viewName就应该是hello_jsp
            viewName = viewName.substring(0, n);
            if (resolver != null)
                return resolver.resolveViewName(viewName, locale);
            return null;
        }
    }

    public Map<String, ViewResolver> getResolvers() {
        return resolvers;
    }

    public void setResolvers(Map<String, ViewResolver> resolvers) {
        this.resolvers = resolvers;
    }
}
