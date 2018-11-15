package model;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import util.ElementSet;

public class SCPModel {
	private HashSet<ElementSet> _hsElementSets;
	
	
	public SCPModel() {
		_hsElementSets = new HashSet<ElementSet>();
	}
	
	public void addSetToCover(int ID, double weight, List<Integer> elements) {
		_hsElementSets.add(new ElementSet(ID, weight, elements));
	}
	
	public int countElements() {
		HashSet<Integer> _hsElements = new HashSet<Integer>();
		for(ElementSet e : _hsElementSets)
			_hsElements.addAll(e.getAllElements());
		return _hsElements.size();
	}
	
	public HashSet<Integer> getAllEles(){
		HashSet<Integer> _hsElements = new HashSet<Integer>();
		for(ElementSet e : _hsElementSets)
			_hsElements.addAll(e.getAllElements());
		return _hsElements;
	}

	// for print purpose and greedysolver(check from set 1 to set final)
	public TreeSet<ElementSet> getOrderedEleSets(){
		return new TreeSet<ElementSet>(_hsElementSets);
	}
	
	public HashSet<ElementSet> getUnorderedEleSets(){
		return new HashSet<ElementSet>(_hsElementSets);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("Weighted SCP model:\n");
		sb.append("---------------------\n");
		sb.append("Number of elements (n): " + this.countElements());
		sb.append("\nNumber of sets (m): " + _hsElementSets.size());
		sb.append("\n\nSet details:\n----------------------------------------------------------\n");
		for(ElementSet e : this.getOrderedEleSets()) {
			sb.append(e);
			sb.append("\n");
		}
		return sb.toString();
	}

	// Read files
	public static SCPModel readFiles(File file) throws IOException {
		BufferedReader cin = new BufferedReader(new FileReader(file));
		SCPModel model = new SCPModel();
		String idc = null;
		int numberofSets = 0;
		int id = 1;
		double cost = 0;
		ArrayList<Integer> ele = new ArrayList<Integer>();
		int i = 1; 
		do {
			if(idc == null) {
				idc = cin.readLine();
				numberofSets = Integer.parseInt(cin.readLine());
			}
			else {
				cost = Double.parseDouble(cin.readLine());
				for (i = Integer.parseInt(cin.readLine()); i !=0;) {
					ele.add(i);
					i = Integer.parseInt(cin.readLine());
				}
				model.addSetToCover(id, cost, ele);
				ele.removeAll(ele);
				id++;
			}
		}while(id != numberofSets+1);
		
		cin.close();
		return model;
	}
}
