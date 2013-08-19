package analysis;

import java.util.ArrayList;

import utils.IOStringParser;
import utils.IOUtils;
import dataObjects.Data;
import dataObjects.DataComponent;
import dataObjects.Peak;

public class Controller {

	public void launch(){
		IOUtils getData = new IOUtils();
		String filename = "014.txt";
		ArrayList<String> stringData = getData.openFile(filename);
		IOStringParser parse = new IOStringParser();
		Data data = parse.parseToDouble(stringData, "\\s+");
		CreateDataObjects test = new CreateDataObjects(data);
		DataComponent peak = test.identifyPeak(0, .10);
		String peakVals = "";
		for(int i = peak.getStart(); i< peak.getEnd(); i++){
			peakVals += peakVals + " " + data.getData()[i][1];
		}
		System.out.println(peakVals);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Controller run = new Controller();
		run.launch();

	}

}
