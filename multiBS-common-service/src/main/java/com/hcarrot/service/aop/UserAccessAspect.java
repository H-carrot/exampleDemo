package com.hcarrot.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAccessAspect {

    @Pointcut(value = "@annotation(com.hcarrot.service.aop.UserAccess)")
    public void access() {

    }

    @Before("access()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("second before");
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("access()")
    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("second after");
    }

    @Around("@annotation(userAccess)")
    public Object around(ProceedingJoinPoint pjp, UserAccess userAccess) {
        //获取注解里的值  完成指定操作  比如写入数据库等
        System.out.println("operateUser Id:" + userAccess.userId());
        System.out.println("operateUser Name:" + userAccess.userName());
        System.out.println("operateUser Desc:" + userAccess.desc());
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
