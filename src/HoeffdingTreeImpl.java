//I declare that this assignment is my own work and that all material previously written or published in any source by any other person has been duly acknowledged in the assignment. 
//I have not submitted this work, or a significant part thereof, previously as part of any academic program. 
//In submitting this assignment I give permission to copy it for assessment purposes only.
//Dakota C. Soares

//: src/HoeffdingTreeImpl.java

/***********************************************************************
 * COMP495 Project
 * Class: HoeffdingTreeImpl.java
 * 
 * Purpose: This contains the implementation for the Hoeffding Tree algorithm. The class directly interacts 
 * with the weka.jar external library. 
 * 
 * @author: Dakota Soares, and other sources. Sources are appropriately referenced in the comp495_cssc_app.docx. 
 * 
 * Student ID: 3318342
 * @date: July 14th, 2021 
 * 
 * Notes: see included documentation for test cases, parameters, etc. 
 */
//import needed packages
import weka.classifiers.trees.*; 
import weka.core.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HoeffdingTreeImpl 
{
	public Instances trainingData;
	
	//take a file name as input 
	public HoeffdingTreeImpl(String fileName) 
	{
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			//create a new training data object
			trainingData = new Instances(reader);
			//the training data is everything but the last attribute 
			trainingData.setClassIndex(trainingData.numAttributes() - 1);
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
	}
	
	//train the algorithm and provide it with the options needed to run
	HoeffdingTree performTraining() 
	{
		HoeffdingTree hoeff = new HoeffdingTree(); 
		
		String[] options = {"-L","2", "-S", "1", "-E", "1.0E-7","-H", "0.05", "-M", "0.01", "-G", "200.0", "-N", "0.0"};
		try {
		hoeff.setOptions(options);
		hoeff.buildClassifier(trainingData);
		} catch (Exception ex) {
		ex.printStackTrace();
		}
		return hoeff;
	}
	
	//get the test instances 
	public Instance getTestInstance(
			String biome, String colour, String predhorizon,
			String specialchars1, String soilprocess, double acidity, 
			double porosity, String consistency, double moisture, 
			double thickness, String organic, String carbonate) 
	{
			Instance instance = new DenseInstance(12);
			instance.setDataset(trainingData);
			instance.setValue(trainingData.attribute(0), biome);
			instance.setValue(trainingData.attribute(1), colour);
			instance.setValue(trainingData.attribute(2), predhorizon);
			instance.setValue(trainingData.attribute(3), specialchars1);
			instance.setValue(trainingData.attribute(4), soilprocess);
			instance.setValue(trainingData.attribute(5), acidity);
			instance.setValue(trainingData.attribute(6), porosity);
			instance.setValue(trainingData.attribute(7), consistency);
			instance.setValue(trainingData.attribute(8), moisture);
			instance.setValue(trainingData.attribute(9), thickness);
			instance.setValue(trainingData.attribute(10), organic);
			instance.setValue(trainingData.attribute(11), carbonate);
			return instance;
	}
//end of file HoeffdingTreeImpl.java
}