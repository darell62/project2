package Calculation;

import Formatting.PointFormat;
import Generation.Gen_Main;

public class CircumCenter extends Gen_Main {
	
	double x,y,r;
	PointFormat[] SmallTriCood = new PointFormat[3];
	int startpt;
	
	public CircumCenter(PointFormat[] ptarray, double x, double y, double r, int startpt) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.startpt=startpt;

    }
	public CircumCenter find(PointFormat[] ptarray) {
	double[] X = new double[3];
	double[] Y = new double[3];
	double Nx,Ny,s1,s2,a1,a2,b,c1,c2;
	PointFormat[] Nptarray = new PointFormat[ptarray.length-1];
	
	
	int k = 0 ;  // k for New , i for old	
	for (int i =0; i <ptarray.length-1; i++){
		if (i == startpt){
			k = k+1;
		}
		Nptarray[i] = ptarray[k];
		k++;
	}
		
	int j = 0;
	//System.out.println("enter cicumcenter part");

	X[1]=Nptarray[j].getXpos();
	X[2]=Nptarray[j+1].getXpos();
	Y[1]=Nptarray[j].getYpos();
	Y[2]=Nptarray[j+1].getYpos();
	
	X[0]=ptarray[startpt].getXpos();
	Y[0]=ptarray[startpt].getYpos();
	

	
	//fix X[0],Y[0]
	int count =0;
	int countloop=0;
	while (count < ptarray.length-3){
		countloop = countloop + 1;
		if (countloop == 100){
		System.out.println("infinte loop");
		System.out.println("X : " + X[0] + "      Y : " + Y[0]);
			break;
		}
	for (int i = 3 ;i<ptarray.length; i++){
		//construct a circle
		x = (((X[2]*X[2]-X[1]*X[1])/2 +(Y[2]*Y[2]-Y[1]*Y[1])/2)/(Y[2]-Y[1]) - ((X[0]*X[0]-X[1]*X[1])/2 +(Y[0]*Y[0]-Y[1]*Y[1])/2)/(Y[0]-Y[1])) / ((X[1]-X[0])/(Y[0]-Y[1]) - (X[1]-X[2])/(Y[2]-Y[1]));
		y = (x*(X[1]-X[0]) + (X[0]*X[0]-X[1]*X[1])/2 +(Y[0]*Y[0]-Y[1]*Y[1])/2) / (Y[0]-Y[1]);
		r = Math.sqrt((x-X[0])*(x-X[0]) + (y-Y[0])*(y-Y[0]));
		Nx=ptarray[i].getXpos();
		Ny=ptarray[i].getYpos();

			if(Math.sqrt((Nx-x)*(Nx-x)+(Ny-y)*(Ny-y)) > r){
				count=count+1;
			}

	if (Math.sqrt((Nx-x)*(Nx-x)+(Ny-y)*(Ny-y)) < r){
		//calculate the length of 2 triangle
		a1 = Math.sqrt((X[0]-X[1])*(X[0]-X[1])+(Y[0]-Y[1])*(Y[0]-Y[1]));
		a2 = Math.sqrt((X[0]-X[2])*(X[0]-X[2])+(Y[0]-Y[2])*(Y[0]-Y[2]));
		b = Math.sqrt((X[0]-Nx)*(X[0]-Nx)+(Y[0]-Ny)*(Y[0]-Ny));
		c1 = Math.sqrt((Nx-X[1])*(Nx-X[1])+(Ny-Y[1])*(Ny-Y[1]));
		c2 = Math.sqrt((Nx-X[2])*(Nx-X[2])+(Ny-Y[2])*(Ny-Y[2]));
		s1=(a1+b+c1)/2;
		s2=(a2+b+c2)/2;
		//compare the area of 2 triangle
		if (a1*b*c1/4/(Math.sqrt(s1*(s1-a1)*(s1-b)*(s1-c1))) < a2*b*c2/4/(Math.sqrt(s2*(s2-a2)*(s2-b)*(s2-c2)))){
			if (Nx != X[1] && Ny != Y[1]) {
			//swap point
			X[2]=Nx;
			Y[2]=Ny;
			count =0;
			//System.out.println("2 change to " + i);
			}
			}
		else{
			if (Nx != X[2] && Ny != Y[2]) {
			X[1]=Nx;
			Y[1]=Ny;
			count = 0;
			//System.out.println("1 change to " + i);
			}
		}

}
}
//System.out.println("******************************");
	}
//	XY.setXpos(X[0]);
//	XY.setYpos(Y[0]);
//	System.out.println(XY.getXpos() + "     " + XY.getYpos());
	PointFormat AB = new PointFormat(X[0],Y[0]);
	SmallTriCood[0]=AB;
//	XY.setXpos(X[1]);
//	XY.setYpos(Y[1]);
//	System.out.println(XY.getXpos() + "     " + XY.getYpos());
	PointFormat AC = new PointFormat(X[1],Y[1]);
	SmallTriCood[1]=AC;
//	XY.setXpos(X[2]);
//	XY.setYpos(Y[2]);
//	System.out.println(XY.getXpos() + "     " + XY.getYpos());
	PointFormat BC = new PointFormat(X[2],Y[2]);
	SmallTriCood[2]=BC;
//System.out.println("******************************");
	//System.out.println("value " + X[0] + X[1] + X[2] + Y[0] + Y[1] +Y[2]);
//	System.out.println(SmallTriCood.length);
//	for (int i=0; i<SmallTriCood.length;i++){
//		System.out.println(SmallTriCood[i].getXpos() + "    " + SmallTriCood[i].getYpos());
//	}
	
//	System.out.println("x = " + x);
//	System.out.println("y = " + y);
//	System.out.println("r = " + r);
	
	
	return new CircumCenter(SmallTriCood ,x ,y , r, startpt);
	}
	
	public PointFormat[] getTriCo() {
	        return SmallTriCood;
	    }
	
    public double getXp() {
        return x;
    }
    public double getYp() {
        return y;
    }
    public double getR() {
        return r;
    }
}
