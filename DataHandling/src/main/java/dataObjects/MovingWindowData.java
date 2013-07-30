package dataObjects;

import java.io.IOException;

import no.uib.cipr.matrix.Matrix;
import no.uib.cipr.matrix.io.MatrixSize;
import no.uib.cipr.matrix.io.MatrixVectorReader;



public class MovingWindowData extends MatrixData{
	int window;
	MatrixSize size;
	
	public MovingWindowData(MatrixVectorReader in, int window) throws IOException {
		super(in);
		this.window = window;
		
		//createSegments();
	}
	
	public MovingWindowData(int rows, int columns){
		super(rows, columns);
		
	}
	
	
	public Moving
	
	private void createSegments(){
		double[][] x = new double[this.numRows][window];
		for(int i = 0; i<this.numRows; i++){
			for (int j=0; j<window; j++){
				x[i][j]=this.get(i+j, 2);
			}
		}
	}
	
}
