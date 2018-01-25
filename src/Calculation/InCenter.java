package Calculation;

import Formatting.PointFormat;

public class InCenter {
			
			
	public PointFormat find(PointFormat[] SmallTriCood) {
		distance d = new distance();
		
		PointFormat incen = new PointFormat(0,0);
		double disAB = d.dis(SmallTriCood[0], SmallTriCood[1]);
		double disAC = d.dis(SmallTriCood[0], SmallTriCood[2]);
		double disBC = d.dis(SmallTriCood[1], SmallTriCood[2]);
		
		double perimeter =  disAB + disAC + disBC ;
		
		incen.setXpos(((disAB * SmallTriCood[2].getXpos() + disAC * SmallTriCood[1].getXpos() + disBC * SmallTriCood[0].getXpos())/perimeter));
		incen.setYpos(((disAB * SmallTriCood[2].getYpos() + disAC * SmallTriCood[1].getYpos() + disBC * SmallTriCood[0].getYpos())/perimeter));
		
		return incen;
	}
	
	
	
	public static double distance(PointFormat A, PointFormat B){
		
	double dis = Math.sqrt( (A.getXpos() - B.getXpos()) * (A.getXpos() - B.getXpos())  + (A.getYpos() - B.getYpos()) * (A.getYpos() - B.getYpos()) );
	
	return dis;
	}
}
