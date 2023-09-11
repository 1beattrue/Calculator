package edu.mirea.onebeattrue.calculator.data;

import edu.mirea.onebeattrue.calculator.domain.Repository;
import edu.mirea.onebeattrue.calculator.domain.entities.Operation;

public class RepositoryImpl implements Repository {

    private String previousNumber = "0";
    private String nextNumber = "0";
    private Operation currentOperation = null;

    @Override
    public void allClean() {
        previousNumber = "0";
        nextNumber = "0";
        currentOperation = null;
    }

    @Override
    public void addNumber(String number) {
        if (currentOperation == null) {
            previousNumber += number;
        } else {
            nextNumber += number;
        }
    }

    @Override
    public void addComma() {
        if (currentOperation == null) {
            previousNumber += COMMA;
        } else {
            nextNumber += COMMA;
        }
    }

    @Override
    public void setOperation(Operation operation) {
        currentOperation = operation;
    }

    @Override
    public String getResult() {
        previousNumber = nextNumber;
        switch (currentOperation) {
            case ADD -> {
                return String.valueOf(
                        Double.parseDouble(previousNumber) + Double.parseDouble(nextNumber)
                );
            }
            case SUBTRACT -> {
                return String.valueOf(
                        Double.parseDouble(previousNumber) - Double.parseDouble(nextNumber)
                );
            }
            case MULTIPLY -> {
                return String.valueOf(
                        Double.parseDouble(previousNumber) * Double.parseDouble(nextNumber)
                );
            }
            case DIVIDE -> {
                if (nextNumber.equals("0"))
                    return ERROR;
                return String.valueOf(
                        Double.parseDouble(previousNumber) / Double.parseDouble(nextNumber)
                );
            }
        }
        return null;
    }

    private static final String COMMA = ".";
    private static final String ERROR = "Ошибка";
}
