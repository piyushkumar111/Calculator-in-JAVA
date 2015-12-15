/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classweek13;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author piyushkachariya
 */
public class Calculator extends JFrame implements ActionListener{
    
    JTextField display = new JTextField(8);
    private double val1,val2,result;
    private boolean start;
    private String lastCommand;
   
    public Calculator() 
    {
        result = 0;
        start = false;
        lastCommand = "=";
        
        setTitle("Calculator");
            setSize(500,300);
             setLayout(new BorderLayout());
       
             int i;
             
             JPanel btnPanel = new JPanel();
             String digits = "7894561230";
             JButton btn;
      
             display.setEditable(false);
             add(display,"North");
             
             btnPanel.setLayout(new GridLayout(6,3));
             add(btnPanel,"Center");

             for (i=0; i<digits.length(); i++) 
             {
                   btn = new JButton(digits.substring(i,i+1));
                   btn.addActionListener((ActionListener) this);
                   btnPanel.add(btn);
             }
             
             btn = new JButton("+");
             btn.setActionCommand("add");
             btn.addActionListener((ActionListener) this);
             btnPanel.add(btn);
             
             btn = new JButton("-");
             btn.setActionCommand("min");
             btn.addActionListener((ActionListener) this);
             btnPanel.add(btn);
             
             btn = new JButton(".");
             btn.addActionListener((ActionListener) this);
             btnPanel.add(btn);
             
             btn = new JButton("/");
             btn.setActionCommand("div");
             btn.addActionListener((ActionListener) this);
             btnPanel.add(btn);
             
             btn = new JButton("*");
             btn.setActionCommand("mal");
             btn.addActionListener((ActionListener) this);
             btnPanel.add(btn);
             
             btn = new JButton("=");
             btn.setActionCommand("equal");
             btn.addActionListener((ActionListener) this);
             btnPanel.add(btn);
             
             btn = new JButton("BS");
             btn.setActionCommand("delete");
             btn.addActionListener((ActionListener) this);
             btnPanel.add(btn);
             
             btn = new JButton("Clear");
             btn.setActionCommand("Clear");
             btn.addActionListener((ActionListener) this);
             btnPanel.add(btn);
             
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) 
    {
        String newTxt; 
        String cmdStr = event.getActionCommand();

        switch (cmdStr) {
            case "delete":
                /* remove one character */
                newTxt = display.getText();
                if (newTxt.length() > 0) {
                    newTxt = newTxt.substring(0,newTxt.length()-1);
                }
                display.setText(newTxt);
                break;
                
            case "equal":
                /* remove one character */
                if(start)
                {
                    val2 = Double.parseDouble(display.getText());
                    
                    if(lastCommand.equalsIgnoreCase("-"))
                    {
                        result = val1 - val2;
                    }
                    else if(lastCommand.equalsIgnoreCase("+"))
                    {
                        result = val1 + val2;
                    }
                    else if(lastCommand.equalsIgnoreCase("/"))
                    {
                        result = val1 / val2;
                    }
                    else if(lastCommand.equalsIgnoreCase("*"))
                    {
                        result = val1 * val2;
                    }
                    lastCommand = "=";
                    start = false;
                    newTxt = result + "";
                    display.setText(newTxt);
                }
                break;
                
            case "min":
                /* remove one character */
            {
                if(!(lastCommand.equalsIgnoreCase("-")))
                {
                    val1 = Double.parseDouble(display.getText());
                    lastCommand = "-";
                    start = true;
                }
                newTxt = "";
                display.setText(newTxt);
            }
                break;
                
            case "add":
                /* remove one character */
            {
                if(!(lastCommand.equalsIgnoreCase("+")))
                {
                    val1 = Double.parseDouble(display.getText());
                    lastCommand = "+";
                    start = true;
                }
                newTxt = "";
                display.setText(newTxt);
            }
                break;
                
            case "div":
                /* remove one character */
            {
                if(!(lastCommand.equalsIgnoreCase("/")))
                {
                    val1 = Double.parseDouble(display.getText());
                    lastCommand = "/";
                    start = true;
                }
                newTxt = "";
                display.setText(newTxt);
            }
                break;
                
            case "mal":
                /* remove one character */
            {
                if(!(lastCommand.equalsIgnoreCase("*")))
                {
                    val1 = Double.parseDouble(display.getText());
                    lastCommand = "*";
                    start = true;
                }
                newTxt = "";
                display.setText(newTxt);
            }
                break;
                
            case "Clear":
                /* remove one character */
                newTxt = "";
                display.setText(newTxt);
                break;
            default:
                /* add the character to the display line  */
                newTxt = display.getText() + cmdStr;
                display.setText(newTxt);
                break;
        }
       }
    
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        
    }
}
