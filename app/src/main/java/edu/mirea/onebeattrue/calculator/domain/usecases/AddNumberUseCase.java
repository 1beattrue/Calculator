package edu.mirea.onebeattrue.calculator.domain.usecases;

import edu.mirea.onebeattrue.calculator.domain.Repository;

public class AddNumberUseCase {
    private final Repository repository;
    public AddNumberUseCase(Repository repository) {
        this.repository = repository;
    }

    void addNumber(String number) {
        repository.addNumber(number);
    }
}
