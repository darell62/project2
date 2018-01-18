package Generation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

public class Shape extends JFrame{
	public int[] xval;
	public int[] yval;


	public void draw(int[] Xpos, int[] Ypos, int Width , int Height) {
		 xval = Xpos;
		 yval = Ypos;
		
		
		Drawing(Width , Height);
		//Graphics g;
		//paint(g, Xpos, Ypos);
		System.out.println("Points Generated !!");
		
	}
	public void Drawing(int Width, int Height){
		setSize(Width, Height);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		
		//points
		g.setColor(new Color(255,0,0));
		for (int i=0; i<xval.length; i++){
		g.fillOval(xval[i]-5, yval[i]-5, 10, 10);
		}
		
		//lines
		g.setColor(new Color(0,255,0));
		for (int i=0; i+1<xval.length; i++){
		g.drawLine(xval[i], yval[i], xval[i+1], yval[i+1]);
		}
		g.drawLine(xval[xval.length-1], yval[yval.length-1], xval[0], yval[0]);
	}
	}