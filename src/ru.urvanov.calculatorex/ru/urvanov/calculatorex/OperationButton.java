package ru.urvanov.calculatorex;

import javax.swing.*;
import ru.urvanov.calculatorex.plugin.Operation;

public class OperationButton extends JButton {

    private Operation operation;

    public OperationButton(Operation operation) {
        super(operation.getButtonText());
    }

    public Operation getOperation() {
        return this.operation;
    }
}
