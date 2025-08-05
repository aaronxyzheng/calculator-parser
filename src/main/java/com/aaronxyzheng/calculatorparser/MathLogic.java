package com.aaronxyzheng.calculatorparser;

import com.aaronxyzheng.calculatorparser.datastructures.*;
import java.util.ArrayList;

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
                tokenedArray.add(numberHolder);
                numberHolder = "";
                tokenedArray.add(String.valueOf(userExpression.charAt(i)));
            }
        }

        if(!numberHolder.equals("")) tokenedArray.add(numberHolder);

        return tokenedArray;
    }

    public Queue<String> infixToPostfix(ArrayList<String> infixArray) {
        return new Queue<String>();
    }

    public int postfixEvaluater(Queue<String> postfixQueue) {
        return 1;
    }
    
}
