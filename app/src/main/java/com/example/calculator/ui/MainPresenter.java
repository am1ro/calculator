package com.example.calculator.ui;

import com.example.calculator.domain.Calculator;
import com.example.calculator.domain.Operations;

public class MainPresenter {
    private final Vieww view;
    private final Calculator calculator;

    private Double numberOne = 0.0;
    private Double numberTwo = null;

    private Operations operation;

    public MainPresenter(Vieww view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }
    public void onKeyPressed(int value){
        if (numberTwo == null) {
            numberOne = addDigit(numberOne, value);
            view.showResult(String.valueOf(numberOne));
        }
        else {
            numberTwo = addDigit(numberTwo, value);
            view.showResult(String.valueOf(numberTwo));
        }
    }
    public void onKeyPlusPress(){
        operation(Operations.ADD);

    }
    public void onKeyMinusPress(){
        operation(Operations.SUB);

    }
    public void onKeyMulPress(){
        operation(Operations.MUL);

    }
    public void onKeyDivPress(){
        operation(Operations.DIV);

    }
    private void operation (Operations op) {
        if (numberTwo == null) {
            operation = op;
            numberTwo = 0.0;
        }
        else {
            double res = calculator.performOperations(numberOne, numberTwo, operation);
            view.showResult(String.valueOf(res));
        }
    }



    private double addDigit (double number, int digit){
        double result = number + digit;
        return result;
    }
}
