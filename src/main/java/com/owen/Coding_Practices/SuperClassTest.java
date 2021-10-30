package com.owen.Coding_Practices;

public class SuperClassTest {
    static class Animal {
        Animal() {
            System.out.println("animal is created");
        }
    }

    static class Dog extends Animal {
        Dog() {
            super();
            System.out.println("dog is created");
        }
    }

    public static void main(String args[]) {
        Dog d = new Dog();
    }
}