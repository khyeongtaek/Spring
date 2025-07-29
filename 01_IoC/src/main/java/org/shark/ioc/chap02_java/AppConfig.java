package org.shark.ioc.chap02_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class AppConfig {

    @Bean
    public Adder add(){
        return new Adder();
    }

    @Bean
    public Subtractor sub(){
        return new Subtractor();
    }

    @Bean
    public Multiplier mul(){
        return new Multiplier();
    }
    @Bean
    public Divider div(){
        return new Divider();
    }
    @Bean
    public Calculator calc(){
        Calculator calculator = new Calculator();
        calculator.setBrand("소니");
        calculator.setPrice(1000000);
        calculator.setAdder(add());
        calculator.setSubtractor(sub());
        calculator.setMultiplier(mul());
        calculator.setDivider(div());
        return calculator;
    }


}
