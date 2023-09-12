package edu.mirea.onebeattrue.calculator.domain;

import edu.mirea.onebeattrue.calculator.domain.entities.Operation;

public interface Repository {
    void allClean();

    void makeOpposite();

    void findPercent();

    String getCurrentNumber();

    void addNumber(String number);

    void addComma();
    void deleteSymbol();

    void setOperation(Operation operation);

    void makeResult();
}
