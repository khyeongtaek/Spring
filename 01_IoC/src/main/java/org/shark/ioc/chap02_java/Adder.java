package org.shark.ioc.chap02_java;

public class Adder {

    public int add(int... args){
        if(args == null || args.length == 0){
            return 0;
        }
        int sum = 0;
        for(int i : args){
            sum += i;
        }
        return sum;
    }
}
