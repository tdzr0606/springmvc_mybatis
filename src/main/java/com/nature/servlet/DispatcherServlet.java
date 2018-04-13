package com.nature.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.support.GenericConversionService;

/**
 * User: yuandi.tyd
 * Email: yuandi.tyd@alibaba-inc.com
 * Date: 14-4-8
 * Time: 下午4:46
 *
 */
public class DispatcherServlet extends org.springframework.web.servlet.DispatcherServlet {

    @Override
    protected void initStrategies(ApplicationContext context) {
        super.initStrategies(context);
        GenericConversionService b=context.getBean(GenericConversionService.class);
        b.removeConvertible(String.class,Object[].class);
    }
}
