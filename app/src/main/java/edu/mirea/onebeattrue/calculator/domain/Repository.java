package edu.mirea.onebeattrue.calculator.domain;

import edu.mirea.onebeattrue.calculator.domain.entities.Operation;

public interface Repository {
    void allClean();

    void addNumber(String number);

    void addComma();

    void setOperation(Operation operation);

    String getResult();
}
