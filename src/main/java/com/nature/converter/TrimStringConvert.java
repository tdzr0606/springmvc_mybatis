package com.nature.converter;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class TrimStringConvert implements Converter<String, String>
{
    @Override
    public String convert(String params)
    {
        return StringUtils.trim(params);
    }
}
