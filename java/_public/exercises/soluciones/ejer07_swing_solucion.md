# [Solución] Ejercicio Cálculadora Simple

~~~java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculadora implements ActionListener {
    private JFrame frame;
    private JTextField textField;
    private ArrayList<JButton> numberButtons;
    private ArrayList<JButton> functionButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton equalButton, clearButton;
    private JPanel panel;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculadora() {
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalButton = new JButton("=");
        clearButton = new JButton("C");

        functionButtons = new ArrayList<>();
        functionButtons.add(addButton);
        functionButtons.add(subButton);
        functionButtons.add(mulButton);
        functionButtons.add(divButton);

        for (JButton btn : functionButtons) {
            btn.addActionListener(this);
            btn.setFocusable(false);
        }

        numberButtons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(this);
            btn.setFocusable(false);
            numberButtons.add(btn);
        }

        equalButton.addActionListener(this);
        clearButton.addActionListener(this);
        equalButton.setFocusable(false);
        clearButton.setFocusable(false);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        int[] numOrder = {7, 8, 9, 4, 5, 6, 1, 2, 3, 0};
        for (int i : numOrder) {
            panel.add(numberButtons.get(i));
        }

        panel.add(clearButton);
        panel.add(equalButton);

        for (JButton btn : functionButtons) {
            panel.add(btn);
        }

        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculadora();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons.get(i)) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        // ... (Repite el mismo patrón para subButton, mulButton, divButton)

        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                // ... (Repite el mismo patrón para '-', '*', '/')
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clearButton) {
            textField.setText("");
        }
    }
}

~~~
