  
package utils;



public class ParsingUtils {

	/**simple transpose method 
	 * 
	 * @param columnArray
	 * @return
	 */
	public double[][] transposeArray(double[]columnArray){
		double[][] rowArray = new double[1][columnArray.length];
		for(int index = 0; index < columnArray.length; index++){
			rowArray[1][index] = columnArray[index];
		}
		
		return rowArray;
	}
	
 
}
