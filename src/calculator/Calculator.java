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
	
		panel.setLayout(new GridBagLayout());//Puts buttons on a grid
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		c.gridx = 0;//x position on grid
		c.gridy = 0;//y position on grid
		c.weightx = 0.5;//i don't know
		c.gridwidth = 3;//width on grid
		panel.add(result, c);// adds the result label
		c.gridwidth = 1;//sets width back to 1
		
		//Creating buttons
		
		//Operation buttons
		newOperationButton(button1, 1, 0, "+");//addition
		newOperationButton(button2, 2, 0, "-");//subtraction
		newOperationButton(button3, 3, 0, "X");//multiplication
		newOperationButton(button4, 4, 0, "÷");//division
		
		//Number buttons
		newButton(button5, 1, 1, "1");//1
		newButton(button6, 1, 2, "2");//2
		newButton(button7, 1, 3, "3");//3
		newButton(button8, 2, 1, "4");//4
		newButton(button9, 2, 2, "5");//5
		newButton(button10, 2, 3, "6");//6
		newButton(button11, 3, 1, "7");//7
		newButton(button12, 3, 2, "8");//8
		newButton(button13, 3, 3, "9");//9
		newButton(button16, 4, 1, "0");//0
		
		//Special buttons
		newEnterButton(button14, 4, 2, "Enter!");//enter
		newClearButton(button15, 0, 3, "Clear");//clear
		
		frame.add(panel);	
	}
	public static void newEnterButton(JButton button, int cY, int cX, String text){
		button = new JButton(text);

		c.fill = GridBagConstraints.HORIZONTAL;//fills grid from left to right
		c.weightx = 0.5;
		c.gridx = cX;
		c.gridy = cY;
		c.gridheight = 1;
		c.gridwidth = 2;
		panel.add(button, c);


		button.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){

			//if operation selected is addition
			if(operation == 1){
				thenText = result.getText();//second input
				int nowInt = Integer.parseInt(nowText);//turns first input into integer
				int thenInt = Integer.parseInt(thenText);//turns second input into integer
				sum = nowInt + thenInt;//adds inputs
				result.setText(sum + " ");//puts result on result label
				operation = 0;//sets operation back to zero
			}else if(operation == 2){
				thenText = result.getText();
				int nowInt = Integer.parseInt(nowText);
				int thenInt = Integer.parseInt(thenText);
				difference = nowInt - thenInt;//subtracts inputs
				result.setText(difference + " ");
				operation = 0;
			}else if(operation == 3){
				thenText = result.getText();
				int nowInt = Integer.parseInt(nowText);
				int thenInt = Integer.parseInt(thenText);
				product = nowInt * thenInt;//multiplies inputs
				result.setText(product + " ");
				operation = 0;
			}else if(operation == 4){
				thenText = result.getText();
				double nowDou = (double)Integer.parseInt(nowText);//turns first input into a double
				double thenDou = (double)Integer.parseInt(thenText);//turns second input into a double
				quotient = nowDou / thenDou;//divides inputs
				result.setText(quotient + " ");
				operation = 0;
			}
		}});
	}
	public static void newClearButton(JButton button, int constraintY, int constraintX, String text){
		button = new JButton(text);
		c.fill = GridBagConstraints.HORIZONTAL;
		button.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){
		
			result.setText("0");//clears result display
			operation = 0;//resets operation variable
			
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
			
			if((result.getText()) == ("0")){//if the display was cleared
				result.setText(text);//display the number
			}else{//if there are numbers there
				result.setText(result.getText() + text);//put the number at the end of the numbers already there
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
			
			if(text == ("+")){//if addition
				nowText = result.getText();//assign first input to variable
				operation = 1;//set operation variable to 1
				result.setText("");//display nothing
			}else if(text == ("-")){//if subtraction
				nowText = result.getText();
				operation = 2;//set operation variable to 2
				result.setText("");
			}else if(text == ("X")){//if multiplication
				nowText = result.getText();
				operation = 3;//set operation variable to 3
				result.setText("");
			}else if(text == ("÷")){//if division
				nowText = result.getText();
				operation = 4;//set operation variable to 4
				result.setText("");
			}
			
		}});
		c.weightx = 0.5;
		c.gridx = constraintX;
		c.gridy = constraintY;
		panel.add(button, c);
	}
}
