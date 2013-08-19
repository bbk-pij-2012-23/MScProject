package analysis;

import dataObjects.Data;
import dataObjects.DataComponent;
import dataObjects.Peak;
import dataObjects.Subsequence;

/*buffer = a minimum skin conductance level that when a subsequence falls below it 
 * no more subpeaks are included in the peak. 
 * 
 * Note: this buffer will have to be flexible enough to ignore monitor error where SCL for a single point is missing (set at 0)
 * 
 * minRise = the minium increase in SCL requeired to meet fixed criteria. default is 2mmho
 * maxDuration  = the maximum time allowed for the min increase to occur. default is 30seconds (which is 3 time units for hfm data
 */
public class FixedCriteriaAnalysis {
	Data sternalSkinConductance;
	Data yValues;
	double buffer = 0;
	double minRise = 2;
	int maxDuration = 3;

	// Rise currentRise;

	// sternalSkinConcordance needs to be initialised with dimensions
	public FixedCriteriaAnalysis(Data sternalSkinConductance) {
		try {
			this.sternalSkinConductance = sternalSkinConductance;
			double[][] ys = new double[sternalSkinConductance.getDimensions()[0]][1];
			int[] dims = { sternalSkinConductance.getDimensions()[0], 1 };
			yValues = new Data(ys, dims);
		} catch (NullPointerException ex) {
			System.out
					.println("Cannot create FixedCriteriaAnalysis object without setting dimensions of sternalSkinConducatance data");
		}

	}

	public double getBuffer() {
		return buffer;
	}

	public Data getSternalSkinConductance() {
		return sternalSkinConductance;
	}

	public void setSternalSkinCondcutance(Data sternalSkinCondcutance) {
		this.sternalSkinConductance = sternalSkinCondcutance;
	}

	public Data getYValues() {
		return yValues;
	}

	public void setYValues(Data yValues) {
		this.yValues = yValues;
	}

	

	/*
	 * given the start index and duration of the peak rise, what is the maximum
	 * change in 30 seconds (3 units)? currently does not use fixedCriteria
	 * attributes minIncrease and maxDuration, instead uses the default and
	 * assumes hfm data TO BE FIXED!!
	 */

	public boolean analyseRise(DataComponent rise) {

		double[] maxChange = { 0, 0 };
		double startValue = sternalSkinConductance.getData()[rise.getStart()][1];
		double change = 0.0;
		int duration = rise.getEnd() - rise.getStart();
		if (duration <= maxDuration) {
			maxChange[1] = sternalSkinConductance.getData()[rise.getEnd()][1]
					- startValue;
			maxChange[0] = rise.getEnd();
		} else { // this is a v slow way of implementing this - should use
					// moving window
			for (int i = 0; i < duration; i++) {
				if (duration - i > maxDuration) {
					change = sternalSkinConductance.getData()[rise.getStart()
							+ i + maxDuration][1]
							- sternalSkinConductance.getData()[rise.getStart()
									+ i][1];
					if (change > maxChange[1]) {
						maxChange[0] = rise.getStart() + i + maxDuration;
						maxChange[1] = change;
					}
				}
				change = sternalSkinConductance.getData()[rise.getEnd()][1]
						- sternalSkinConductance.getData()[rise.getStart() + i][1];
				if (change > maxChange[1]) {
					maxChange[0] = rise.getEnd();
					maxChange[1] = change;
				}
			}
		}
		((Subsequence) rise).setMaxIncrease(maxChange[1]);// possibly not
															// needed: review
															// later
		if (maxChange[1] >= minRise) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * This Yvalues updater can be used for rises or peaks
	 */
	public void updateYValues(DataComponent subsequence) {
		for (int i = subsequence.getStart(); i < subsequence.getEnd(); i++) {
			int[] index = { i, 0 };
			yValues.setDataValue(1, index);
		}

	}

	

	/*
	 * I don't really know how to check a minimum buffer yet
	 */
	private boolean checkBuffer(Peak peak) {
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * double[][] data = {{1.0, 1.57},{2.0, 1.51},{3.0, 1.41},{4.0,
		 * 1.19},{5.0, 1.21},{6.0, 1.29} ,{7.0, 1.27},{8.0,1.19}}; Data testData
		 * = new Data(data); FixedCriteriaAnalysis testRun = new
		 * FixedCriteriaAnalysis(testData); testRun.identfiyPeaks(1);
		 */

	}

}
