package edu.mirea.onebeattrue.calculator.presentation;

import android.app.Application;

import edu.mirea.onebeattrue.calculator.di.ApplicationComponent;
import edu.mirea.onebeattrue.calculator.di.DaggerApplicationComponent;

public class CalculatorApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
