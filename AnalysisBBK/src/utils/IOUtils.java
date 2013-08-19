package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class IOUtils {

	/**
	 * general file opener
	 * 
	 * @param filename
	 * @return array, an ArrayList of rows in Strings for parsing into numeric
	 *         dataObject
	 */
	public ArrayList<String> openFile(String filename) {
		ArrayList<String> array = new ArrayList<String>();
		File file = new File(filename);
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
			String line;

			while ((line = in.readLine()) != null) {
				array.add(line);
			}
			return array;
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {
			System.out.println("io exception at ");
			ex.printStackTrace();
		} finally {
			closeReader(in);
		}
		return array;
	}

	/**
	 * Finally calls an io method (close), so a separate method allowing
	 * exceptions to be reported has been created
	 * 
	 * @param reader
	 */
	private void closeReader(Reader reader) {
		try {
			if (reader != null) {
				reader.close();
			}
		} catch (IOException ex) {
			System.out.println("Problem closing reader");
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
