package edu.mirea.onebeattrue.calculator.domain.usecases;

import edu.mirea.onebeattrue.calculator.domain.Repository;
import edu.mirea.onebeattrue.calculator.domain.entities.Operation;

public class SetOperationUseCase {
    private final Repository repository;

    public SetOperationUseCase(Repository repository) {
        this.repository = repository;
    }

    void setOperation(Operation operation) {
        repository.setOperation(operation);
    }
}
