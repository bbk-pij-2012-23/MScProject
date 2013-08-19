package analysis;

import dataObjects.Data;
import dataObjects.DataComponent;
import dataObjects.Peak;
import dataObjects.Subsequence;

public class CreateDataObjects {
	private Data sternalSkinConductance;
	
	
	public CreateDataObjects(Data sternalSkinConductance){
		this.sternalSkinConductance = sternalSkinConductance;
		
	}
	
	public Data getSternalSkinConductance() {
		return sternalSkinConductance;
	}
	
	
	
	/**This method compares this and next values to find the lowest value and set it as start, then
	 * compares subsequent values to find the highest point and set it as end.
	 * 
	 * Error handling: checks that the next value index is not greater than the last index in the whole dataset
	 * before carrying out procedures.
	 * 
	 * @param start
	 * @return currentRise
	 */
	
	public DataComponent identifyRiseBoundaries(int start) {
		DataComponent currentRise = new Subsequence(start);
		double thisValue = 0;
		double nextValue = 0;
		int lastPoint = sternalSkinConductance.getDimensions()[0];
		if(lastPoint>start+1){
			thisValue = sternalSkinConductance.getData()[start][1];
			nextValue = sternalSkinConductance.getData()[start + 1][1];
			while (thisValue >= nextValue) {
				thisValue = nextValue;
				start++;
				nextValue = sternalSkinConductance.getData()[start + 1][1];
			}
			currentRise.setStart(start);
		}
		
		int end = start;
		if(lastPoint> end+1){
			thisValue = sternalSkinConductance.getData()[start][1];
				nextValue = sternalSkinConductance.getData()[start + 1][1];
			while (thisValue < nextValue) {
				thisValue = nextValue;
				end++;
				nextValue = sternalSkinConductance.getData()[end + 1][1];
			}
			currentRise.setEnd(end);
		}
		return currentRise;
	}
	
	
	/**
	 * This method iterates through skin conductance data from the specified
	 * index until the highest point is found and that is set as the start.
	 * iteration continues to the lowest point, which is set as the end of the
	 * subsequence.
	 * 
	 * NOTE that this conflicts with the identifyRiseBoundaries method because
	 * it sets the end at the highest point so there is double assignment of
	 * peak values.
	 * 
	 * @param start is the index to start at, but will be updated to be the first
	 * lowest point in the subsequence
	 * 
	 * @return currentFall, the DataComponent Subsequence
	 */
	public DataComponent identifyFallBoundaries(int start) {
		DataComponent currentFall = new Subsequence(start);
		double thisValue = 0;
		double nextValue = 0;
		int lastPoint = sternalSkinConductance.getDimensions()[0];
		if(lastPoint>start+1){
			thisValue = sternalSkinConductance.getData()[start][1];
			nextValue = sternalSkinConductance.getData()[start + 1][1];
			while (thisValue <= nextValue) {
				thisValue = nextValue;
				start++;
				nextValue = sternalSkinConductance.getData()[start + 1][1];
			}
			currentFall.setStart(start);
		}
		int end = start;
		if(lastPoint> end+1){
			thisValue = sternalSkinConductance.getData()[start][1];
			nextValue = sternalSkinConductance.getData()[start + 1][1];
			while (thisValue > nextValue) {
				thisValue = nextValue;
				end++;
				if(sternalSkinConductance.getDimensions()[0]>end+1){
					nextValue = sternalSkinConductance.getData()[end + 1][1];
				}
			}
			currentFall.setEnd(end);
		}
		return currentFall;
	}
	
	/*
	 * creates a peak that is a composite of rises and falls at the moment the
	 * peak is ended if fall end is lower than peak start,
	 * buffer is likely to be something like 10% of start value
	 */

		public DataComponent identifyPeak(int index, double bufferWeight) {
			DataComponent peak = new Peak();
			DataComponent firstRise = identifyRiseBoundaries(index);
			double buffer = firstRise.getStart()*bufferWeight;
			DataComponent fall = identifyFallBoundaries(firstRise.getEnd());
			peak.add(firstRise);
			peak.add(fall);
			peak.setEnd(fall.getEnd());
			while (sternalSkinConductance.getData()[fall.getEnd()][1] > (sternalSkinConductance.getData()[firstRise.getStart()][1]+buffer)) {
				DataComponent rise = identifyRiseBoundaries(fall.getEnd());
				peak.add(rise);
				fall = identifyFallBoundaries(rise.getEnd());
				peak.add(fall);
				peak.setEnd(fall.getEnd());
			}
			return peak;
		}
		
}
