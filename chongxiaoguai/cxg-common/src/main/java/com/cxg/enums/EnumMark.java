package com.cxg.enums;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * 
 * @author Eli_Wu
 * @date 2013-8-9
 */
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.FIELD)
@Documented  
public @interface EnumMark {

	String value();
}
