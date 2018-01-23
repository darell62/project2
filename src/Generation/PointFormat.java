package Generation;

final class PointFormat extends Randpt{

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

	}