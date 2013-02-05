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

	public Airplane(int i) {
		kind = i;
	}

	public String howDoYouFly() {
		switch(kind){
			case 1: return "Like a fighter jet";
			case 2: return "I don't fly";
			case 3: return "Like a passenger plane";
			default: return null;
		}
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
