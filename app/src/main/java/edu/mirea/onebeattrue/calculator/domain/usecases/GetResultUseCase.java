package edu.mirea.onebeattrue.calculator.domain.usecases;

import edu.mirea.onebeattrue.calculator.domain.Repository;

public class GetResultUseCase {
    private final Repository repository;
    public GetResultUseCase(Repository repository) {
        this.repository = repository;
    }

    String getResult() {
        return repository.getResult();
    }
}
