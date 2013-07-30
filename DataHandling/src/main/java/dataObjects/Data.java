package dataObjects;
import no.uib.cipr.matrix.io.MatrixInfo;





public class Data {
	double [][] data;
	int[] dimensions;
	String variableLabels;
	
	public Data(double[][] data){
		this.data = data;
	}
	
	public Data(double[][] data, int[] dimensions){
		this.data = data;
		this.dimensions = dimensions;
	}

	public double[][] getData() {
		return data;
	}

	public void setData(double[][] data) {
		this.data = data;
	}

	public int[] getDimensions() {
		return dimensions;
	}

	public void setDimensions(int[] dimensions) {
		this.dimensions = dimensions;
	}

	public String getVariableLabels() {
		return variableLabels;
	}

	public void setVariableLabels(String variableLabels) {
		this.variableLabels = variableLabels;
	}
	
	public String toString(){
		String matrix = "";
		for (int i = 0; i < dimensions[0]; i++){
			
			for(int j = 0; j < dimensions[1]; j++){
				matrix = matrix + " " + data[i][j]; 
			}
			matrix = matrix + "\n";
		}
		return matrix;
	}
	
	
	
	
}
