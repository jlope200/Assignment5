package assignment5;



import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	
	
	private double[][] dataSetSTUDENT = {{-14,2,3},
										{10,5}, 	
										{6,7,9}}; 
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT);
		double result = TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT);
		assertEquals(28.0, result,.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT);
		double result = TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT);
		assertEquals(3.5, result,.001);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 0);
		double result = TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 0);
		assertEquals(-9, result,.001);
	}

	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
	double result = TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 0);
	assertEquals(2, result,.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
	double result = TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT);	
	assertEquals(10, result,.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
	}

}
