package dataObjects;

public abstract class DataComponent {
	protected int start;
	protected int end;
	protected int[] dimensions;

	public void add(DataComponent newDataComponent) {
		throw new UnsupportedOperationException();
	}

	public void remove(DataComponent oldDataComponent) {
		throw new UnsupportedOperationException();
	}

	public DataComponent getDataComponent(int index){
		throw new UnsupportedOperationException();
	}
	
	
	
	public void displayInfo() {
		throw new UnsupportedOperationException();
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int[] getDimensions() {
		return dimensions;
	}	
	/*
	 * public void accept(ComponentVisitor visitor){ visitor.visit(this); }
	 */
}
