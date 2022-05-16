package edu.vccs.email.twr2286.RPNCalcProject;

import java.util.Deque;

/**
 * The controller class for the Reverse Polish Notation Calculator
 * The Class conducts several calculations
 * Here the stack is created
 * 2021-11-10
 * @author Tim Root
 */
public class RPNCalcMath {

    private Deque<Double> stack = new MyStack<>();  //Stack to hold the data
    protected double topNum;                        //number starting on the top of the stack
    protected double nextNum;                       //second number on the stack
    protected double result;                        //result of an equation


    public RPNCalcMath() {
        this.stack = stack;
    }

    /**
     * pushes number onto the stack
     * @param num number to be pushed onto stack
     */
    public void enterNumber(double num) {
        stack.push(num);
    }

    /**
     * adds top two numbers on the stack together and puts the result on the stack.
     * @return result of addition
     */
    public double add() {
        //if the stack is empty top number is 0.0
        if (stack.isEmpty()) {
            topNum = 0.0;
        }
        //take the number off the top
        else {
            topNum = stack.pop();
        }
        //now is it Empty?
        if (stack.isEmpty()) {
            nextNum = 0.0;
        }
        //take the new number off the top
        else {
            nextNum = stack.pop();
        }
        //add the two values and push the result to the stack
        result = nextNum + topNum;
        stack.push(result);
        return result;

    }

    /**
     * subtracts the top number from the second number
     * on the stack and pushes the result to the stack.
     * @return result of subtraction
     */
    public double subtract() {
        //if the stack is empty top number is 0.0
        if (stack.isEmpty()) {
            topNum = 0.0;
        }
        //take the number off the top
        else {
            topNum = stack.pop();
        }
        //now is it Empty?
        if (stack.isEmpty()) {
            nextNum = 0.0;
        }
        //take the new number off the top
        else {
            nextNum = stack.pop();
        }
        //get the difference and push the result back on the stack
        result = nextNum - topNum;
        stack.push(result);
        return result;
    }

    /**
     * multiplies the top two numbers on the stack together and puts the result on the stack.
     * @return result of multiplication
     */
    public double multiply() {
        //if the stack is empty top number is 0.0
        if (stack.isEmpty()) {
            topNum = 0.0;
        }
        //take the number off the top
        else {
            topNum = stack.pop();
        }
        //now is it Empty?
        if (stack.isEmpty()) {
            nextNum = 0.0;
        }
        //take the new number off the top
        else {
            nextNum = stack.pop();
        }
        // get the product and push the result on the stack
        result = nextNum * topNum;
        stack.push(result);
        return result;
    }

    /**
     * divides the second number by the top number
     * on the stack and puts the result on the stack.
     * @return result of division
     */
    public double divide() {
        //if the stack is empty top number is 0.0
        if (stack.isEmpty()) {
            topNum = 0.0;
        }
        //take the number off the top
        else {
            topNum = stack.pop();
        }
        //now is it Empty?
        if (stack.isEmpty()) {
            nextNum = 0.0;
        }
        //take the new number off the top
        else {
            nextNum = stack.pop();
        }
        //find the quotient and put the result on the stack
        result = nextNum / topNum;
        stack.push(result);
        return result;
    }
}
