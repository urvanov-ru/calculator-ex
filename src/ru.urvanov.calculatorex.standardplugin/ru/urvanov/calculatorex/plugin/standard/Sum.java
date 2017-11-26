package ru.urvanov.calculatorex.plugin.standard;

import ru.urvanov.calculatorex.plugin.Operation;

public class Sum implements Operation {
    public String getButtonText() {
        return "+";
    }

    public double calculate(double x, double y) {
        return x + y;
    }
}
