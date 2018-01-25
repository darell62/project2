package Formatting;

public final class PointFormat implements Comparable<PointFormat>{

	 	private double Xpos;
	    private double Ypos;

	    public PointFormat(double Xpos, double Ypos) {
	        this.Xpos = Xpos;
	        this.Ypos = Ypos;

	    }

		public double getXpos() {
			return Xpos;
		}

		public void setXpos(double xpos) {
			Xpos = xpos;
		}

		public double getYpos() {
			return Ypos;
		}

		public void setYpos(double ypos) {
			Ypos = ypos;
		}

		@Override
		public int compareTo(PointFormat o) {
			// TODO Auto-generated method stub
			return 0;
		}

	}