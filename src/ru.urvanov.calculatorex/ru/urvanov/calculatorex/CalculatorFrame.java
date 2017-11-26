package ru.urvanov.calculatorex;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.*;

import java.util.ServiceLoader;
import java.util.Iterator;
import java.util.stream.StreamSupport;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import ru.urvanov.calculatorex.plugin.Operation;
import ru.urvanov.calculatorex.plugin.NoneOperation;

public class CalculatorFrame extends JFrame {

    private JPanel calculatorPanel;

    private JPanel operationsPanel;

    private Operation operation = new NoneOperation();
    private double x;

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
            oneButton.addActionListener(event -> {
                numberLabel.setText(numberLabel.getText() + oneButton.getText());
            });
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
                double y = readValue();
                this.x = operation.calculate(x, y);
                this.operation = ((OperationButton) event.getSource()).getOperation();
                 
            });
            CalculatorFrame.this.add(btn);
        });
    }

    private double readValue() {
        try {
            return NumberFormat.getInstance(Locale.ROOT).parse(numberLabel.getText()).doubleValue();
        } catch (ParseException ex) {
            ex.printStackTrace();
            return 0.0;
        }
    }

}
