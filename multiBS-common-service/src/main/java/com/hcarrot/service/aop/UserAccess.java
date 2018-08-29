package com.hcarrot.service.aop;

import java.lang.annotation.*;

/**
 * Created by hurenjian on 18/8/29.
 * 添加指定注解的函数
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserAccess {
    /**
     * 操作人ID
     */
    String userId() default "0";

    /**
     * 操作人姓名
     */
    String userName() default "System";

    String desc() default "无信息";
}
