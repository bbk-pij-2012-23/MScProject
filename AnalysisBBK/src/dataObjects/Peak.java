package dataObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dataObjects.DataComponent;

public class Peak extends DataComponent {
	private List<DataComponent> subsequences= new ArrayList<DataComponent>();

	public List<DataComponent> getSubsequences() {
		return subsequences;
	}

	public void add(DataComponent newComponent) {
		subsequences.add(newComponent);
	}

	public void setRises(List<DataComponent> risesAndFalls) {
		this.subsequences = risesAndFalls;
	}

	public void setStart(int start) {
		this.start = start;
	}
	
	@Override
	public DataComponent getDataComponent(int index){
		return subsequences.get(index);
	}
	
	@Override
	public void remove(DataComponent oldDataComponent) {
		subsequences.remove(oldDataComponent);
	}

	
	
}
