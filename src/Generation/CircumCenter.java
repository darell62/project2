package Generation;

public class CircumCenter extends Gen_Main {
	
	double x,y,r;
	PointFormat[] SmallTriCood = new PointFormat[3];

	
	public CircumCenter(PointFormat[] ptarray, double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;

    }
	public CircumCenter find(PointFormat[] ptarray) {
	double x1,x2,x3,y1,y2,y3,Cx,Cy,s1,s2,a1,a2,b,c1,c2;
	PointFormat XY = new PointFormat(0,0);
	System.out.println("enter cicumcenter part");
	x1=ptarray[0].getXpos();
	x2=ptarray[1].getXpos();
	x3=ptarray[2].getXpos();
	y1=ptarray[0].getYpos();
	y2=ptarray[1].getYpos();
	y3=ptarray[2].getYpos();
	
	//fix x1,y1
	for (int i = 3 ;i<ptarray.length; i++){
		//construct a circle
		x = (((x3*x3-x2*x2)/2 +(y3*y3-y2*y2)/2)/(y3-y2) - ((x1*x1-x2*x2)/2 +(y1*y1-y2*y2)/2)/(y1-y2)) / ((x2-x1)/(y1-y2) - (x2-x3)/(y3-y2));
		y = (x*(x2-x1) + (x1*x1-x2*x2)/2 +(y1*y1-y2*y2)/2) / (y1-y2);
		r = Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
		Cx=ptarray[i].getXpos();
		Cy=ptarray[i].getYpos();
	if (Math.sqrt((Cx-x)*(Cx-x)+(Cy-y)*(Cy-y)) < r){
		//calculate the length of 2 triangle
		a1 = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		a2 = Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
		b = Math.sqrt((x1-Cx)*(x1-Cx)+(y1-Cy)*(y1-Cy));
		c1 = Math.sqrt((Cx-x2)*(Cx-x2)+(Cy-y2)*(Cy-y2));
		c2 = Math.sqrt((Cx-x3)*(Cx-x3)+(Cy-y3)*(Cy-y3));
		s1=(a1+b+c1)/2;
		s2=(a2+b+c2)/2;
		

		//compare the area of 2 triangle
		if (a1*b*c1/4/(Math.sqrt(s1*(s1-a1)*(s1-b)*(s1-c1))) < a2*b*c2/4/(Math.sqrt(s2*(s2-a2)*(s2-b)*(s2-c2)))){
			//swap point
			x3=Cx;
			y3=Cy ;
			System.out.println("2 change to " + i);
		}
		else{
			x2=Cx;
			y2=Cy;
			System.out.println("1 change to " + i);
		}
	}
	
	} 
	
	XY.setXpos(x1);
	XY.setYpos(y1);
	SmallTriCood[0]=XY;
	XY.setXpos(x2);
	XY.setYpos(y2);
	SmallTriCood[1]=XY;
	XY.setXpos(x3);
	XY.setYpos(y3);
	SmallTriCood[2]=XY;

	
//	System.out.println("x = " + x);
//	System.out.println("y = " + y);
//	System.out.println("r = " + r);
	
	System.out.println("*****" + SmallTriCood[0]);
	
	return new CircumCenter(SmallTriCood ,x ,y , r);
	}
	
	public PointFormat[] getTriCo() {
	        return SmallTriCood;
	    }
	
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getR() {
        return r;
    }
}
