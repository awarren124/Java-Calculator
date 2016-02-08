package calculator;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator {
	
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JLabel result = new JLabel("0");
	static JButton button = new JButton("Button1");
	static JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17;
	static GridBagConstraints c = new GridBagConstraints();
	static int operation = 0;
	static String nowText;
	static String thenText;
	static int sum;
	static int difference;
	static int product;
	static double quotient;

	public static void main(String[] args){
	
		panel.setLayout(new GridBagLayout());
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		c.gridwidth = 3;
		panel.add(result, c);
		c.gridwidth = 1;
		
		newOperationButton(button1, 1, 0, "+");
		newOperationButton(button2, 2, 0, "-");
		newOperationButton(button3, 3, 0, "X");
		newOperationButton(button4, 4, 0, "/");
		newButton(button5, 1, 1, "1");
		newButton(button6, 1, 2, "2");
		newButton(button7, 1, 3, "3");
		newButton(button8, 2, 1, "4");
		newButton(button9, 2, 2, "5");
		newButton(button10, 2, 3, "6");
		newButton(button11, 3, 1, "7");
		newButton(button12, 3, 2, "8");
		newButton(button13, 3, 3, "9");
		newButton(button16, 4, 1, "0");
		newEnterButton(button14, 4, 2, "Enter!");
		newClearButton(button15, 0, 3, "Clear");
		
		frame.add(panel);	
	}
	public static void newEnterButton(JButton button, int cY, int cX, String text){
		button = new JButton(text);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = cX;
		c.gridy = cY;
		c.gridheight = 1;
		c.gridwidth = 2;
		panel.add(button, c);


		button.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){

			if(operation == 1){
				thenText = result.getText();
				int nowInt = Integer.parseInt(nowText);
				int thenInt = Integer.parseInt(thenText);
				sum = nowInt + thenInt;
				result.setText(sum + " ");
				operation = 0;
			}else if(operation == 2){
				thenText = result.getText();
				int nowInt = Integer.parseInt(nowText);
				int thenInt = Integer.parseInt(thenText);
				difference = nowInt - thenInt;
				result.setText(difference + " ");
				operation = 0;
			}else if(operation == 3){
				thenText = result.getText();
				int nowInt = Integer.parseInt(nowText);
				int thenInt = Integer.parseInt(thenText);
				product = nowInt * thenInt;
				result.setText(product + " ");
				operation = 0;
			}else if(operation == 4){
				thenText = result.getText();
				double nowDou = (double)Integer.parseInt(nowText);
				double thenDou = (double)Integer.parseInt(thenText);
				quotient = nowDou / thenDou;
				result.setText(quotient + " ");
				operation = 0;
			}
		}});
	}
	public static void newClearButton(JButton button, int constraintY, int constraintX, String text){
		button = new JButton(text);
		c.fill = GridBagConstraints.HORIZONTAL;
		button.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
		
			result.setText("0");
			operation = 0;
			
		}});
		c.weightx = 0.5;
		c.gridx = constraintX;
		c.gridy = constraintY;
		panel.add(button, c);
	}
	public static void newButton(JButton button, int constraintY, int constraintX, String text){
		button = new JButton(text);
		c.fill = GridBagConstraints.HORIZONTAL;
		button.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
			
			if((result.getText()) == ("0")){
				result.setText(text);
			}else{
				result.setText(result.getText() + text);
			}
			
		}});
		c.weightx = 0.5;
		c.gridx = constraintX;
		c.gridy = constraintY;
		panel.add(button, c);
	}
	public static void newOperationButton(JButton button, int constraintY, int constraintX, String text){
		button = new JButton(text);
		c.fill = GridBagConstraints.HORIZONTAL;
		button.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
			
			if(text == ("+")){
				nowText = result.getText();
				operation = 1;
				result.setText("");
			}else if(text == ("-")){
				nowText = result.getText();
				operation = 2;
				result.setText("");
			}else if(text == ("X")){
				nowText = result.getText();
				operation = 3;
				result.setText("");
			}else if(text == ("/")){
				nowText = result.getText();
				operation = 4;
				result.setText("");
			}
			
		}});
		c.weightx = 0.5;
		c.gridx = constraintX;
		c.gridy = constraintY;
		panel.add(button, c);
	}
}
