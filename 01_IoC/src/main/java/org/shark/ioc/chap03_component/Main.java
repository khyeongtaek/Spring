package org.shark.ioc.chap03_component;

import org.shark.ioc.chap02_java.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext("org.shark.ioc");

        Calculator calculator = context.getBean("calculator", Calculator.class);
        System.out.println(calculator.getBrand());
        System.out.println(calculator.getPrice());
        System.out.println(calculator.getAdder().add(1, 2, 3, 4, 5));
        System.out.println(calculator.getSubtractor().subtract(5, 3));
        System.out.println(calculator.getMultiplier().multiply(1, 2, 3, 4, 5));
        System.out.println(calculator.getDivider().divide(10, 3));



        context.close();
    }
}
