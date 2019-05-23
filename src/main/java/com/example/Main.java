package com.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int cont = 1;
        for (String i:args){
            System.out.println("Argument " + cont + ": "+ i);
            cont++;
        }
    }
}
