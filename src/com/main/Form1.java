package com.main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 {
    private JTextField txtName;
    private JPanel panel1;
    private JLabel lblName;
    private JLabel lblSalary;
    private JTextField txtSalary;
    private JButton enterButton;
    private JButton displayButton;
    private JButton clearButton;
    private JButton exitButton;
    private String[] mName = new String[100];
    private double[] mSalary = new double[100];
    private int mIndex = 0;

    public Form1() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtName.setText("");
                txtSalary.setText("");
                txtName.requestFocus();
            }
        });
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtName.getText() == "")
                {
                    JOptionPane.showMessageDialog(null, "Please enter your name.");
                    return;
                }
                if(!TryParse())
                {
                    JOptionPane.showMessageDialog(null, "Please enter a real number in salary.");
                    return;
                }
                String name = txtName.getText();
                double salary = Double.parseDouble(txtSalary.getText());

                mName[mIndex] = name;
                mSalary[mIndex] = salary;
                mIndex++;

                txtName.setText("");
                txtSalary.setText("");
                txtName.requestFocus();
            }
        });
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(JOptionPane.showInputDialog("Please enter index."));

                txtName.setText(mName[index]);
                String salary = Double.toString(mSalary[index]);
                txtSalary.setText(salary);
            }
        });
    }

    public boolean TryParse()
    {
        try
        {
            Double.parseDouble(txtSalary.getText());
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("parallel_arrays");
        frame.setContentPane(new Form1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
