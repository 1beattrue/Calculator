package edu.mirea.onebeattrue.calculator.data;

import javax.inject.Inject;

import edu.mirea.onebeattrue.calculator.domain.Repository;
import edu.mirea.onebeattrue.calculator.domain.entities.Operation;

public class RepositoryImpl implements Repository {

    @Inject
    RepositoryImpl() {
    }

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
        currentNumber = String.valueOf(-Double.parseDouble(currentNumber));
        formatResult();
    }

    @Override
    public void findPercent() {
        currentNumber = String.valueOf(Double.parseDouble(currentNumber) / 100);
    }

    @Override
    public String getCurrentNumber() {
        return currentNumber;
    }

    @Override
    public void addNumber(String number) {
        if (currentNumber.equals(NULL)) currentNumber = number;
        else currentNumber += number;
    }

    @Override
    public void addComma() {
        if (currentNumber.contains(COMMA))
            return;
        currentNumber += COMMA;
    }

    @Override
    public void setOperation(Operation operation) {
        currentOperation = operation;
        previousNumber = currentNumber;
        currentNumber = NULL;
    }

    @Override
    public void makeResult() {
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
        formatResult();
    }

    private void formatResult() {
        if (currentNumber.equals(ERROR)) return;

        if (Double.parseDouble(currentNumber) % 1 == 0) {
            currentNumber = String.valueOf((int) Double.parseDouble(currentNumber));
        } else {
            currentNumber = String.valueOf(Double.parseDouble(currentNumber));
        }
    }

    private static final String NULL = "0";
    private static final String COMMA = ".";
    private static final String ERROR = "Ошибка";
}
