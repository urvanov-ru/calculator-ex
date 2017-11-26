package ru.urvanov.calculatorex.plugin;

public class NoneOperation implements Operation {
    @Override
    public String getButtonText() {
        return "none";
    }
    @Override
    public double calculate(double x, double y) {
        return y;
    }
}
