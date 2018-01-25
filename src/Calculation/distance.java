package Calculation;

import Formatting.PointFormat;

public class distance {
	public double dis(PointFormat A, PointFormat B){
		
	double dis = Math.sqrt( (A.getXpos() - B.getXpos()) * (A.getXpos() - B.getXpos())  + (A.getYpos() - B.getYpos()) * (A.getYpos() - B.getYpos()) );
	
	return dis;
	}
}