package com.nature.converter;

import org.springframework.core.convert.converter.Converter;

public class StringToBooleanConvert implements Converter<String, Boolean> {
    @Override
    public Boolean convert(String params) {
        if (params == null || params.equals("")) {
            return false;
        } else if ("on".equals(params)) {
            return true;
        } else if ("true".equals(params)) {
            return true;
        } else if ("false".equals(params)) {
            return false;
        } else if ("1".equals(params)) {
            return true;
        } else if ("0".equals(params)) {
            return false;
        } else {
            return false;
        }
    }
}
