package com.example.demo;

public class ABCFG {
    public static double average(int a, int b) {
        double avg = (a + b) / 2;
        System.out.println(avg);
        return (a + b) / 2;
    }

    public static void main(String[] args) {
        System.out.println(average(2,1));
    }
}
