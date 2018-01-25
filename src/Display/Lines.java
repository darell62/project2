package Display;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import Formatting.PointFormat;

public class Lines extends JFrame{

	public int[] xval = new int[3];
	public int[] yval = new int[3];
	int x,y,r;
	
	public void draw(PointFormat[] SmallTriCood, int Width , int Height, double x, double y, double r) {
		for (int i=0;i<SmallTriCood.length;i++){
			 xval[i] = (int)(SmallTriCood[i].getXpos());
			 yval[i] = (int)(SmallTriCood[i].getYpos());
			}
		this.x=(int)x;
		this.y=(int)y;
		this.r=(int)r;
		
		 Drawing(Width, Height);
	//	System.out.println("Lines Generated !!");

	}

	private void Drawing(int Width, int Height) {
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
		
		
//		for (int i=0; i+1<xval.length; i++){
//		g.setColor(new Color(0,255,0));
//		g.drawLine(xval[i], yval[i], xval[i+1], yval[i+1]);
//		}
		//g.drawOval(x, y, width, height);
		for (int i=0; i<xval.length-1;i++){

			g.setColor(new Color(0,100,0));
			g.drawLine(xval[i], yval[i], xval[i+1], yval[i+1]);
			//System.out.println(xval[i]);
			//System.out.println(xval[i+1]);
			//System.out.println(yval[i]);
			//System.out.println(yval[i+1]);
		}
			g.drawLine(xval[xval.length-1], yval[yval.length-1], xval[0], yval[0]);
			g.drawOval(x-r, y-r, r*2, r*2);
	}
	}
