

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener{
	private JPanel panel;
	private JTextField display;
	private JButton[] buttons;
	private String[] labels = {"Backspace", " ", " ", "C",
								"7", "8", "9", "/",
								"4", "5", "6", "x",
								"1", "2", "3", "-",
								"0", ".", "=", "+"
								};
	
	private double result = 0;
	private String operator = "=";
	private boolean startNumber = true;
	
	public Calculator() {
		display = new JTextField(35);
		panel = new JPanel();
		display.setText("0.0");
		display.setEnabled(true);
		
		panel.setLayout(new GridLayout(0, 4, 3, 3));
		buttons = new JButton[20];
		int index = 0;
		for(int rows = 0; rows < 5; rows++) {
			for(int cols = 0; cols < 4; cols++) {
				buttons[index] = new JButton(labels[index]);
				if(cols >= 3)
					buttons[index].setForeground(Color.pink);
				else if (cols > 1 && rows == 4)
						buttons[index].setForeground(Color.pink);
				else 
					buttons[index].setForeground(Color.cyan);
				buttons[index].setBackground(Color.darkGray);
				panel.add(buttons[index]);
				buttons[index].addActionListener(this);
				index++;
				}
			}
		add(display, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		pack();
		}
	
	public void actionPerformed(ActionEvent e) {
		   	
		String command = e.getActionCommand();
		if(command.charAt(0)=='C'){
			
			startNumber = true;
			result = 0;
			operator = "=";
			display.setText("0.0");
		
		}else if(command.charAt(0)>='0' && command.charAt(0) <= '9'
				|| command.equals(".")){
			if(startNumber == true)
				display.setText(command);
			else
				display.setText(display.getText() + command );
			startNumber = false;
		} else {
			if (startNumber) {
				if (command.equals("-")) {
					display.setText(command);
					startNumber = false;
				}else
					operator = command;
			} else {
				double a = Double.parseDouble(display.getText());
				calculate(a);
				operator = command;
				startNumber = true;
			}
		}
	}
	private void calculate(double n) {
		if (operator.equals("+"))
			result += n;
		else if (operator.equals("-"))
			result -= n;
		else if(operator.equals("x"))
			result *= n;
		else if(operator.equals("/"))
			result /= n;
		else if(operator.equals("="))
			result = n;
		display.setText(" " + result);
		
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator c = new Calculator();
	}

}
