package Display;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import Formatting.PointFormat;
import Generation.Gen_Main;

public class Shape extends Gen_Main{
	public int[] xval = new int[Numofpts];
	public int[] yval = new int[Numofpts];
	public PointFormat[] ptarray = new PointFormat[Numofpts];
	public PointFormat[][] XYcoodSet = new PointFormat[Numofpts-2][3];
	public PointFormat[] incen = new PointFormat[Numofpts-2];
	public PointFormat[] schptorder = new PointFormat[MaxNumofsearchsteps];
	public int[] Cx,Cy,Cr = new int[8];
	
	public void draw(PointFormat[] ptarray,PointFormat[][] XYcoodSet,PointFormat[] incen, PointFormat[] schptorder, int[] CircleX,int[] CircleY,int[] CircleR) {
		//point init
		this.ptarray = ptarray;
		this.incen = incen;
		for (int i=0;i<ptarray.length;i++){
			 xval[i] = (int)(ptarray[i].getXpos());
			 yval[i] = (int)(ptarray[i].getYpos());
			}
		
		//line init
		this.XYcoodSet=XYcoodSet;
		
		//circle init
		this.Cx=CircleX;
		this.Cy=CircleY;
		this.Cr=CircleR;

		this.schptorder=schptorder;
		
		 Drawing(Width, Height);
	}

	private void Drawing(int Width, int Height) {
		setSize(Width, Height);
		setVisible(true);
	}


	@Override
	public void paint(Graphics g) {
		int intwidth  = (int) (Width/10)	;
		int intheight = (int) (Width/10)	;
		
		//plot coordinate line
		g.setColor(new Color(230,230,230));
		for (int i=0; i<intwidth; i++){
			g.drawLine(0, 10*i, Width, 10*i);
		}
		for (int i=0; i<intheight; i++){
		g.drawLine(10*i, 0, 10*i, Height);
		}
		//points
		g.setColor(new Color(255,0,0));
		for (int i=0; i<ptarray.length; i++){
		g.fillOval(xval[i]-4, yval[i]-4, 8, 8);
		}
		
//		//circle
//		g.setColor(new Color(0,255,0));
//		for (int i=0; i<Cx.length;i++){
//		g.drawOval(Cx[i]-Cr[i], Cy[i]-Cr[i], Cr[i]*2, Cr[i]*2);
//		}
		
		//incenter of the cell
		g.setColor(new Color(0,0,255));
		for (int i=0; i<incen.length;i++){
		g.drawOval((int)(incen[i].getXpos()-4), (int)(incen[i].getYpos()-4), 8, 8);
		}
		
		// line for searching
		g.setColor(new Color(0,255,255));
		for (int i=0; i<MaxNumofsearchsteps+1;i++){
		g.drawLine((int)(schptorder[i].getXpos()), (int)(schptorder[i].getYpos()), (int)(schptorder[i+1].getXpos()), (int)(schptorder[i+1].getYpos()));
		}
		
//		//line start end
//		g.setColor(new Color(0,255,0));
//		g.drawLine(0, 0, Width, Height);
		
		
		//line
		g.setColor(new Color(0,0,0));
		//System.out.println("XYcoodSet : " + XYcoodSet.length);
		for (int i=0;i<XYcoodSet.length;i++){
		
		int ptAx = (int)(XYcoodSet[i][0].getXpos());
		int ptAy = (int)(XYcoodSet[i][0].getYpos());
		int ptBx = (int)(XYcoodSet[i][1].getXpos());
		int ptBy = (int)(XYcoodSet[i][1].getYpos());
		int ptCx = (int)(XYcoodSet[i][2].getXpos());
		int ptCy = (int)(XYcoodSet[i][2].getYpos());
		
		//line AB
		g.drawLine(ptAx ,ptAy ,ptBx ,ptBy);
		//line AC
		g.drawLine(ptAx ,ptAy ,ptCx ,ptCy);
		//line BC
		g.drawLine(ptBx ,ptBy ,ptCx ,ptCy);
		}
	}
	}