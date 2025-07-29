package org.shark.ioc.chap01_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new GenericXmlApplicationContext("chap01_xml/appContext.xml");
        Adder add1 = context.getBean("add", Adder.class);
        Adder add2 = context.getBean("add", Adder.class);
        System.out.println(add1 == add2);


        Calculator calculator = context.getBean("calc1", Calculator.class);
        System.out.println(calculator.getBrand());
        System.out.println(calculator.getPrice());
        System.out.println(calculator.getAdder().add(1, 2, 3, 4, 5));
        System.out.println(calculator.getSubtractor().subtract(5, 3));
        System.out.println(calculator.getMultiplier().multiply(1, 2, 3, 4, 5));
        System.out.println(calculator.getDivider().divide(10, 3));

        context.close();
    }
}
