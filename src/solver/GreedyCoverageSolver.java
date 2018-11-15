package solver;

import util.ElementSet;

public class GreedyCoverageSolver extends GreedySolver{
	
	public GreedyCoverageSolver() {
		_name = "Coverage";
	}

	@Override
	public ElementSet nextBestSet() {
		// TODO Auto-generated method stub
		int _nCurrentCoveredEles = 0;
		int _nMostCoveredEles = 0;
		ElementSet bestSet = null;
		// for each loop to access each elementSet by order
		for(ElementSet e : _model.getOrderedEleSets()) {
			// check how many new uncovered elements in the elementSet
			_nCurrentCoveredEles = e.countValidNewElements(_unusedEles);
			// compare
			if(_nCurrentCoveredEles > _nMostCoveredEles) {
				_nMostCoveredEles = _nCurrentCoveredEles;
				bestSet = e;
			}
			
		}
		return bestSet;
	}

}
