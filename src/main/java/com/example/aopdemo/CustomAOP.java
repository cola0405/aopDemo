package com.example.aopdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomAOP implements InvocationHandler {
    private Object obj;
    CustomAOP(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 对指定方法进行自定义aop操作
        if(method.getName() == "say"){
            System.out.println("对say方法的自定义前置操作");
            Object ret = method.invoke(obj,args);
            System.out.println("对say方法的自定义后置操作");
            return null;
        }
        Object ret = method.invoke(obj,args);
        return null;
    }
}
