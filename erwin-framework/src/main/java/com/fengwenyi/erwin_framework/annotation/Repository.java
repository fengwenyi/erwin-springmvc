package com.fengwenyi.erwin_framework.annotation;

import java.lang.annotation.*;

/**
 * 仓库
 * @author Erwin Feng
 * @since 2019-07-03 02:43
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Repository {

    String value();

}
