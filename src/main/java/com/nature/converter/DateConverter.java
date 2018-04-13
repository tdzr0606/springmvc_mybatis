package com.nature.converter;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * spring3 mvc 的日期传递[前台-后台]bug:
 * Created by luo on 2015/8/13.
 */
public class DateConverter implements WebBindingInitializer {

    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println("DateConverter implements WebBindingInitializer");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false));
    }

}