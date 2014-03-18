package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class TimerTest 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ActionListener listener=new TimerPrinter();
        Timer t=new Timer (10000,listener);
        t.start();
        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
	}
}
class TimerPrinter implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
    	Date now=new Date();
    	System.out.println("At the tone,the time is"+now);
    	Toolkit.getDefaultToolkit().beep();
    }
}