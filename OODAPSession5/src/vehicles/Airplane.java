/**
 * 
 */
package vehicles;

/**
 * @author emann06
 *
 */
public class Airplane {
	private int kind;
	private Flying hIF;
	
	public Airplane(int i, Flying fly) {
		kind = i;
		hIF = fly;
	}

	
	public String howDoYouFly() {
		return hIF.howIFly();
	}


	public String howDoYouLiftOff() {
		switch(kind){
			case 1: return "Vertically";
			case 2: return "I Liftoff";
			case 3: return "Horizontally";
			default: return null;
		}
			
	}

}
