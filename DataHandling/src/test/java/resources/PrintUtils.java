package resources;


public class PrintUtils {
	
	
	public String printMatrix(double[][] matrix, int[] dimensions){
		String printout = "";
		for(int rows = 0; rows < dimensions[0]; rows++){
			for(int cols = 0; cols < dimensions[1]; cols++){
				printout = printout + matrix[rows][cols] + " ";
			}
			printout = printout + "\n";
		}
		
		return printout;
	}
}
