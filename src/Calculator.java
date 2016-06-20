import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
	private JPanel panel;
	private JTextField display;
	private JButton[] buttons;
	private String[] labels = {"Backspace", " ", " ", "C",
								"7", "8", "9", "/",
								"4", "5", "6", "x",
								"1", "2", "3", "-",
								"0", ".", "=", "+"
								};
	public Calculator() {
		display = new JTextField(35);
		panel = new JPanel();
		display.setText("0.0");
		
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
				index++;
				}
			}
		add(display, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		pack();
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator s = new Calculator();
		System.out.println("Master Test");
		System.out.println("KooEunJeong Test");
	}

}
