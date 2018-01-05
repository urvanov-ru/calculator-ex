package ru.urvanov.calculatorex;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import java.util.ServiceLoader;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import ru.urvanov.calculatorex.plugin.Operation;
import ru.urvanov.calculatorex.plugin.NoneOperation;
import ru.urvanov.calculatorex.plugin.CalculatorState;

public class CalculatorFrame extends JFrame {

    private JPanel calculatorPanel;

    private JPanel operationsPanel;

    private Operation operation = new NoneOperation();
    private CalculatorState calculatorState = new CalculatorState();

    private JLabel numberLabel;

    public CalculatorFrame () {
        setSize(400, 300);
        setTitle("Calculator with plugins");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        numberLabel = new JLabel("0");
        add(numberLabel);

        calculatorPanel = new JPanel();
        calculatorPanel.setLayout(new GridLayout(4, 3));
        add(calculatorPanel);
        for (int n = 0; n < 10; n++) {
            JButton oneButton = new JButton(String.valueOf(n));
            oneButton.addActionListener(new NumberButtonEvent(n));
            calculatorPanel.add(oneButton);
        }

        operationsPanel = new JPanel();
        operationsPanel.setLayout(new FlowLayout());

        add(operationsPanel);

        ServiceLoader<Operation> sl = ServiceLoader.load(Operation.class);
        System.out.println("before stream " + sl);
        StreamSupport.stream(sl.spliterator(), false).forEach(op -> {
            System.out.println("found " + op.getButtonText());
            OperationButton btn = new OperationButton(op);
            btn.addActionListener(event -> {
                operation.calculate(calculatorState);
                this.operation = ((OperationButton) event.getSource()).getOperation(); 
                numberLabel.setText(String.valueOf(calculatorState.getDisplayValue()));
            });
            CalculatorFrame.this.add(btn);
        });
    }
                                                                                                           
    class NumberButtonEvent implements ActionListener {
        private double value;
        public NumberButtonEvent(double value) {
            this.value = value;
        }
        @Override
        public void actionPerformed(ActionEvent event) {
            if (calculatorState.isCalculated()) {
                calculatorState.setCalculated(false);
                calculatorState.setDisplayValue(value);
            } else {
                calculatorState.setDisplayValue(calculatorState.getDisplayValue() * 10 + value);    
            }
            numberLabel.setText(String.valueOf(calculatorState.getDisplayValue()));
        }
    }

}
