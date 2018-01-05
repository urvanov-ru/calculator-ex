package ru.urvanov.calculatorex.plugin;

public interface Operation {
    String getButtonText();
    void calculate(CalculatorState state);
    void buttonPressed(CalculatorState state);
}
