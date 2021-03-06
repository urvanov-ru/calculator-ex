package ru.urvanov.calculatorex.plugin.standard;

import ru.urvanov.calculatorex.plugin.Operation;
import ru.urvanov.calculatorex.plugin.CalculatorState;

public class Sum implements Operation {
    public String getButtonText() {                                                     
        return "+";
    }

    public void calculate(CalculatorState state) {
        state.setCalculated(true);
        state.setDisplayValue(state.getAccumulatedValue() + state.getDisplayValue());
        state.setAccumulatedValue(state.getDisplayValue());
    }

    @Override
    public void buttonPressed(CalculatorState state) {
        state.setAccumulatedValue(state.getDisplayValue());
        state.setCalculated(true); 
    }
}
