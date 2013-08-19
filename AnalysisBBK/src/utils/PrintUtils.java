package utils;

import java.util.Iterator;
import java.util.List;


public class PrintUtils {
	
	
	public static String printMatrix(double[][] matrix, int[] dimensions){
		String printout = "";
		for(int rows = 0; rows < dimensions[0]; rows++){
			for(int cols = 0; cols < dimensions[1]; cols++){
				printout = printout + matrix[rows][cols] + " ";
			}
			printout = printout + "\n";
		}
		
		return printout;
	}
	
	public static String printList(List<Integer> list){
		String string = "";
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			
			string = string + ", " + it.next();
		}
		
		return string;
	}
}
