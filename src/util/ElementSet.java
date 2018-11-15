package util;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class ElementSet implements Comparable<Object> {
	private int _id;
	private double _cost;
	// Use HashSet to reduce the runtime
	private HashSet<Integer> _coveredElements;
	
	public ElementSet() {
		_id = 0;
		_cost = 0;
		_coveredElements = new HashSet<Integer>();
	}
	
	public ElementSet(int ID, double Cost, List<Integer> Elements) {
		_id = ID;
		_cost = Cost;
		_coveredElements = new HashSet<Integer>(Elements);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Set ID: ");
		sb.append(String.format("%3s   ", _id));
		sb.append("Cost:  ");
		sb.append(String.format("%3.2f", _cost));
		sb.append("   Element IDs: " + this.orderElements(_coveredElements));
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof ElementSet) {
			ElementSet e = (ElementSet)o;
			return this._id == e._id && this._cost == e._cost && this._coveredElements.equals(e._coveredElements);
		}
		return false;
	}
	
	@Override
	// Rule: return 1  if this should come after o
	//       return -1 if this should come before o
	//       return 0 if equals() say these are equal!
	public int compareTo(Object o) {
		if (o instanceof ElementSet) {
			ElementSet e = (ElementSet)o;
			if(this.equals(e))
				return 0;
			else if(this._id != e._id)
				return (this._id - e._id);
		}
		return 1;
	}
	
	// get elements in order
	public TreeSet<Integer> orderElements(HashSet<Integer> hs){
		return new TreeSet<Integer>(hs);
	}
	
	public HashSet<Integer> getAllElements(){
		return _coveredElements;
	}
	
	public double getCost() {
		return _cost;
	}
	
	public int getId() {
		return _id;
	}
	
	// count how many valid new elements that are in both unusedElements and checked ElementSet
	public int countValidNewElements(HashSet<Integer> hs) {
		int count = 0;
		for (Integer i : _coveredElements) {
			if (hs.contains(i))
				count++;
		}
		return count;
	}
}

