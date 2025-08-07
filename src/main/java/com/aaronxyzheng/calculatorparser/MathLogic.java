package com.aaronxyzheng.calculatorparser;

import com.aaronxyzheng.calculatorparser.datastructures.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MathLogic {
    public double solveExpression(String userExpression) {
        ArrayList<String> tokenList = tokenizer(userExpression);
        Queue<String> postfixQueue = infixToPostfix(tokenList);
        Double answer = postfixEvaluater(postfixQueue);
        return answer;
    }

    public ArrayList<String> tokenizer(String userExpression) {
        ArrayList<String> tokenedArray = new ArrayList<>(); // Return Array

        userExpression = userExpression.replace(" ", "");

        String numberHolder = "";
        
        for(int i = 0; i < userExpression.length(); i++) {
            if(Character.isDigit(userExpression.charAt(i))) {
                numberHolder += String.valueOf(userExpression.charAt(i));
            } else {
                if(!numberHolder.equals("")) {
                    tokenedArray.add(numberHolder);
                }
                numberHolder = "";
                tokenedArray.add(String.valueOf(userExpression.charAt(i)));
            }
        }

        if(!numberHolder.equals("")) tokenedArray.add(numberHolder);

        return tokenedArray;
    }

    public Queue<String> infixToPostfix(ArrayList<String> infixArray) {
        
        // Creating Data Structures 
        Queue<String> outputQueue = new Queue<>();  // Queue Output
        Stack<String> operatorStack = new Stack<>(); // Stack for Shunting Yard Algorithm (Aka: infix -> postfix algorithm)
        
        HashMap<String, Integer> operatorPrecedence = new HashMap<>(); // HashMap of operator Precedence
        operatorPrecedence.put("^", 3);
        operatorPrecedence.put("x", 2);
        operatorPrecedence.put("*", 2);
        operatorPrecedence.put("/", 2);
        operatorPrecedence.put("-", 1);
        operatorPrecedence.put("+", 1);

        for(String item : infixArray) {
            if(item.matches("\\d+")) { // If item is a number (Only works for positives but input should be just positive numbers anyway)
                outputQueue.enqueue(item);
            } else if (operatorPrecedence.containsKey(item)) { // If item is an operator
                if(!operatorStack.isEmpty()) {

                    while(!operatorStack.isEmpty() && // While operator stack isn't empty
                          operatorPrecedence.containsKey(operatorStack.peek()) && // And top is a valid operator (not parenthesis)
                          operatorPrecedence.get(operatorStack.peek()) > operatorPrecedence.get(item)) {  // And precedence is greater than item 
                        
                        outputQueue.enqueue(operatorStack.pop()); // Put that operator onto output queue
                    }
                }

                operatorStack.push(item); // Add item to operator stack.
            } else if (item.equals("(")) {
                operatorStack.push(item);
            } else if (item.equals(")")) {
                while(!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    outputQueue.enqueue(operatorStack.pop());
                }

                operatorStack.pop();
            }
        }

        while(operatorStack.size() > 0) {
            outputQueue.enqueue(operatorStack.pop());
        }

        return outputQueue;
    }

    public double postfixEvaluater(Queue<String> postfixQueue) {

        Stack<String> operandStack = new Stack<>();

        while(!postfixQueue.isEmpty()) {
            if(postfixQueue.peek().matches("\\d+")) {
                operandStack.push(postfixQueue.dequeue());
            } else {
                if(postfixQueue.peek().equals("+")) { // If the item is a +
                    postfixQueue.dequeue();
                    double addend1 = Double.parseDouble(operandStack.pop());
                    double addend2 = Double.parseDouble(operandStack.pop());
                    double sum = addend1 + addend2;
                    operandStack.push(Double.toString(sum));
                } else if(postfixQueue.peek().equals("-")) { // If item is -
                    postfixQueue.dequeue();
                    double subtrahend = Double.parseDouble(operandStack.pop());
                    double minuend = Double.parseDouble(operandStack.pop());
                    double difference = minuend - subtrahend;
                    operandStack.push(Double.toString(difference));
                } else if(postfixQueue.peek().equals("*") || postfixQueue.peek().equals("x")) { // If item is x or *
                    postfixQueue.dequeue();
                    double factor1 = Double.parseDouble(operandStack.pop());
                    double factor2 = Double.parseDouble(operandStack.pop());
                    double product = factor1 * factor2;
                    operandStack.push(Double.toString(product));
                } else if(postfixQueue.peek().equals("/")) { // If item is x or *
                    postfixQueue.dequeue();
                    double divisor = Double.parseDouble(operandStack.pop());
                    double dividend = Double.parseDouble(operandStack.pop());
                    double quotient = dividend/divisor;
                    operandStack.push(Double.toString(quotient));
                } else if(postfixQueue.peek().equals("^")) { // If item is x or *
                    postfixQueue.dequeue();
                    double exponent = Double.parseDouble(operandStack.pop());
                    double base = Double.parseDouble(operandStack.pop());
                    double result = Math.pow(base, exponent);
                    operandStack.push(Double.toString(result));
                }
            }
        }

        return Double.parseDouble(operandStack.pop());
    }
    
}