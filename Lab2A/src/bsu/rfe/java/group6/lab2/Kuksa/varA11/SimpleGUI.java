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

    eHandler handler = new eHandler();

    public SimpleGUI(){
        super("Lab 2A");
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

        container.add(buttonMC);
        container.add(buttonMPlus);
        container.add(button);

        buttonMC.addActionListener(handler);
        buttonMPlus.addActionListener(handler);
        button.addActionListener(handler);
    }

    public class eHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button){
                double result1, result2;
                String message = "";
                message += "x = " + inputX.getText() + "  ";
                message += "y =  " + inputY.getText() + "  ";
                message += "z = " + inputZ.getText() + "\n";
                Formula.numerator1 = Math.pow(Math.log(Double.parseDouble(inputZ.getText())) + Math.sin(Math.PI * Math.pow(Double.parseDouble(inputZ.getText()),2)),1/4);
                Formula.denominator1 = Math.pow(Math.pow(Double.parseDouble(inputY.getText()),2) + Math.exp(Math.cos(Double.parseDouble(inputX.getText()))) + Math.sin(Double.parseDouble(inputY.getText())),Math.sin(Double.parseDouble(inputX.getText())));
                Formula.numerator2 = 1 + Math.sqrt(Double.parseDouble(inputZ.getText()) * Double.parseDouble(inputX.getText()));
                Formula.denominator2 = Math.pow(1 + Math.pow(Double.parseDouble(inputX.getText()),3),Double.parseDouble(inputY.getText()));
                result1 =  Formula.numerator1 /  Formula.denominator1;
                result2 =  Formula.numerator2 /  Formula.denominator2;
                if (radio1.isSelected()){
                    Formula.result = result1;
                    message += "f1(x,y,z) = " + result1 + "\n";
                } else {
                    message += "f2(x,y,z) = " + result2 + "\n";

                }
                message += "M+: " + Formula.sum + "\n";
                JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);;
            }
            if (e.getSource() == buttonMC){
                Formula.sum = 0;
            }
            if (e.getSource() == buttonMPlus){
                Formula.sum += Formula.result;;
            }
        }
    }
}