package dataObjects;

import java.io.IOException;

import no.uib.cipr.matrix.DenseMatrix;
import no.uib.cipr.matrix.io.MatrixVectorReader;

public class MatrixData extends DenseMatrix {

	public MatrixData(MatrixVectorReader in) throws IOException {
		super(in);
	}
	
	public MatrixData(int rows, int columns){
		super(rows,columns);
	}
	
}
