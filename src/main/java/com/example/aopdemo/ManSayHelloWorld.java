package com.example.aopdemo;

public class ManSayHelloWorld implements SayHelloWorld{
    @Override
    public void say() {
        System.out.println("hello");
    }

    @Override
    public void askName(){
        System.out.println("what's your name");
    }
}
