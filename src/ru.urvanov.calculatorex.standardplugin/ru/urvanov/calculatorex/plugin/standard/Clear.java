package ru.urvanov.calculatorex.plugin.standard;

import ru.urvanov.calculatorex.plugin.Operation;
import ru.urvanov.calculatorex.plugin.CalculatorState;

public class Clear implements Operation {
    public String getButtonText() {                                                     
        return "C";
    }

    public void calculate(CalculatorState state) {
        state.setAccumulatedValue(state.getDisplayValue());
        state.setCalculated(true);
    }

    @Override
    public void buttonPressed(CalculatorState state) {
        state.setAccumulatedValue(0.0);
        state.setDisplayValue(0.0);
        state.setCalculated(true); 
    }
}
