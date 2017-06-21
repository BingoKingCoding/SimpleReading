package com.king.simplereading.rx;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/21 16:21.
 */

public class RxBusBaseMessage
{
    private int code;
    private Object object;


    private RxBusBaseMessage(){}

    public RxBusBaseMessage(int code, Object o) {
        this.code = code;
        this.object = o;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public Object getObject()
    {
        return object;
    }

    public void setObject(Object object)
    {
        this.object = object;
    }
}
