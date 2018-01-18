package Generation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Points extends JFrame{
	public int[] xval = new int[10];
	public int[] yval = new int[10];

	public void draw(PointFormat[] ptarray, int Width , int Height) {
		for (int i=0;i<ptarray.length;i++){
		 xval[i] = (int)ptarray[i].getXpos();
		 yval[i] = (int)ptarray[i].getYpos();
		}
		Drawing(Width , Height);
		System.out.println("Points Generated !!");
		
	}
	public void Drawing(int Width, int Height){
		setSize(Width, Height);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		//plot coordinate line
		g.setColor(new Color(100,0,0));
		for (int i=0; i<50; i++){
			g.drawLine(0, 10*i, 500, 10*i);
			g.drawLine(10*i, 0, 10*i, 500);
		}

		
		for (int i=0; i<xval.length; i++){
		g.setColor(new Color(25*i,0,0));
		g.fillOval(xval[i]-5, yval[i]-5, 10, 10);
		}
	}
	}
