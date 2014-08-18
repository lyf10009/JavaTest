package com.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonTest 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
        ButtonFrame frame=new ButtonFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
}
class ButtonFrame extends JFrame
{
	public ButtonFrame()
	{
		setTitle("ButtonTest");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		ButtonPanel panel=new ButtonPanel();
		add(panel);
	}
	public static final int DEFAULT_WIDTH=300;
	public static final int DEFAULT_HEIGHT=200;
}
class ButtonPanel extends JPanel
{
	public ButtonPanel()
	{
	JButton yellowButton=new JButton("Yelllow");
	JButton blueButton=new JButton("Blue");
	JButton redButton=new JButton("Red");
	add(yellowButton);
	add(blueButton);
	add(redButton);
	ColorAction yellowAction=new ColorAction(Color.YELLOW);
	ColorAction blueAction=new ColorAction(Color.BLUE);
	ColorAction redAction=new ColorAction(Color.RED);
	yellowButton.addActionListener(yellowAction);
	blueButton.addActionListener(blueAction);
	redButton.addActionListener(redAction);
    }

private class ColorAction implements ActionListener
{
	public ColorAction(Color c)
	{
		backgroundColor=c;
	}
	public void actionPerformed(ActionEvent event)
	{
		setBackground(backgroundColor);
	}
	private Color backgroundColor;
}
}


