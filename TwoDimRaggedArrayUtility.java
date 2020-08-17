package assignment5;

/*
* Class: CMSC203
* Instructor: Dr. Grimberg
* Description: Assignment #5, making a 2 dimensional ragged array of type double
* Due: (08/16/2020)
* I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 I have not given my code to any student.
 Programmer: Jesus Lopez
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	
	// constructor
	public static void TwoDimRaggedArrayUtility() {
		return;
	}
	
	/*
	 * NOTE TO SELF: re-name "i" and "j" variables as "row" and "column"
	 */
	
	/*
	 * Read & Write-to-file methods up ahead
	 */
	
	/**this passes in a file to be read, and returns a 2-dimensional ragged array of doubles
	 * @param file
	 * @return array
	 * @throws java.io.FileNotFoundException
	 * @author Jesus Lopez
	 */
	public static double[][] readFile(java.io.File file) throws java.io.FileNotFoundException{
		
	double[][] array = null; // with this, method will return null if file is empty
	
		try {		
			Scanner reader = new Scanner(file); // creates scanner object to read specified file
			int rows = 0; // holds number of rows
			
			while (reader.hasNextLine()) { // loop to determine rows count
				++rows;
				reader.nextLine();
			}
			reader.close();
			
			Scanner input = new Scanner(file);
			array= new double[rows][]; // array with the correct number of rows
			String holdData;
					for (int index = 0; index < array.length; ++index) { // loops through rows
						holdData = input.nextLine(); 
						String[] columns = holdData.split(" "); // split on a space
						array[index] = new double[columns.length];
						for (int j = 0; j < array[index].length; ++j) {
							// for debugging 
							// System.out.println(columns[j]);
							array[index][j] = Double.valueOf(columns[j]);
						}
					}		
					input.close();	
			}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return array;
	}
	/** Passes in a 2-dimensional array of doubles and a specified file,
	 *  then writes the data from the 2-dimensional array into that file.
	 * 
	 * @param data
	 * @param outputFile
	 * @throws java.io.FileNotFoundException
	 * @author Jesus Lopez
	 */
	
	public static void writeToFile (double[][] data, java.io.File outputFile) throws java.io.FileNotFoundException {
		
		try {
			PrintWriter output = new PrintWriter(outputFile); // print writer object to write to a specified file
			
			for ( int index = 0; index < data.length; index++) { // outer loop
				
				for (int j = 0; j < data[index].length; j++) { // inner loop
					output.print(data[index][j] +  " "); // each double separated by a space
				}
				output.println(); // each row on a separate line
			}
			output.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	/*
	 * get average and totals methods up ahead
	 */
	
	/** Returns the total of all the elements of the two dimensional array
	 * 
	 * @param data
	 * @return total
	 * @author Jesus Lopez
	 */
	
	public static double getTotal(double[][] data) {
		
		double total = 0.0; // declare variable to hold total
		
		for(int row = 0; row < data.length; ++row) { // process the rows
			
			for (int column = 0; column < data[row].length; ++column) { // process the columns
			
				total += data[row][column];
			}
		}
		return total;
	}
	
	/**	Returns the average of the elements in the two dimensional array
	 * 
	 * @param data
	 * @return average
	 * @author Jesus Lopez
	 */
	
	public static double getAverage(double[][] data) {
		
		
		double average = 0.0;
		int quantityOfElements = 0;
		
		for(int row = 0; row <  data.length; ++row) {
			
			quantityOfElements+= data[row].length;
		}
		average = getTotal(data)/ (quantityOfElements); 
		return average;
	}
	
	/** Returns the total of the selected row in the two dimensional array
	 * 
	 * @param data
	 * @param row
	 * @return rowTotal
	 * @author Jesus Lopez
	 */
	
	public static double getRowTotal(double[][] data, int row) {
		
		double rowTotal = 0.0;
		for (int index = 0; index < data[row].length; ++index) {
			
			rowTotal += data[row][index];
		}
		return rowTotal;
	}
	
	/** Returns the total of the selected column in the two dimensional array
	 * 
	 * @param data
	 * @param col
	 * @return columnTotal
	 * @author Jesus Lopez
	 */

	public static double getColumnTotal(double[][] data, int col) {
		
		double columnTotal = 0.0;
		
		for (int index = 0; index < data.length; ++index) {
			if (col < data[index].length) { // to meet assignment requirements
				
				try {
					columnTotal += data[index][col];
				}
				catch (Exception e) {
					columnTotal = 0;  // to avoid issues with zero
				}
			}
		}
		return columnTotal;
	}
	
	/*
	 * Find Highest and Lowest methods, for rows and column ELEMENTS
	 */
	
	/** Returns the largest element of the selected row in the two dimensional array
	 * 
	 * @param data
	 * @param row
	 * @return highestInRow
	 * @author Jesus Lopez
	 */
	
	public static double getHighestInRow (double[][] data, int row) {
		
		double highestInRow = 0.0;
		
		for (int index = 0; index < data.length; index++) {
			if ( index== 0) {
				highestInRow = data[row][index];
			}
			else if (data[row][index] > highestInRow) {
				highestInRow = data[row][index];
			}
		}
		return highestInRow;
	}
	
	/** Returns the smallest element in the selected row in the two dimensional array
	 * 
	 * @param data
	 * @param row
	 * @return lowestInRow
	 * @author Jesus Lopez
	 */
	
	public static double getLowestInRow(double[][] data, int row) {
		
		double lowestInRow = 0.0;
		 for ( int index = 0; index < data[row].length; ++index) {
			 
			 if (index == 0) {
				 lowestInRow = data[row][index];
			 }
			 else if (data[row][index] < lowestInRow) {
				 lowestInRow = data[row][index];
			 }
		 }
		return lowestInRow;
	}
	
	/** Returns the largest element of the selected column in the two dimensional array
	 * 
	 * @param data
	 * @param col
	 * @return highestInColumn
	 * @author Jesus Lopez
	 */

public static double getHighestInColumn(double[][] data, int col) {
		
		double highestInColumn = 0.0;
		
		for (int row = 0; row < data.length; row++) { // goes to row
			
			if (col < data[row].length) { // test when row is ragged
			
					if (data[row][col]> highestInColumn) {
						highestInColumn = data[row][col]; 
					}
				}	
			}
		return highestInColumn;
	}
	/**
	 * 
	 * 
	 * @param data
	 * @param col
	 * @return lowestInColumn
	 * @author Jesus Lopez
	 */ 
	
	
	public static double getLowestInColumn(double[][] data, int col) {
		
		double lowestInColumn = Double.POSITIVE_INFINITY; // must be infinity because zero might well be a number in the column, yet some value is needed here
		
		for(int index=0;index < data.length; ++index) {
			
			if(col < data[index].length && data[index][col] < lowestInColumn) {
				lowestInColumn= data[index][col];
			}
		}	
		return lowestInColumn;
	}
	
	/*
	 * Methods to get the index of highest and lowest columns and rows, up ahead
	 */
	/** Return the index of the largest element in the specified row of the two dimensional array
	 * 
	 * @param data
	 * @param row
	 * @return	highestInRowIndex
	 * @ author Jesus Lopez
	 */
	
public static int getHighestInRowIndex(double[][] data, int row) {
		
		int highestInRowIndex = 0;
		double highestInRow = Double.NEGATIVE_INFINITY;
	
			for (int column = 0; column < data[row].length; column++) { // goes through column
		
					if (data[row][column]> highestInRow) {
						highestInRow = data[row][column]; 
						highestInRowIndex = column;
						
					}
		}
		return highestInRowIndex;
	}	
	/** Returns the index of the smallest element of the selected row in the two dimensional array
	 * 
	 * @param data
	 * @param row
	 * @return lowestInColumnIndex
	 * @ author Jesus Lopez
	 */
	
public static int getLowestInRowIndex(double[][] data, int row) {
	
	int lowestInRowIndex = 0;
	double lowestInRow = Double.POSITIVE_INFINITY;
	
	for (int column = 0; column < data[row].length; column++) { // goes through column
		
		if (data[row][column] < lowestInRow) {
			lowestInRow = data[row][column]; 
			lowestInRowIndex = column;
			
		}
	}
	return lowestInRowIndex;
	}
	/** Returns the index of the largest element of the selected column in the two dimensional array
	 * 
	 * @param data
	 * @param col
	 * @return highestInColumnIndex
	 * @author Jesus Lopez
	 */
	
	public static int getHighestInColumnIndex(double[][] data, int col){
		
		int highestInColumnIndex = -1; // intended to break things
		double highestInCoulmn = Double.NEGATIVE_INFINITY;
		
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
			
				if (data[row][col] > highestInCoulmn) {
				highestInCoulmn = data[row][col]; 
				highestInColumnIndex = row;
				}
			}
		}
		return highestInColumnIndex;
	}
	
	/** Returns the index of the smallest element of the selected column in the two dimensional array index
	 * 
	 * @param data
	 * @param col
	 * @return lowestInColumn
	 * @author Jesus Lopez
	 */
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		
		int lowestInColumnIndex = -1; // intended to break things
		double lowestInColumn = Double.POSITIVE_INFINITY;
		
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
			
				if (data[row][col] < lowestInColumn) {
				lowestInColumn = data[row][col]; 
				lowestInColumnIndex = row;
				}
			}
		}
		return lowestInColumnIndex;
	}
	
	/*
	 * Get high and lowest in array methods up ahead
	 */
	
	/**  Returns the largest element in the two dimensional array
	 * 
	 * @param data
	 * @return highestInArray
	 * @ author Jesus Lopez
	 */
	
	public static double getHighestInArray(double[][] data) {
		
		double highestInArray = 0.0;
		
		for(int index = 0; index < data.length; index++) { 
			
			for(int j = 0; j < data[index].length; j++){
				
				if(index==0 && j==0) {
					highestInArray= data[index][j];
				}	
				else if(data[index][j] > highestInArray) 
					highestInArray = data[index][j];
			}
		}
		return highestInArray;
	}
	
	/** Returns the smallest element in the two dimensional array
	 * 
	 * @param data
	 * @return lowestInArray
	 * @ Jesus Lopez
	 */
	
	public static double getLowestInArray(double[][] data) {
		
		double lowestInArray = 0.0;
		
		for(int index =0; index <data.length; index++){
			
			for (int j=0;j <data[index].length; j++) {
				
				if(index == 0 && j==0) {
					lowestInArray=data[index][j];
				}
				else if(data[index][j]<lowestInArray) {
					lowestInArray=data[index][j];
				}
			}
		}
		return lowestInArray;
	}
}