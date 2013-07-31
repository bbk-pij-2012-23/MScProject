package utils;


import java.util.ArrayList;





public class CSVParser {
	int[] dimensions = {0,0};
	
	public int[] getDimensions(){
		return dimensions;
	}
	
	
	public String convertToCsv(double[][] dataMatrix, int[] dimensions){
		String csvData = "";
		for(int rows = 0; rows < dimensions[0]; rows++){
			for(int cols = 0; cols< dimensions[1]; cols++){
				if(cols==dimensions[1]-1){
					csvData = csvData + dataMatrix[rows][cols];
				}else{
					csvData = csvData + dataMatrix[rows][cols] + ",";
				}
			}
			csvData = csvData + "\n";
		}
		return csvData;
	}
	
	
	public double[][] temp(ArrayList<String> ioInput){
		int columns = ioInput.get(0).split("\\s+").length;
		int rows = ioInput.size();
		double [][] array = new double [rows][columns];
		for (int i = 0; i < rows; i++){
			String[] s = ioInput.get(i).split("\\s+");
			for(int j=0; j < columns; j++){
				try{
					array[i][j] = Double.parseDouble(s[j]);
				}catch(NumberFormatException ex){
					System.out.println("this data contains non-numeric values");
					//ParserFactory.parserMenu(ioInput); //this is currently static, which I don't like, but its a holder method
				}
			}
		}
		dimensions[0] = rows;
		dimensions[1] = columns;
		return array;
	}


}
