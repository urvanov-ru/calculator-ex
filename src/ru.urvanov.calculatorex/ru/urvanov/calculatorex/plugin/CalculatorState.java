package ru.urvanov.calculatorex.plugin;

public class CalculatorState {
    private double accumulatedValue;
    private double displayValue;
    private boolean calculated;
    
    public double getAccumulatedValue() {
        return this.accumulatedValue;
    }

    public void setAccumulatedValue(double accumulatedValue) {
        this.accumulatedValue = accumulatedValue;
    }

    public double getDisplayValue() {
        return this.displayValue;
    }

    public void setDisplayValue(double displayValue)  {
        this.displayValue = displayValue;
    }
    public void setCalculated(boolean calculated) {
        this.calculated = calculated;
    }

    public boolean isCalculated() {
        return this.calculated;
    }
}