package edu.mirea.onebeattrue.calculator.data;

import java.util.Locale;

import javax.inject.Inject;

import edu.mirea.onebeattrue.calculator.domain.Repository;
import edu.mirea.onebeattrue.calculator.domain.entities.Operation;

public class RepositoryImpl implements Repository {

    @Inject
    RepositoryImpl() {
    }

    private boolean isNextNumber = false;
    private String previousNumber = NULL;
    private String currentNumber = NULL;
    private Operation currentOperation = Operation.NULL;

    @Override
    public void allClean() {
        previousNumber = NULL;
        currentNumber = NULL;
        currentOperation = Operation.NULL;
    }

    @Override
    public void makeOpposite() {
        if (currentNumber.equals(ERROR)) return;
        currentNumber = String.valueOf(-Double.parseDouble(currentNumber));
        formatResult();
    }

    @Override
    public void findPercent() {
        if (currentNumber.equals(ERROR)) return;
        currentNumber = String.valueOf(Double.parseDouble(currentNumber) / 100);
        formatResult();
    }

    @Override
    public String getCurrentNumber() {
        return currentNumber;
    }

    @Override
    public void addNumber(String number) {
        if (currentNumber.equals(ERROR)) return;
        if (currentNumber.length() >= MAX_LENGTH || currentNumber.contains(EXPONENT)) return;

        if (isNextNumber)
            currentNumber = NULL;

        if (currentNumber.equals(NULL)) currentNumber = number;
        else currentNumber += number;

        isNextNumber = false;
    }

    @Override
    public void addComma() {
        if (currentNumber.equals(ERROR)) return;
        if (currentNumber.length() >= MAX_LENGTH || currentNumber.contains(EXPONENT)) return;

        if (isNextNumber)
            currentNumber = NULL;

        if (currentNumber.contains(COMMA))
            return;
        currentNumber += COMMA;

        isNextNumber = false;
    }

    @Override
    public void deleteSymbol() {
        if (currentNumber.equals(ERROR)) return;
        if (currentNumber.contains(EXPONENT)) return;

        int minLength = MIN_LENGTH;
        if (currentNumber.startsWith(MINUS)) {
            minLength++;
        }
        if (currentNumber.length() > minLength) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
        }
        else if (currentNumber.length() == minLength) {
            currentNumber = NULL;
        }
    }

    @Override
    public void setOperation(Operation operation) {
        currentOperation = operation;
        previousNumber = currentNumber;
        //currentNumber = NULL;
    }

    @Override
    public void makeResult() {
        if (currentNumber.equals(ERROR) || previousNumber.equals(ERROR)) {
            currentNumber = ERROR;
            return;
        }
        switch (currentOperation) {
            case ADD -> currentNumber = String.valueOf(
                    Double.parseDouble(previousNumber) + Double.parseDouble(currentNumber)
            );
            case SUBTRACT -> currentNumber = String.valueOf(
                    Double.parseDouble(previousNumber) - Double.parseDouble(currentNumber)
            );
            case MULTIPLY -> {
                currentNumber = String.valueOf(
                        Double.parseDouble(previousNumber) * Double.parseDouble(currentNumber)
                );
            }
            case DIVIDE -> {
                if (currentNumber.equals(NULL))
                    currentNumber = ERROR;
                else
                    currentNumber = String.valueOf(
                            Double.parseDouble(previousNumber) / Double.parseDouble(currentNumber)
                    );
            }
            case NULL -> {

            }
        }
        currentOperation = Operation.NULL;
        formatResult();
    }

    @Override
    public void setIsNextNumber(boolean isNextNumber) {
        this.isNextNumber = isNextNumber;
    }

    private void formatResult() {
        if (currentNumber.equals(ERROR)) return;

        double doubleCurrentNumber = Double.parseDouble(currentNumber);
        if (doubleCurrentNumber < Long.MAX_VALUE && doubleCurrentNumber % 1 == 0) {
            currentNumber = String.valueOf((long) doubleCurrentNumber);
        } else {
            currentNumber = String.valueOf(doubleCurrentNumber);
        }

        if (currentNumber.length() > MAX_LENGTH || currentNumber.contains(EXPONENT)) {
            currentNumber = String.format(Locale.US, "%.2E", doubleCurrentNumber);
        }
    }

    private static final String MINUS = "-";
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 10;
    private static final String EXPONENT = "E";
    private static final String NULL = "0";
    private static final String COMMA = ".";
    private static final String ERROR = "Ошибка";
}
