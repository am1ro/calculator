package com.example.calculator.domain;

public class Calculatormpl implements Calculator {

    @Override
    public double performOperations(double numberOne, double numberTwo, Operations operation) {
            switch (operation) {
                case ADD:
                    return numberOne + numberTwo;

                case MUL:
                    return numberOne * numberTwo;

                case SUB:
                    return numberOne - numberTwo;

                case DIV:
                    return numberOne / numberTwo;
            }
            return 0;
        }
    }

