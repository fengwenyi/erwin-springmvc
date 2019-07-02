package com.fengwenyi.erwin_framework.annotation;

import java.lang.annotation.*;

/**
 * 请求映射
 * @author Erwin Feng
 * @since 2019-07-03 02:42
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD}) // 类  方法
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    String value();

}
