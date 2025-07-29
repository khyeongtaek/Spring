package org.shark.ioc.chap02_java;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Calculator {
    private String brand;
    private int price;
    private Adder adder;
    private Subtractor subtractor;
    private Multiplier multiplier;
    private Divider divider;


}
