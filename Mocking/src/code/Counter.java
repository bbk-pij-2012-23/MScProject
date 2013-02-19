package code;

public class Counter {
	private Integer count;
	
	public Counter() {
		super();
		this.count = 1;
	}
	public Integer getValue() {
		return count++;
	}
		

}
