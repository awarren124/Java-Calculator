package calculator;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator {
	
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JButton button = new JButton("Button1");
	static JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;
	static GridBagConstraints c = new GridBagConstraints();
	
	public static void main(String[] args){
	
		panel.setLayout(new GridBagLayout());
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		newButton(button1, 0, 0, "+");
		newButton(button2, 1, 0, "-");
		newButton(button3, 0, 1, "X");
		newButton(button4, 1, 1, "/");
		
		frame.add(panel);
		
	}
	public static void newButton(JButton button, int constraintX, int constraintY, String text){
		button = new JButton(text);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = constraintX;
		c.gridy = constraintY;
		panel.add(button, c);
	}
}
