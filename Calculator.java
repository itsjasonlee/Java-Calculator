/* Jason Lee
Jsnlee At Ucdavis.edu
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
r
public class Calculator implements ActionListener
{
   static JButton[] digitButton = new JButton[10];
   static JButton[] temp = new JButton[18];
   static JButton addButton, subButton, multiplyButton, divideButton, equalButton, clearButton, clearEverything, negativeButton;
   static JTextField textField;
   static double operationOne, operationTwo, result;
   static char operator;
   static boolean newNumber;
   static void addDigit(int i) {
      if (newNumber) {
         textField.setText(""+i);
         newNumber = false;
      }
      else {
         textField.setText(textField.getText() + i);
      }
   }

   // To control actions
   public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 10; i++) {
            if(event.getSource() == digitButton[i]) {
            addDigit(i);
            return;
            }
        }  

        // To Add Button
        if(event.getSource() == addButton) {
        operationOne = Double.parseDouble(textField.getText());
        newNumber = true;
        operator = '+';
        return;
        }

        // To Subtract Button
        if(event.getSource() == subButton) {
        operationOne = Double.parseDouble(textField.getText());
        newNumber = true;
        operator = '-';
        return;
        }
        // To Multiply Button
        if(event.getSource() == multiplyButton) {
        operationOne = Double.parseDouble(textField.getText());
        newNumber = true;
        operator = '*';
        return;
        }

        // To Divide Button
        if(event.getSource() == divideButton) {
        operationOne = Double.parseDouble(textField.getText());
        newNumber = true;
        operator = '/';
        return;
        }

        // To Clear Button
        if(event.getSource() == clearButton) {
            operationOne = 0;
            textField.setText(" "+result);
            newNumber = true;
            return;
        }

        // To Clear Everything
        if(event.getSource() == clearEverything) {
            operationTwo = 0;
            operationOne = 0;
            result = 0;
            textField.setText(" "+result);
            newNumber = true;
            return;

        }

        // To Negative Button
        if(event.getSource() ==  negativeButton) {
            if(operationTwo != 0) {
                operationTwo = operationTwo * -1;
            }
            if(operationOne != 0) {
                operationOne = operationOne * -1;
            }
            if(result != 0) {
                result = result * -1;
            }
            textField.setText(" "+ result);
            newNumber = true;
            return;
        }

        // To Equal Button
        if (event.getSource() == equalButton) {
        operationTwo = Double.parseDouble(textField.getText());
        switch (operator) {
            case '/': result = operationOne / operationTwo; break;
            case '*': result = operationOne * operationTwo; break;
            case '-': result = operationOne - operationTwo; break;
            case '+': result = operationOne + operationTwo; break;
        }
        textField.setText(" "+result);
        newNumber = true;
        return;
        }   
      }

      public static void main(String[] args) {
          //initialize the calculator
         JFrame frm = new JFrame(" Jason Lee ");
         ActionListener AL = new Calculator();
         Container contentPane = frm.getContentPane();
         contentPane.setLayout(new FlowLayout());
         frm.pack();
         //set the sizing
         frm.setSize(310,240);
         contentPane.add(new JLabel("Calculator",JLabel.CENTER));
         contentPane.add(textField = new JTextField("",25));
         textField.setHorizontalAlignment(JTextField.RIGHT);
         JPanel C = new JPanel(new GridLayout(4,4,2,2));
         String digits[] = {"C", "CE", "   +/-   ", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", ".", "    =    "}; 
         //                  0    1        2         3    4    5    6    7    8    9    10  11    12   13   14   15   16       17           
         for (int i=0; i<18; i++) {
            C.add(temp[i] = new JButton(digits[i]));
            temp[i].addActionListener(AL);
         }
         //create digit buttons
         digitButton[1]= temp[12];  // 1
         digitButton[2]= temp[13];  // 2
         digitButton[3]= temp[14];  // 3
         digitButton[4]= temp[8];   // 4
         digitButton[5]= temp[9];   // 5
         digitButton[6]= temp[10];  // 6
         digitButton[7]= temp[4];   // 7
         digitButton[8]= temp[5];   // 8
         digitButton[9]= temp[6];   // 9

         //create buttons
         divideButton = temp[3];    // /
         addButton = temp[15];      // +
         subButton = temp[11];      // -
         equalButton = temp[17];    // =
         multiplyButton = temp[7];  // *
         clearButton = temp[0];     // Clear
         clearEverything = temp[1]; // Clear Everthing
         negativeButton =  temp[2]; // +/-

         //create layout using jpanel
         JPanel D = new JPanel(new GridLayout(1,2,2,2));
         D.add(digitButton[0] = new JButton("       0       "));
         digitButton[0].addActionListener(AL);
         JPanel E = new JPanel(new GridLayout(1,2,2,2));
         E.add(temp[16]);
         E.add(temp[17]);

        //create layout using jpanel
         contentPane.add(C);
         contentPane.add(D);
         D.add(E);

         // closing the calcuatlor with the exit
         frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frm.setVisible(true);
      }
}