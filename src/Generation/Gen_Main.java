package Generation;


public abstract class Gen_Main {
	
	public final static int Width = 500;
	public final static int Height = 500;
	public final static int Numofpts = 10;

	public static void main(String[] args) {
//
// Initialise variable
		double x =0,y=0 ,r=0;
		PointFormat[] ptarray = new PointFormat[Numofpts];
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
		Points points = new Points();
		points.draw(ptarray, Width, Height);
//
// Calculate Circumcenter
		CircumCenter center = new CircumCenter(ptarray,  x,  y,  r);
		center.find(ptarray);
		PointFormat[] SmallTriCood = center.getTriCo();
		x = center.getX();
		y = center.getY();
		r = center.getR();
//
// Draw lines
		Lines lines = new Lines();
		lines.draw(SmallTriCood, Width, Height , x, y, r);
//
// Combine Draw
//		Shape shapes = new Shape();
//		shapes.draw(Xpos, Ypos, Width, Height);
		
//
// For Debug
		for (int i=0; i< ptarray.length; i++){
			System.out.println("X" + i + " = " + ptarray[i].getXpos());
			System.out.println("Y" + i + " = " + ptarray[i].getYpos());
		}
		
		for (int i=0; i< center.getTriCo().length; i++){
			System.out.println("Xco" + i + " = " + center.getTriCo()[i].getXpos());
			System.out.println("Yco" + i + " = " + center.getTriCo()[i].getYpos());
		}
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
