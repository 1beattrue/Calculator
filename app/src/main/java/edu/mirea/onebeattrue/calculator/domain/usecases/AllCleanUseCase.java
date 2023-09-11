package edu.mirea.onebeattrue.calculator.domain.usecases;

import edu.mirea.onebeattrue.calculator.domain.Repository;

public class AllCleanUseCase {
    private final Repository repository;

    public AllCleanUseCase(Repository repository) {
        this.repository = repository;
    }

    void allClean() {
        repository.allClean();
    }
}
