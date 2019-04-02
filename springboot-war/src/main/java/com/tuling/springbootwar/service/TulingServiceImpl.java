package com.tuling.springbootwar.service;

/**
 * @author jizy
 * @create 2019/4/2
 * @since 1.0.0
 */
public class TulingServiceImpl {
    public TulingServiceImpl(){
        System.out.println("我是通过import  selector  导入进来的！！！！");
    }

    public void getName(){
        System.out.println("获取到的名称是："+Thread.currentThread().getName());
    }
}
