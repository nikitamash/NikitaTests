package org.example;

public class Main {
    public static void calculateNumbers(int a, int b){
        System.out.println(a + b);
    }

    public static void greetUser(String name){
        System.out.println("Hello " + name);
    }

    public static void divideNumbers(int a, int b, int c){
        System.out.println(a / b - c );
    }

    public static void main(String[] args) {
        calculateNumbers(10, 5);

        divideNumbers(10, 5,8);

        greetUser("Nikita");

    }
}