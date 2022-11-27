package bsu.rfe.java.group6.lab2.Kuksa.varA11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Calculate");
    private JButton buttonMC = new JButton("MC");
    private JButton buttonMPlus = new JButton("M+");
    private JTextField inputX = new JTextField("",1);
    private JTextField inputY = new JTextField("",1);
    private JTextField inputZ = new JTextField("",1);
    private JLabel labelX = new JLabel(" x");
    private JLabel labelY = new JLabel(" y");
    private JLabel labelZ = new JLabel(" z");
    private JRadioButton radio1 = new JRadioButton("Formula №1");
    private JRadioButton radio2 = new JRadioButton("Formula №2");
    public SimpleGUI(){
        super("Simple Example");
        this.setBounds(100, 100, 250, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6,2,2,2));

        container.add(labelX);
        container.add(inputX);

        container.add(labelY);
        container.add(inputY);

        container.add(labelZ);
        container.add(inputZ);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);

        button.addActionListener(new ButtonMCEventListener());
        container.add(buttonMC);
        button.addActionListener(new ButtonMPlusEventListener());
        container.add(buttonMPlus);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    Formula M = new Formula();

    class ButtonEventListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
            String message = "";
            message += "x = " + inputX.getText() + "  ";
            message += "y =  " + inputY.getText() + "  ";
            message += "z = " + inputZ.getText() + "\n";
            if (radio1.isSelected()){
                double numerator, denominator;
                numerator = Math.pow(Math.log(Double.parseDouble(inputZ.getText())) + Math.sin(Math.PI * Math.pow(Double.parseDouble(inputZ.getText()),2)),1/4);
                denominator = Math.pow(Math.pow(Double.parseDouble(inputY.getText()),2) + Math.exp(Math.cos(Double.parseDouble(inputX.getText()))) + Math.sin(Double.parseDouble(inputY.getText())),Math.sin(Double.parseDouble(inputX.getText())));
                M.result = numerator / denominator;
                message += "f1(x,y,z) = " + M.result + "\n";
            } else {
                double numerator, denominator;
                numerator = 1 + Math.sqrt(Double.parseDouble(inputZ.getText()) * Double.parseDouble(inputX.getText()));
                denominator = Math.pow(1 + Math.pow(Double.parseDouble(inputX.getText()),3),Double.parseDouble(inputY.getText()));
                M.result = numerator / denominator;
                message += "f2(x,y,z) = " + M.result + "\n";
            }
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        };
    }

    class ButtonMCEventListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
            M.sum = 0;
        }
    }

    class ButtonMPlusEventListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
            M.sum += M.result;
        }
    }
}
