package com.citiustech.loans;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)   
@Retention(RetentionPolicy.RUNTIME)
public @interface Duration {
	int max_duration() default 5;
}
