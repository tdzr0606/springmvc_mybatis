package com.nature.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConvert implements Converter<String, Date>
{
    @Override
    public Date convert(String params)
    {
        if (params == null || params.equals(""))
        {
            return null;
        }
        else
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try
            {
                return sdf.parse(params);
            }
            catch (ParseException e)
            {
                // TODO 自动生成 catch 块
                e.printStackTrace();
                return null;

            }
        }
    }
}
