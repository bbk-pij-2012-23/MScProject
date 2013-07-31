package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import dataObjects.Data;

public class IOUtils {

	/**general file opener
	 * trims leading spaces, which is needed for later parsing
	 * @param filename
	 * @return array, an ArrayList of rows in Strings for parsing into numeric data
	 */
	public Data openFile(String filename){
		ArrayList<String> array = new ArrayList<String>();
		File file = new File(filename);
		BufferedReader in = null;
		try{
			in = new BufferedReader(new FileReader(file));
			String line;
		
			while((line=in.readLine()) != null){
				line = line.trim();
				array.add(line);
			}
		
		}catch(FileNotFoundException ex){
			System.out.println("File not found");
		}catch(IOException ex){
			System.out.println("io exception at ");
			ex.printStackTrace();
		}finally{
			closeReader(in);
		}
		
		IOStringParser parse = new IOStringParser();
		Data data = parse.parseToDouble(array, "\\s+");
		return data;
	}
	

	/**Finally calls an io method (close), so a separate method allowing exceptions to be reported has been created
	 * 
	 * @param reader
	 */
	private void closeReader(Reader reader){
		try{
			if(reader != null){
				reader.close();
			}
		}catch(IOException ex){
			System.out.println("Problem closing reader");
			ex.printStackTrace();
		}
	}
	
	
	
	public void writeAFile(String location, String toWrite){
		File file = new File(location);
		FileWriter out = null;
		try{
			out = new FileWriter(file, true);
			out.write(toWrite);
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}finally{
			closeWriter(out);
		}
		
	}
	
	private void closeWriter(Writer writer){
		try{
			if(writer!=null){
				writer.close();
			}
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
