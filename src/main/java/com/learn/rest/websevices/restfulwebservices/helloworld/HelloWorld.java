package com.learn.rest.websevices.restfulwebservices.helloworld;

public class HelloWorld {

    private String str;

    public HelloWorld(){}

    public HelloWorld(String hello) {
        this.str = hello;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "str='" + str + '\'' +
                '}';
    }
}
