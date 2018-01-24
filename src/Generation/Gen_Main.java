package Generation;

import java.util.ArrayList;

import javax.swing.JFrame;

public abstract class Gen_Main extends JFrame {
	
	public final static int Width = 1200;
	public final static int Height = 800;
	public final static int Numofpts = 100;
	public final static int Decisionthreshold = 100;
	public final static int MaxNumofsearchsteps = 50;

	public static void main(String[] args) {
//
// Initialise variable
		double x =0,y=0 ,r=0;
		PointFormat[] ptarray = new PointFormat[Numofpts];
		PointFormat[][] XYcoodSet =new PointFormat[Numofpts-2][3];
		PointFormat[] incen = new PointFormat[Numofpts-2];
		double[] CircleX = new double[Numofpts-2];
		double[] CircleY = new double[Numofpts-2];
		double[] CircleR = new double[Numofpts-2];
		int[] CircleX1 = new int[Numofpts-2];
		int[] CircleY1 = new int[Numofpts-2];
		int[] CircleR1 = new int[Numofpts-2];

//
// Random points generation
	for (int i=0; i < Numofpts; i++){	
		Randpt randpts = new Randpt();
		PointFormat Result = randpts.prepare();
		ptarray[i]=Result;
		double Xpos = Result.getXpos();
		double Ypos = Result.getYpos();
	}

	
//
// Draw Points
//		Points points = new Points();
//		points.draw(ptarray, Width, Height);
		
	System.out.println("Start Calculate Process");
	for (int startpt = 0; startpt < ptarray.length-2; startpt++) {
		//System.out.println(startpt);
//
// Calculate Circumcenter
		CircumCenter center = new CircumCenter(ptarray,  x,  y,  r, startpt);
		center.find(ptarray);
		PointFormat[] SmallTriCood = center.getTriCo();
//		for (int i=0; i<SmallTriCood.length;i++){
//			System.out.println(SmallTriCood[i].getXpos() + "    " + SmallTriCood[i].getYpos());
//		}
		
		XYcoodSet[startpt] = SmallTriCood;
		CircleX[startpt] = center.getXp();
		CircleY[startpt] = center.getYp();
		CircleR[startpt] = center.getR();
		
		InCenter incenter = new InCenter();
		incen[startpt]=incenter.find(SmallTriCood);
//
// Draw lines
//		Lines lines = new Lines();
//		lines.draw(SmallTriCood, Width, Height , x, y, r);
		
	}
//
//  Search
	System.out.println("Start Searching Process");
	Search sch = new Search();
	PointFormat[] schptorder = sch.search(incen);
	
	
	System.out.println("Start Drawing Process");
	//System.out.println("the length of schptorder : " + schptorder.length);
	for (int l =0; l < MaxNumofsearchsteps; l++){
		System.out.println("index of point : " + l);
		System.out.println(schptorder[l].getXpos() + "          " + schptorder[l].getYpos());
	}
	
//
// Combine Draw
	for (int i=0; i<Numofpts-2;i++ ){
		CircleX1[i] = (int)(CircleX[i]);
		CircleY1[i] = (int)(CircleY[i]);
		CircleR1[i] = (int)(CircleR[i]);
	}

		Shape shapes = new Shape();
		shapes.draw(ptarray,XYcoodSet,incen,schptorder,CircleX1,CircleY1,CircleR1);


		
		
	System.out.println("Finish Process");
//
// For Debug
//		for (int i=0; i< ptarray.length; i++){
//			System.out.println("X" + i + " = " + ptarray[i].getXpos());
//			System.out.println("Y" + i + " = " + ptarray[i].getYpos());
//		}
//		
//		for (int i=0; i< center.getTriCo().length; i++){
//			System.out.println("Xco" + i + " = " + center.getTriCo()[i].getXpos());
//			System.out.println("Yco" + i + " = " + center.getTriCo()[i].getYpos());
//		}
//		Gen_Main[] Gen_All = new Gen_Main[3];
//		Gen_All[0] = randpts;
//		Gen_All[1] = points;
//		Gen_All[2] = lines;
//		
//		for (Gen_Main i : Gen_All) {
//			i.draw();
//		}
		
		
		
	}
}
