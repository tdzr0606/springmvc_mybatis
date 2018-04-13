package com.nature.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CommonResult
{

    public static final int SUCCESS = 1;

    public static final int FAILS = 0;

    public static final int SERVER_ERROR = -1;

    public static final int SERVER_RUNTIME_ERROR = -2;

    public static final int SERVER_FILEUPLOAD_ERROR = -3;

    private int code;

    private String message;

    private Object data;

    public CommonResult()
    {
        this.code = CommonResult.FAILS;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public boolean isSuccess()
    {
        return this.code == 1;
    }

    @JsonIgnore
    public boolean isNotSuccess()
    {
        return !isSuccess();
    }
}
