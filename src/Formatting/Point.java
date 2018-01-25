package Formatting;

public class Point implements Comparable<Point> {
    private double pointnumber;
    private PointFormat pointcood;
    private double pointdis;

    public Point(double pointnumber, PointFormat pointcood, double pointdis) {
        this.pointnumber = pointnumber;
        this.pointcood = pointcood;
        this.pointdis = pointdis;
    }
     
    public double getPointnumber() {
		return pointnumber;
	}

	public void setPointnumber(double pointnumber) {
		this.pointnumber = pointnumber;
	}

	public PointFormat getPointcood() {
		return pointcood;
	}

	public void setPointcood(PointFormat pointcood) {
		this.pointcood = pointcood;
	}

	public double getPointdis() {
		return pointdis;
	}

	public void setPointdis(double pointdis) {
		this.pointdis = pointdis;
	}

	@Override
    public int compareTo(Point ptorder) {
        double ptcompare=ptorder.getPointdis();
        /* For Ascending order*/
        return (int)(this.pointdis-ptcompare);

        /* For Descending order do like this */
        //return compareage-this.studentage;
    }
    @Override
    public String toString() {
        return "[ Point index=" + pointnumber + ", Point Cood=" + pointcood + ", Point Dis=" + pointdis + "]";
    }
}