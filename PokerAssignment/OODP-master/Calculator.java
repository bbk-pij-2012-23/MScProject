/* Decoupling calculations from poker 'front end', best case first. 
 * 
 * 1. a calculator that can be plugged into any card game
 * 2. a 'best hand' calculator that can be plugged into any game needing best hand identifying (poker, blck jack, rummy...)
 * 3. a 'best hand' calculator that can be plugged into any poker game
 * 4. a 'best hand' calculator for this poker game.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Calculator<T> {



	
	/*Calculator needs to take 5 integer pairs and identify best existing hand
	 * 
	 * i) number of same values;
	 * ii) number of same suits
	 * iii) number of consecutive values
	 * 
	 * 
	 */	
	
	/**simple (ish) card matcher
	 * uses static Arrays sort function then matches neighbours and adds card values to arraylist.   
	 * @param values
	 * @return pairedValues
	 */
	public ArrayList<Integer> sameValues(int[] values){
		ArrayList<Integer> pairedValues = new ArrayList<Integer>();
		Arrays.sort(values);
		int i = 1;			 
		while(i<values.length){
			if (values[i]-values[i-1] == 0){					
				pairedValues.add(values[i]);
			}
			i++;	
		}
		return pairedValues;
	}	
	/**
	 * 
	 * @param values
	 * @return consecutives
	 */
	public ArrayList<Integer> consecValues(int[] values){
		ArrayList<Integer> consecutives = new ArrayList<Integer>(); 
		Arrays.sort(values);
		int i = 1;
		while(i<values.length){
			if(values[i]-values[i-1]==1){
				if(i==1){
					consecutives.add(values[i-1]);
				}
				else if (values[i-1]-values[i-2]!=1){
					consecutives.add(values[i-1]);
				}
				consecutives.add(values[i]);
			}
			i++;
		}
		return consecutives;
	}
	
	/**
	 * 
	 * @param values
	 * @return highValues
	 */
	
	public ArrayList<Integer> highValues(int[] values) {
		ArrayList<Integer> highValues = new ArrayList<Integer>();
		for(int value : values){
			if(value==1){
				highValues.add(1);
			}
			else{
				if(value>=11){
					highValues.add(value);
				}
			}
		}
		
		return highValues;
	}
	
	//to finish
	public ArrayList<Integer> highConsecs(ArrayList<Integer> highValues){
		if(highValues.size()>=2){
			int[] temp = new int[5];
			int i = 0;
			while (i<highValues.size()){
				temp[i] = (highValues.get(i));
				i++;
			}
			consecValues(temp);
			
		}
		return null;
	}
	
	
	public void print(ArrayList<T> printValues){
		Iterator<T> it = printValues.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}
	
	 /* calc then needs to id best potential hand
	 *  which needs an additional 
	 *  iv) mid range runs or skipped numbers
	 *  (not sure how yet - do i-iii first
	 * 
	 */
	
	public static void main (String[] args){
		int[] cardValues= {1,2,3,4,5};
		int[] suitValues = {2,2,2,2,2};
		Calculator<Integer> run =  new Calculator<Integer>();
		//ArrayList<Integer> sameValues = run.sameValues(cardValues);
		run.print(run.consecValues(cardValues));
		run.print(run.sameValues(suitValues));
		//ArrayList<Integer> sameSuits = run.sameValues(suitValues);
		

	}
	
}
