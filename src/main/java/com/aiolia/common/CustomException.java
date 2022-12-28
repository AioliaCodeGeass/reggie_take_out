package com.aiolia.common;

/**
 * 自定义业务异常
 * @author aiolia
 * @version 1.0
 * @create 2022/12/12
 */
public class CustomException extends RuntimeException
{
    public CustomException(String message)
    {
        super(message);
    }
}
