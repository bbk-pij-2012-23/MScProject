package tests;

public class ScratchPad {

	public void arrays() {
		String[][] array = new String[15][5];
		array[0][0] = "col1";
		array[0][1] = "col2";
		array[0][2] = "col3";
		array[0][3] = "col4";
		array[0][4] = "col5";

		int[][] intArray2 = { { 1, 1 }, { 2, 1 }, { 3, 1 }, { 4, 1 }, { 5, 1 },
				{ 6, 1 }, { 7, 1 }, { 8, 1 }, { 9, 1 }, { 10, 1 }, { 11, 1 },
				{ 12, 1 }, { 13, 1 }, { 14, 1 }, { 15, 1 } };
		int[][] intArray = new int[15][5];

		for (int rows = 0; rows < 15; rows++) {
			for (int cols = 0; cols < 5; cols++) {
				if (rows + cols < 15) {
					intArray[rows][cols] = intArray2[rows + cols][0];
				} else {
					continue;
				}
			}

		}
		System.out.println(printArray(intArray, new int[] { 15, 5 }));

	}

	/*
	 * dimensions[rows][cols]
	 */
	public String printArray(int[][] array, int[] dimensions) {
		String arrayString = "";
		for (int rows = 0; rows < dimensions[0]; rows++) {
			for (int cols = 0; cols < dimensions[1]; cols++) {
				arrayString = arrayString + " " + array[rows][cols];
			}
			arrayString = arrayString + "\n";
		}

		return arrayString;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScratchPad run = new ScratchPad();
		run.arrays();

	}

}
