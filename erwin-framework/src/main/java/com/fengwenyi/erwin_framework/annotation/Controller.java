package com.fengwenyi.erwin_framework.annotation;

import java.lang.annotation.*;

/**
 * 控制层注解
 * @author Erwin Feng
 * @since 2019-07-03 02:36
 */
@Documented //JavaDoc
@Target(ElementType.TYPE) //作用在类上
@Retention(RetentionPolicy.RUNTIME) // Annotation的生命周期，一般情况下，我们自定义注解的话，显然需要在运行期获取注解的一些信息。
public @interface Controller {

    // controller name
    String value();

}
