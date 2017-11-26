package ru.urvanov.calculatorex.plugin;

public interface Operation {
    String getButtonText();
    double calculate(double x, double y);
}
