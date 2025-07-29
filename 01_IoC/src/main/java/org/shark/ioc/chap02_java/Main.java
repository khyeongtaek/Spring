package org.shark.ioc.chap02_java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Adder add1 = context.getBean("add", Adder.class);
        Adder add2 = context.getBean("add", Adder.class);
        System.out.println(add1 == add2);

        Calculator calculator = context.getBean("calc", Calculator.class);
        System.out.println(calculator.getBrand());
        System.out.println(calculator.getPrice());
        System.out.println(calculator.getAdder().add(1, 2, 3, 4, 5));
        System.out.println(calculator.getSubtractor().subtract(5, 3));
        System.out.println(calculator.getMultiplier().multiply(1, 2, 3, 4, 5));
        System.out.println(calculator.getDivider().divide(10, 3));



        context.close();
    }
}
