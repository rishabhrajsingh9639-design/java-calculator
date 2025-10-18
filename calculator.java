import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorSwing extends JFrame implements ActionListener {
    private JTextField display;
    private String operator;
    private double num1, num2, result;

    public CalculatorSwing() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {
            display.setText(display.getText() + cmd);
        } else if (cmd.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
            operator = null;
        } else if (cmd.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num1 / num2; break;
            }
            display.setText("" + result);
        } else {
            operator = cmd;
            num1 = Double.parseDouble(display.getText());
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new CalculatorSwing();
    }
}
