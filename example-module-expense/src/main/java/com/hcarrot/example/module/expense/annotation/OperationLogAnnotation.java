package com.hcarrot.example.module.expense.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by hurenjian on 2018/8/8.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLogAnnotation {
    /**
     * 操作人ID
     */
    String userId() default "0";

    /**
     * 操作人姓名
     */
    String userName() default "System";

}

@Aspect
@Component
class OpLogAop {
    /**
     * 拦截所有DataSource类注解
     */
    /*
    @Pointcut("@within(com.netease.haitao.example.common.annotation.OperationLogAnnotation)")
    public void pointCut() {
    }

    @Pointcut("@annotation(com.netease.haitao.example.common.annotation.OperationLogAnnotation)")
    public void pointCut1() {
    }
    */
    /**
     *
     * @return
     * @throws Throwable
     */
    @Around("within(com.netease.haitao.example.module.guaranty..*) && @annotation(operateLogAnnotation)")
    public Object doLog(ProceedingJoinPoint joinPoint, OperationLogAnnotation operateLogAnnotation) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println("test");
        System.out.println(operateLogAnnotation.userId());
        System.out.println(operateLogAnnotation.userName());
        Object object = joinPoint.proceed();
        return object;
    }
}


