package edu.mirea.onebeattrue.calculator.di;

import edu.mirea.onebeattrue.calculator.presentation.MainActivity;
import dagger.Component;

@Component(modules = {DataModule.class})
public
interface ApplicationComponent {
    void inject(MainActivity activity);
}
