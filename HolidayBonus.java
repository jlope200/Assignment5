package assignment5;

public class HolidayBonus {

	//constructor
	public HolidayBonus() {
	}
	
	/** Calculates the holiday bonus of each store
	 * 
	 * @param data is the two dimensional array of store sales
	 * @param high is the bonus for the highest store in a category
	 * @param low is the bonus for the lowest store in a category
	 * @param other is the bonus for all other stores in a category
	 * @return double[]
	 * @ author Jesus Lopez
	 * 
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		
		// building the array, phase 1
		double[][] bonusArrayCalculator = new double[data.length][]; // create array object for use below 
		
		for (int row = 0; row < data.length; row++) { // plow down through the rows 
			
			 bonusArrayCalculator[row] = new double [data[row].length]; // assigning the ragged rows
			 for (int column = 0; column < data[row].length; column++) {
				 if (data[row][column] <= 0) {
					 
					 // before we assignt he high and lows, we populate it with zero and other 
					 bonusArrayCalculator[row][column] = 0;	// assigning zero 
				 } 
				 else {
					 bonusArrayCalculator[row][column] = other; // fills in default values of other
				 }
			 }
		}
		
		final int RANGE = 6; // range of categories
		
		for (int column = 0; column < RANGE; column++) { // plow through the array
			
			int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, column); // index of the  of the highest element in a column
			int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, column); // index of smallest element in a column
		
			// protection phase
			if (highIndex >= 0) {
			
				bonusArrayCalculator[highIndex][column] = high;  // assigning the high
			}
			
			if (lowIndex >= 0 && highIndex != lowIndex && data[lowIndex][column]  > 0) { // logic includes edge case when the high and the low index is the same
				
				bonusArrayCalculator[lowIndex][column] = low;	// assigning the lows
			}
		}
		
		double[] holidayBonusPerStore = new double[bonusArrayCalculator.length]; // create an array to hold the total number of bonuses a store accrues
		
		for (int i = 0; i < bonusArrayCalculator.length; i++) {
			
			for (int j = 0; j < bonusArrayCalculator[i].length; j++) {
				
				holidayBonusPerStore[i] += bonusArrayCalculator[i][j]; // adding all the bonuses a store accrues
			}
		}
		return holidayBonusPerStore; // the total bonus for each store
	}
	
	/** Calculates the total of all holiday bonuses

	 * 
	 * @param data is the two dimensional array of store sales
	 * @param high is the bonus for the highest store in a category
	 * @param low is the bonus for the lowest store in a category
	 * @param other is the bonus for all other stores in a category
	 * @return a double 
	 * @ author Jesus Lopez
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		
		double holidayTotal = 0.0;
		
		// reuse code
		 double holidayBonusArr[] = calculateHolidayBonus(data, high,low, other );
		
		 for (int index = 0; index < holidayBonusArr.length; ++index) {
			 
		 			 holidayTotal += holidayBonusArr[index];
	}
		
		return holidayTotal;
	}
}