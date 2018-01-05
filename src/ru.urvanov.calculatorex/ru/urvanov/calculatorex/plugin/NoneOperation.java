package ru.urvanov.calculatorex.plugin;

public class NoneOperation implements Operation {
    @Override
    public String getButtonText() {
        return "none";
    }
    @Override
    public void calculate(CalculatorState state) {
        state.setAccumulatedValue(state.getDisplayValue());
        state.setCalculated(true);
    }
    @Override
    public void buttonPressed(CalculatorState state) {
        state.setAccumulatedValue(state.getDisplayValue());
        state.setCalculated(true);
    }
}
