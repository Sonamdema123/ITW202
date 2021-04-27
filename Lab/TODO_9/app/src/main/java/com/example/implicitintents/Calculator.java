package com.example.implicitintents;

public class Calculator {
    public enum Operator {ADD, SUB, MUL, DIV}
    public double add(double operandOne, double operandTwo){
        return operandOne + operandTwo;
    }
    public double sub (double operandOne, double operandTwo){
        return operandOne - operandTwo;
    }
    public double mul (double operandOne, double operandTwo){
        return operandOne * operandTwo;
    }
    public double div (double operandOne, double operandTwo){
        return operandOne  / operandTwo;
    }

}
