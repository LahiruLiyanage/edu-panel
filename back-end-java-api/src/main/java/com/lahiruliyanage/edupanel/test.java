package com.lahiruliyanage.edupanel;

public class test {
    public static void main(String[] args) {
        for (Object property : System.getProperties().keySet()) {
            System.out.println(property);
        }
    }
}
