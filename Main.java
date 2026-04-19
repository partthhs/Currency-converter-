import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Currencyconverter extends JFrame implements ActionListener {

    JTextField amountField, resultField;
    JComboBox<String> fromCurrency, toCurrency;
    JButton convertBtn, clearBtn;

    public Currencyconverter() {

        setTitle("Currency Converter");
        setSize(420, 360);
        setLayout(null);
        setLocationRelativeTo(null);

        Color bg = new Color(30, 30, 30);
        Color fg = new Color(220, 220, 220);
        Color accent = new Color(0, 150, 255);

        getContentPane().setBackground(bg);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel title = new JLabel("Currency Converter", JLabel.CENTER);
        title.setBounds(50, 10, 300, 30);
        title.setForeground(accent);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(title);

        JLabel l1 = new JLabel("Enter Amount:");
        l1.setBounds(40, 60, 150, 25);
        l1.setForeground(fg);
        l1.setFont(labelFont);
        add(l1);

        amountField = new JTextField();
        amountField.setBounds(200, 60, 150, 30);
        amountField.setFont(fieldFont);
        amountField.setBackground(new Color(50,50,50));
        amountField.setForeground(Color.WHITE);
        add(amountField);

        String currencies[] = {"INR","USD","EUR","GBP","JPY"};

        JLabel l2 = new JLabel("From:");
        l2.setBounds(40, 110, 100, 25);
        l2.setForeground(fg);
        l2.setFont(labelFont);
        add(l2);

        fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(200, 110, 150, 30);
        fromCurrency.setBackground(new Color(50,50,50));
        fromCurrency.setForeground(Color.WHITE);
        add(fromCurrency);

        JLabel l3 = new JLabel("To:");
        l3.setBounds(40, 160, 100, 25);
        l3.setForeground(fg);
        l3.setFont(labelFont);
        add(l3);

        toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(200, 160, 150, 30);
        toCurrency.setBackground(new Color(50,50,50));
        toCurrency.setForeground(Color.WHITE);
        add(toCurrency);

        convertBtn = new JButton("Convert");
        convertBtn.setBounds(60, 220, 120, 35);
        convertBtn.setBackground(accent);
        convertBtn.setForeground(Color.WHITE);
        convertBtn.setFocusPainted(false);
        convertBtn.setFont(labelFont);
        add(convertBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(220, 220, 120, 35);
        clearBtn.setBackground(new Color(80,80,80));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFocusPainted(false);
        clearBtn.setFont(labelFont);
        add(clearBtn);

        resultField = new JTextField();
        resultField.setBounds(100, 280, 200, 35);
        resultField.setEditable(false);
        resultField.setFont(new Font("Segoe UI", Font.BOLD, 16));
        resultField.setHorizontalAlignment(JTextField.CENTER);
        resultField.setBackground(new Color(50,50,50));
        resultField.setForeground(accent);
        add(resultField);

        convertBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == convertBtn){
            try {
                double amount = Double.parseDouble(amountField.getText());
                String from = (String) fromCurrency.getSelectedItem();
                String to = (String) toCurrency.getSelectedItem();

                double result = convert(amount, from, to);
                resultField.setText(String.format("%.2f", result));
            } catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Enter valid number");
            }
        }

        if(e.getSource() == clearBtn){
            amountField.setText("");
            resultField.setText("");
        }
    }

    double convert(double amount, String from, String to){

        double usd = 93.19;
        double eur = 109.81;
        double gbp = 126.14;
        double jpy = 0.59;

        if(from.equals("USD")) amount *= usd;
        if(from.equals("EUR")) amount *= eur;
        if(from.equals("GBP")) amount *= gbp;
        if(from.equals("JPY")) amount *= jpy;

        if(to.equals("USD")) return amount / usd;
        if(to.equals("EUR")) return amount / eur;
        if(to.equals("GBP")) return amount / gbp;
        if(to.equals("JPY")) return amount / jpy;

        return amount;
    }

    public static void main(String[] args){
        new Currencyconverter();
    }
}
