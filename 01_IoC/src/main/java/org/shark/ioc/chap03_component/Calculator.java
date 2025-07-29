package org.shark.ioc.chap03_component;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Calculator {
    private String brand = "브랜드";
    private int price = 10000;
    private Adder adder;
    private Subtractor subtractor;
    private Multiplier multiplier;
    private Divider divider;


}
