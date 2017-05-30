package com.cxg.interactiveweb.tools;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

	/** 要执行的操作类型比如：新增操作 **/
	public String operationType() default "";


	/** 要执行的具体操作比如：添加账款 **/
	public String operationName() default "";

}