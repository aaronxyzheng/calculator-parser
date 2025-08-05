package com.aaronxyzheng.calculatorparser;

import java.util.Scanner;

public class Main {

    // Method Variables
    public static Scanner scanner = new Scanner(System.in);
    public static MathLogic mathLogic = new MathLogic();
    public static void main(String[] args) {
        intro();
        while(true) {
            run();
        }
    }

    public static void intro() {
        System.out.println("           Welcome to Calculator Parser!");
        System.out.println("Enter mathematical expressions using: + - * / ^ ( )");
        System.out.println();
    }

    public static void run() {

        System.out.print("Expression: ");
        String userExpression = scanner.nextLine();
        System.out.println("Answer: " + mathLogic.solveExpression(userExpression));
        System.out.println();
    }
}