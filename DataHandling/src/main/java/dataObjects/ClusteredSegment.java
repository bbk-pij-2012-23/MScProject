package dataObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.IOUtils;
import utils.ParsingUtils;

public class ClusteredSegment extends Data {
	private ArrayList<Integer> segmentCutpoints;
	private int maxSize;
	private double[][] segmentedData;		
	/*
	 * Eeeek!
	 */
	public ClusteredSegment(Data data) {
		super(data.getData(), data.getDimensions());
		this.segmentCutpoints = new ArrayList<Integer>(); 
	}

	public ArrayList<Integer> getSegmentCutpoints() {
		// TODO Auto-generated method stub
		return segmentCutpoints;
	}
	
	public double[][] getSegmentedData(){
		return segmentedData;
	}
	
	/**
	 * take a raw data object with clusters assigned and create segments based
	 * on the change from one cluster to another
	 */
	public void defineSegmentSizes(){
	
		for (int rows = 1; rows< dimensions[0]; rows++){
			if (data[rows][2]!=data[rows-1][2]){
				segmentCutpoints.add(rows);	
			}
		}
		
	}
	
	public void setSegmentedDataDimensions(){
		if(segmentCutpoints==null){
			defineSegmentSizes();
		}
		Iterator<Integer> it = segmentCutpoints.iterator();
		maxSize = 0;
		int lastSize = segmentCutpoints.get(0);
		while(it.hasNext()){
			int size = it.next();
			if (size-lastSize>maxSize){
				maxSize=size-lastSize;
			}
			lastSize = size;
		}
		segmentedData = new double[segmentCutpoints.size()][maxSize];
	}
	/*
	 * I think there is a way to combine these verbose methods
	 */
	public void createClusterSegments(){
		Iterator<Integer> it = segmentCutpoints.iterator();
		int end = 0;
		int start = 0;
		int counter =0;
		while(it.hasNext()){
			counter++;
			end = it.next();
			double[]segment = new double[end-start];
			for (int rows = start; rows < end; rows++){
				segment[rows]=data[start+rows][1];
			}
			storeSegment(segment, counter);
			start = end+1;
		}
	}
	/*there is a problem with the transpose function 
	 * 
	 * 
	 */
	private void storeSegment(double[] columnSegment, int rowNo){
		ParsingUtils run = new ParsingUtils();
		double[][] rowSegment = run.transposeArray(columnSegment);
		for(int column = 0; column < rowSegment.length; column++){
			segmentedData[rowNo][column] = rowSegment[0][column];
		}
		
		/*transpose array from column to row
		 * add array to data
		 */
		
		
	}

	public static void main(String[] args) {
		IOUtils get = new IOUtils();
		Data data = get.openFile("H:/MScProject/data/ClusteredSegment012.txt");
		ClusteredSegment cdata = new ClusteredSegment(data);
		cdata.defineSegmentSizes();
		cdata.setSegmentedDataDimensions();
		cdata.createClusterSegments();
	}
	
}

