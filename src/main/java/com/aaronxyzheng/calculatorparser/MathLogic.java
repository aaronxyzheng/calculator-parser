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
        return new ArrayList<>();
    }

    public Queue<String> infixToPostfix(ArrayList<String> infixArray) {
        return new Queue<String>();
    }

    public int postfixEvaluater(Queue<String> postfixQueue) {
        return 1;
    }
    
}
