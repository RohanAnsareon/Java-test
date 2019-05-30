package com.company;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Mammal {

    String sound();

    int color() default 0xffffff;
}
