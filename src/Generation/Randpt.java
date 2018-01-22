package Generation;

import java.util.Random;

public class Randpt extends Gen_Main{
	public PointFormat prepare() {
	Random ran = new Random();
	double Xpos = 0;
	double Ypos = 0;
	
		Xpos = ran.nextInt(Width-40)+20;
		Ypos = ran.nextInt(Height-40)+20;
	
//		System.out.println(Xpos);
//		System.out.println(Ypos);
//	System.out.println("Random number ready !!");
	    return new PointFormat (Xpos, Ypos);
	}
}
	




