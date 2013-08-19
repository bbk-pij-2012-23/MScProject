package utils;

public class CSVParser {

	public String convertToCsv(double[][] dataMatrix, int[] dimensions) {
		String csvData = "";
		for (int rows = 0; rows < dimensions[0]; rows++) {
			for (int cols = 0; cols < dimensions[1]; cols++) {
				if (cols == dimensions[1] - 1) {
					csvData = csvData + dataMatrix[rows][cols];
				} else {
					csvData = csvData + dataMatrix[rows][cols] + ",";
				}
			}
			csvData = csvData + "\n";
		}
		return csvData;
	}

}
