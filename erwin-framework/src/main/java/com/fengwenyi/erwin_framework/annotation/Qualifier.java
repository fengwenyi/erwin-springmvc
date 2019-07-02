package com.fengwenyi.erwin_framework.annotation;

import java.lang.annotation.*;

/**
 * 提供依赖注入
 * @author Erwin Feng
 * @since 2019-07-03 02:40
 */
@Documented
@Target(ElementType.FIELD) // 作用在字段上
@Retention(RetentionPolicy.RUNTIME)
public @interface Qualifier {

    String value();

}
