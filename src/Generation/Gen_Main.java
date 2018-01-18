package Generation;


public abstract class Gen_Main {
	
	public final static int Width = 500;
	public final static int Height = 500;
	public final static int Numofpts = 10;

	
	//public abstract PointFormat draw();
	
	public static void main(String[] args) {
		double x =0,y=0 ,r=0;
		PointFormat[] ptarray = new PointFormat[Numofpts];
	for (int i=0; i < Numofpts; i++){	
		Randpt randpts = new Randpt();
		PointFormat Result = randpts.prepare();
		ptarray[i]=Result;
		double Xpos = Result.getXpos();
		double Ypos = Result.getYpos();
	}
		
		Points points = new Points();
		points.draw(ptarray, Width, Height);
		CircumCenter center = new CircumCenter(ptarray,  x,  y,  r);
		center.find(ptarray);
//		PointFormat[] XYco = center.getTriCo();
//		double[] Xco = XYco.getXpos();
//		double[] Yco = XYco.getYpos();
		PointFormat[] SmallTriCood = center.getTriCo();
		x = center.getX();
		y = center.getY();
		r = center.getR();



		System.out.println(SmallTriCood[1].getXpos());
		System.out.println(SmallTriCood[1].getYpos());

		Lines lines = new Lines();
		lines.draw(SmallTriCood, Width, Height , x, y, r);
//		Shape shapes = new Shape();
//		shapes.draw(Xpos, Ypos, Width, Height);
		
		
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
