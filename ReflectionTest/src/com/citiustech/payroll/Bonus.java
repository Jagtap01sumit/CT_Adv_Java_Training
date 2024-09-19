package com.citiustech.payroll;
//annotation
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)   //what is target? class , interface or method...TYPE mean class or interface...METHOD means method
@Retention(RetentionPolicy.RUNTIME) //when this interface will apply..it says that at a runtime it will be apply
//if retention policy is SOURCE then it only availble at a compile time once it compile then it not available not in .class file also.
public @interface Bonus {
	int value() default 10000;
}
