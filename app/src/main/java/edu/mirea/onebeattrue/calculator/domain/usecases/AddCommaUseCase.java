package edu.mirea.onebeattrue.calculator.domain.usecases;

import edu.mirea.onebeattrue.calculator.domain.Repository;

public class AddCommaUseCase {
    private final Repository repository;
    public AddCommaUseCase(Repository repository) {
        this.repository = repository;
    }

    void addComma() {
        repository.addComma();
    }
}
