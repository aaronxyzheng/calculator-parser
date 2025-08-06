package com.aaronxyzheng.calculatorparser;

import com.aaronxyzheng.calculatorparser.datastructures.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MathLogic {
    public int solveExpression(String userExpression) {
        ArrayList<String> tokenList = tokenizer(userExpression);
        Queue<String> postfixQueue = infixToPostfix(tokenList);
        int answer = postfixEvaluater(postfixQueue);
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

    public int postfixEvaluater(Queue<String> postfixQueue) {
        return 1;
    }
    
}
