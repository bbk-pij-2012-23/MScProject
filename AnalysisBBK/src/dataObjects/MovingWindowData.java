package dataObjects;


/**
 * extends generic Data class, creates a dataset of the same dimensions as the
 * raw dataObject but where previous datapoints (y-1 to y-n) make up an x vector
 * to predict y value. remember that dimensions[0] = number of rows and
 * dimensions[1] = number of columns
 * 
 * @author emann06
 * 
 */

public class MovingWindowData extends Data {
	int window;

	public MovingWindowData(double[][] data, int[] dimensions, int window) {
		super(data, dimensions);
		this.window = window;
		this.data = createSegments();
	}

	/*
	 * At the moment SCL is fixed to the second column. This must be changed.
	 */
	private double[][] createSegments() {
		double[][] x = new double[dimensions[0]][window];

		for (int rows = 0; rows < dimensions[0]; rows++) {
			for (int cols = 0; cols < window; cols++) {
				if (rows + cols < dimensions[0]) {
					x[rows][cols] = data[rows + cols][0];
				} else {
					continue;
				}
			}

		}
		dimensions[1] = window;
		return x;
	}

	public static void main(String[] args) {

	}

}
