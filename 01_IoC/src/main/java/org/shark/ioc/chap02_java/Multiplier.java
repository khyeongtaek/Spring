package org.shark.ioc.chap02_java;

public class Multiplier {
    public int multiply(int... args){
        int total= 1;
        if(args == null || args.length == 0){
            return 0;
        }
        for(int i : args){
            total *= i;
        }
        return total;
    }
}
