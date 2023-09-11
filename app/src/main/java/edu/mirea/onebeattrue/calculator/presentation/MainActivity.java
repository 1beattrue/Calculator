package edu.mirea.onebeattrue.calculator.presentation;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import javax.inject.Inject;

import edu.mirea.onebeattrue.calculator.R;
import edu.mirea.onebeattrue.calculator.databinding.ActivityMainBinding;
import edu.mirea.onebeattrue.calculator.di.ApplicationComponent;
import edu.mirea.onebeattrue.calculator.domain.Repository;
import edu.mirea.onebeattrue.calculator.domain.entities.Operation;

public class MainActivity extends AppCompatActivity {

    @Inject
    Repository repository;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ApplicationComponent applicationComponent = ((CalculatorApplication) getApplication()).getApplicationComponent();
        applicationComponent.inject(this);
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAc.setOnClickListener(view -> {
            repository.allClean();
            resetColors();
            updateUi();
        });

        binding.btnMakeOpposite.setOnClickListener(view -> {
            repository.makeOpposite();
            updateUi();
        });

        binding.btnPercent.setOnClickListener(view -> {
            repository.findPercent();
            updateUi();
        });

        setupNumberButtons();
        setupOperationButtons();
    }

    private void setupOperationButtons() {
        binding.btnDivide.setOnClickListener(view -> {
            resetColors();
            changeColor(binding.btnDivide);
            repository.setOperation(Operation.DIVIDE);
            updateUi();
        });

        binding.btnMultiply.setOnClickListener(view -> {
            resetColors();
            changeColor(binding.btnMultiply);
            repository.setOperation(Operation.MULTIPLY);
            updateUi();
        });

        binding.btnSubtract.setOnClickListener(view -> {
            resetColors();
            changeColor(binding.btnSubtract);
            repository.setOperation(Operation.SUBTRACT);
            updateUi();
        });

        binding.btnAdd.setOnClickListener(view -> {
            resetColors();
            changeColor(binding.btnAdd);
            repository.setOperation(Operation.ADD);
            updateUi();
        });

        binding.btnEquals.setOnClickListener(view -> {
            resetColors();
            repository.makeResult();
            updateUi();
        });
    }

    private void setupNumberButtons() {
        binding.btn0.setOnClickListener(view -> {
            resetColors();
            repository.addNumber("0");
            updateUi();
        });

        binding.btn1.setOnClickListener(view -> {
            resetColors();
            repository.addNumber("1");
            updateUi();
        });

        binding.btn2.setOnClickListener(view -> {
            resetColors();
            repository.addNumber("2");
            updateUi();
        });

        binding.btn3.setOnClickListener(view -> {
            resetColors();
            repository.addNumber("3");
            updateUi();
        });

        binding.btn4.setOnClickListener(view -> {
            resetColors();
            repository.addNumber("4");
            updateUi();
        });

        binding.btn5.setOnClickListener(view -> {
            resetColors();
            repository.addNumber("5");
            updateUi();
        });

        binding.btn6.setOnClickListener(view -> {
            resetColors();
            repository.addNumber("6");
            updateUi();
        });

        binding.btn7.setOnClickListener(view -> {
            resetColors();
            repository.addNumber("7");
            updateUi();
        });

        binding.btn8.setOnClickListener(view -> {
            resetColors();
            repository.addNumber("8");
            updateUi();
        });

        binding.btn9.setOnClickListener(view -> {
            resetColors();
            repository.addNumber("9");
            updateUi();
        });

        binding.btnComma.setOnClickListener(view -> {
            resetColors();
            repository.addComma();
            updateUi();
        });
    }

    private void resetColors() {
        int backgroundColor = ContextCompat.getColor(this, R.color.orange);
        int textColor = ContextCompat.getColor(this, R.color.white);
        ColorStateList colorStateList = ColorStateList.valueOf(backgroundColor);

        binding.btnDivide.setBackgroundTintList(colorStateList);
        binding.btnDivide.setTextColor(textColor);

        binding.btnMultiply.setBackgroundTintList(colorStateList);
        binding.btnMultiply.setTextColor(textColor);

        binding.btnSubtract.setBackgroundTintList(colorStateList);
        binding.btnSubtract.setTextColor(textColor);

        binding.btnAdd.setBackgroundTintList(colorStateList);
        binding.btnAdd.setTextColor(textColor);
    }

    private void changeColor(Button button) {
        int backgroundColor = ContextCompat.getColor(this, R.color.white);
        int textColor = ContextCompat.getColor(this, R.color.orange);
        ColorStateList colorStateList = ColorStateList.valueOf(backgroundColor);

        button.setBackgroundTintList(colorStateList);
        button.setTextColor(textColor);
    }

    private void updateUi() {
        binding.tvResult.setText(repository.getCurrentNumber());
    }
}