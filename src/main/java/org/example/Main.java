package org.example;
import com.github.javafaker.Faker;

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
    Faker faker = new Faker();
    System.out.println(faker.name().firstName());

    }
}