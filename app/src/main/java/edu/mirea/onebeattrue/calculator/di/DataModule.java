package edu.mirea.onebeattrue.calculator.di;

import dagger.Binds;
import dagger.Module;
import edu.mirea.onebeattrue.calculator.data.RepositoryImpl;
import edu.mirea.onebeattrue.calculator.domain.Repository;

@Module
public interface DataModule {
    @Binds
    Repository bindRepository(RepositoryImpl impl);
}