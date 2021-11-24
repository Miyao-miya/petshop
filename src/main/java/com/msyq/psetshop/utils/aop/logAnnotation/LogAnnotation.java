package com.msyq.psetshop.utils.aop.logAnnotation;

import java.lang.annotation.*;

/**
* 生成操作日志的注解
 *
 * Type,表示可以放在类上  method表示可以放在方法上
 *
* */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
//    模块名称
    String module() default "";
//    操作名称
    String operator() default "";

}
