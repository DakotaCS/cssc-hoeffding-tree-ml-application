//: src/HoeffdingTreeImpl.java

/***********************************************************************
 * Class: HoeffdingTreeImpl.java
 * 
 * Purpose: This contains the implementation for the Hoeffding Tree algorithm. The class directly interacts 
 * with the weka.jar external library. 
 * 
 * @author: Dakota Soares, and other sources. Sources are appropriately referenced in the comp495_cssc_app.docx. 

 * @date: July 14th, 2021 
 * 
 * Notes: see included documentation for test cases, parameters, etc. 
 */

//import required packages
import weka.classifiers.trees.*; 
import weka.core.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 *	Create a HoeffdingTreeImpl object 
 */
public class HoeffdingTreeImpl 
{
	//create a public instances object
	public Instances trainingData;
	
	//take a file name as input and try the following
	public HoeffdingTreeImpl(String fileName) 
	{
		try 
		{
			//create a BufferedReader
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			//create a new training data object
			trainingData = new Instances(reader);
			//the training data is everything but the last attribute 
			trainingData.setClassIndex(trainingData.numAttributes() - 1);
		} 
		//print any errors that may occur
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
	}
	
	//train the algorithm and provide it with the options needed to run
	HoeffdingTree performTraining() 
	{
		//Create a new hoeffding tree
		HoeffdingTree hoeff = new HoeffdingTree(); 
		
		//initialize it with the following options. These options and what they stand for can be found in detail here: 
		//https://weka.sourceforge.io/doc.dev/weka/classifiers/trees/HoeffdingTree.html
		String[] options = {"-L","2", "-S", "1", "-E", "1.0E-7","-H", "0.05", "-M", "0.01", "-G", "200.0", "-N", "0.0"};
		
		//try to create the algorithm using the training data and options provided
		try 
		{
			hoeff.setOptions(options);
			hoeff.buildClassifier(trainingData);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		return hoeff;
	}
	
	//get the test instances 
	public Instance getTestInstance
	(
			String biome, String colour, String predhorizon,
			String specialchars1, String soilprocess, double acidity, 
			double porosity, String consistency, double moisture, 
			double thickness, String organic, String carbonate) 
	{
			//We use the 13th instance as the instance were testing for, so it is not included
			//in the list of instances we send to the algorithm
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