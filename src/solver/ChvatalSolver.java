package solver;

import util.ElementSet;

public class ChvatalSolver extends GreedySolver {
	public ChvatalSolver() {
		_name = "Chvatal";
	}

	@Override
	public ElementSet nextBestSet() {
		ElementSet bestSet = null;
		double currentCostPerEle = 0;
		double fewestCostPerEle = Double.MAX_VALUE;
		int countValidEles = 0;
		// same idea from previous and combine them together
		for (ElementSet e : _model.getOrderedEleSets()) {
			countValidEles = e.countValidNewElements(_unusedEles);
			if(countValidEles != 0) {
				currentCostPerEle = e.getCost()/countValidEles;
				if (fewestCostPerEle > currentCostPerEle) {
					fewestCostPerEle = currentCostPerEle;
					bestSet = e;
				}
			}
		}
		// TODO Auto-generated method stub
		return bestSet;
	}

}
