package com.example.aopdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;

@SpringBootApplication
public class AopDemoApplication {

    public static void main(String[] args) {

        ManSayHelloWorld manSayHelloWorld = new ManSayHelloWorld();
        CustomAOP customAOP = new CustomAOP(manSayHelloWorld);

        // 进行指定对象进行AOP包装
        SayHelloWorld sayHelloWorld = (SayHelloWorld) Proxy.newProxyInstance(
                ManSayHelloWorld.class.getClassLoader(),
                new Class[] {SayHelloWorld.class},
                customAOP);

        // 有aop包装的方法
        sayHelloWorld.say();

        System.out.println("\n=============\n");

        // 不用aop包装的方法
        sayHelloWorld.askName();

    }

}
