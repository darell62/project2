package Searching;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import Calculation.distance;
import Formatting.Point;
import Formatting.PointFormat;
import Generation.Gen_Main;

public class Search extends Gen_Main {

	public PointFormat[] search(PointFormat[] incen) {
		PointFormat[] schptorder = new PointFormat[MaxNumofsearchsteps + 2]; // Arraylist
																				// to
																				// array
																				// ?
		// PointFormat currentpt = getstartpt(incen);
		// PointFormat endpt = getendpt(incen);

		PointFormat currentpt = new PointFormat(0, 0);
		PointFormat endpt = new PointFormat(Width, Height);

		int loopcount = 0;
		// get possible points
		ArrayList<PointFormat> possiblept = new ArrayList<>();
		ArrayList<PointFormat> ptroute = new ArrayList<>();
		ArrayList<PointFormat> repeatptcrtl = new ArrayList<>();
		ArrayList<Point> getnearestpt = new ArrayList<>();
		ptroute.add(currentpt);
		distance d = new distance();
		int pointcount = 0;

		for (int i = 0; i < incen.length; i++) {
			repeatptcrtl.add(incen[i]);
		}

		while (currentpt != endpt && loopcount != MaxNumofsearchsteps) {
			for (int i = 0; i < repeatptcrtl.size(); i++) {
				double disofpts = d.dis(currentpt, repeatptcrtl.get(i)); // still
																			// need
																			// to
																			// exclude
																			// itself
				if (disofpts < Decisionthreshold) {
					possiblept.add(repeatptcrtl.get(i));
					pointcount++;
				}
			}

			System.out.println("pointcount : " + pointcount);

			// make decision
			Random ran = new Random();
			if (pointcount >= 1) {
				int DecisVal = ran.nextInt(pointcount);
				System.out.println(DecisVal);
				currentpt = possiblept.get(DecisVal);
			} else {
				for (int i = 0; i < repeatptcrtl.size(); i++) {
					double disofpts = d.dis(currentpt, repeatptcrtl.get(i)); // still
																				// need
																				// to
																				// exclude
																				// itself
					if (disofpts != 0) {
						getnearestpt.add(new Point(i, repeatptcrtl.get(i), disofpts));
					}
				}
				Collections.sort(getnearestpt);
				// for(ArrayClass pointsort: getnearestpt){
				// System.out.println(pointsort.toString());
				// }

				currentpt = getnearestpt.get(0).getPointcood(); // point 0 is
																// itself

				getnearestpt.clear();
				// System.out.println("current point : " +
				// currentpt.toString());
				// ******************** using random here, need to change to
				// sort********************
				// int DecisVal = ran.nextInt(repeatptcrtl.size());
				// currentpt = repeatptcrtl.get(DecisVal);

			}

			// record and move to next points

			ptroute.add(currentpt);

			pointcount = 0;
			loopcount = loopcount + 1;
			possiblept.clear();
			int index = repeatptcrtl.indexOf(currentpt);
			if (index >= 0) {
				repeatptcrtl.remove(index);
			}
		}
		ptroute.add(endpt);
		ptroute.toArray(schptorder);

		return schptorder;
	}

	public static PointFormat getstartpt(PointFormat[] points) {
		PointFormat minval = new PointFormat(points[0].getXpos(), points[0].getYpos());
		for (int i = 0; i < points.length - 1; i++) {
			if (points[i].getXpos() > points[i + 1].getXpos())
				minval.setXpos(points[i + 1].getXpos());
			minval.setYpos(points[i + 1].getYpos());
		}
		return minval;
	}

	public static PointFormat getendpt(PointFormat[] points) {
		PointFormat maxval = new PointFormat(points[0].getXpos(), points[0].getYpos());
		for (int i = 0; i < points.length - 1; i++) {
			if (points[i].getXpos() < points[i + 1].getXpos())
				maxval.setXpos(points[i + 1].getXpos());
			maxval.setYpos(points[i + 1].getYpos());
		}
		return maxval;
	}

}
