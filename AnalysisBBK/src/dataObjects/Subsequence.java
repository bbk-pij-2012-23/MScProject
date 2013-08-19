/*Component of Peak
 * 
 */

package dataObjects;

public class Subsequence extends DataComponent {
	int start;
	int end;
	int duration; // would prefer this is not an attribute of Subsequence
	// double minValue;
	double maxIncrease;
	boolean meetsFixedCriteria;

	public Subsequence(int start) {
		this.start = start;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getMaxIncrease() {
		return maxIncrease;
	}

	public void setMaxIncrease(double maxIncrease) {
		this.maxIncrease = maxIncrease;
	}

	public boolean isMeetsFixedCriteria() {
		return meetsFixedCriteria;
	}

	public void setMeetsFixedCriteria(boolean meetsFixedCriteria) {
		this.meetsFixedCriteria = meetsFixedCriteria;
	}
	
	

}
