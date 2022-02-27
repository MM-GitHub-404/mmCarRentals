package com.mm.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * @author 茂茂
 * @create 2022-02-20 18:48
 */
@Aspect
public class MyAdvice {

    @After(value = "execution(* com.mm.service.*.selectAll(..))")
    public void myBefore(JoinPoint jp) {
        //获取方法的完整定义
        System.out.println("方法的签名（定义）=" + jp.getSignature());
        System.out.println("方法的名称=" + jp.getSignature().getName());
        //获取方法的实参
        Object args[] = jp.getArgs();
        for (Object arg : args) {
            System.out.println("参数=" + arg);
        }
        //就是你切面要执行的功能代码
        System.out.println("2=====前置通知， 切面功能：在目标方法之前输出执行时间：" + new Date());
    }
}
