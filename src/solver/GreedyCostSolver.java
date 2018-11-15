package solver;

import util.ElementSet;

public class GreedyCostSolver extends GreedySolver{
	
	public GreedyCostSolver() {
		_name = "Cost";
	}

	@Override
	public ElementSet nextBestSet() {
		// TODO Auto-generated method stub
		double currentCost = 0;
		double fewestCost = Double.MAX_VALUE;
		ElementSet bestSet = null;
		// same idea from coverage, but depends on cost
		for (ElementSet e : _model.getOrderedEleSets()) {
			if(!(e.countValidNewElements(_unusedEles) == 0)){
				currentCost = e.getCost();
				if (fewestCost > currentCost) {
					fewestCost = currentCost;
					bestSet = e;
				}
			}
		}
		return bestSet;
	}

}