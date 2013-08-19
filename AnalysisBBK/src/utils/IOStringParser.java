package utils;

import java.util.ArrayList;

import dataObjects.Data;

public class IOStringParser {

	/**
	 * Takes a io string arraylist and parsers to a double[][] matrix This does
	 * very little error checking - assumes that the file is delimited correctly
	 * (no trailing spaces etc)
	 * 
	 * @param ioInput
	 * @param delimiter
	 * @return dataObject a Data object with the dataObject matrix and
	 *         dimensions info in place
	 */
	public Data parseToDouble(ArrayList<String> ioInput, String delimiter) {

		int columns = ioInput.get(0).split(delimiter).length;
		int rows = ioInput.size();
		double[][] array = new double[rows][columns];
		for (int i = 0; i < rows; i++) {
			String[] s = ioInput.get(i).split(delimiter);
			for (int j = 0; j < columns; j++) {
				try {
					array[i][j] = Double.parseDouble(s[j]);
				} catch (NumberFormatException ex) {
					System.out
							.println("this dataObject contains non-numeric values");
					// ParserFactory.parserMenu(ioInput); //this is currently
					// static, which I don't like, but its a holder method
				}
			}
		}
		int[] dimensions = { rows, columns };
		Data data = new Data(array, dimensions);
		return data;
	}

}
