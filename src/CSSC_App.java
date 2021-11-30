//I declare that this assignment is my own work and that all material previously written or published in any source by any other person has been duly acknowledged in the assignment. 
//I have not submitted this work, or a significant part thereof, previously as part of any academic program. 
//In submitting this assignment I give permission to copy it for assessment purposes only.
//Dakota C. Soares

//: src/CSSC_App.java

/***********************************************************************
 * COMP495 Project
 * Class: CSSC_App.java
 * 
 * Purpose: This contains the main() method that is the starting point of the CSSC Application 
 * 
 * @author: Dakota Soares, and other sources. Sources are appropriately referenced in the comp495_cssc_app.docx. 
 * 
 * Student ID: 3318342
 * @date: July 14th, 2021 
 * 
 * Notes: see included documentation for test cases, parameters, etc. 
 */
//import needed packages
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//NOTE: Weka-3-8-5 must be installed in C:\Program Files and properly referenced. 
import weka.classifiers.trees.*; 
import weka.core.*;
import weka.core.converters.ConverterUtils.DataSource;

public class CSSC_App 
{
	//eol
	public String end1 = "\n"; 
	//text fields
	private JFrame frmGeoClassifyCssc;
	private JTextField porosity;
	private JTextField thickness;
	private JTextField moisture;
	private JTextField acidity;
	JTextArea textArea = new JTextArea();
	ArrayList<String> greatgroups = new ArrayList<String>(); 
	//combo boxes
	private JComboBox<String> biome = new JComboBox<String>(); 
	private JComboBox<String> soil = new JComboBox<String>();
	private JComboBox<String> horizon = new JComboBox<String>();
	private JComboBox<String> specialchar1 = new JComboBox<String>();
	private JComboBox<String> soil_forming = new JComboBox<String>();
	private JComboBox<String> organic = new JComboBox<String>();
	private JComboBox<String> carbonate = new JComboBox<String>();
	private JComboBox<String> consistency = new JComboBox<String>();
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CSSC_App window = new CSSC_App();
					window.frmGeoClassifyCssc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CSSC_App() 
	{
		initialize();
		
		//add the great groups to the arraylist
		greatgroups.add("none"); 
		greatgroups.add("gray-brown"); 
		greatgroups.add("gray"); 
		greatgroups.add("melanic"); 
		greatgroups.add("eutric");
		greatgroups.add("sombric"); 
		greatgroups.add("dystric"); 
		greatgroups.add("brown"); 
		greatgroups.add("dark-brown"); 
		greatgroups.add("black"); 
		greatgroups.add("dark-gray"); 
		greatgroups.add("turbic"); 
		greatgroups.add("static"); 
		greatgroups.add("organic");
		greatgroups.add("luvic");
		greatgroups.add("humic_1"); 
		greatgroups.add("gleysol");
		greatgroups.add("fibrisol");
		greatgroups.add("mesisol");
		greatgroups.add("humisol");
		greatgroups.add("folisol");
		greatgroups.add("humic_2");
		greatgroups.add("ferro-humic");
		greatgroups.add("humo-ferric");
		greatgroups.add("vertisol");
		greatgroups.add("humic_3");
		greatgroups.add("regosol");
		greatgroups.add("humic_4");
		greatgroups.add("solonetz");
		greatgroups.add("solodized");
		greatgroups.add("solod");
		greatgroups.add("vertic");
		
		//add items to the combo boxes 
		biome.addItem("decidious-forest"); biome.addItem("coniferous-forest"); biome.addItem("hot-desert");
		biome.addItem("cold-desert"); biome.addItem("wetland"); biome.addItem("plains");
		biome.addItem("pond"); biome.addItem("lacustrine");
		
		soil.addItem("no"); soil.addItem("gray"); soil.addItem("brown"); soil.addItem("dark-brown"); soil.addItem("brown-orange");
		soil.addItem("black"); soil.addItem("gray-brown"); soil.addItem("yellow"); soil.addItem("yellow-black"); soil.addItem("yellow-brown");
		soil.addItem("gray-black"); soil.addItem("red-brown");
		
		horizon.addItem("no"); horizon.addItem("Om"); horizon.addItem("O"); horizon.addItem("Of"); horizon.addItem("B");
		horizon.addItem("Ae"); horizon.addItem("Bf"); horizon.addItem("Ah"); horizon.addItem("Bh"); horizon.addItem("Bhf");
		horizon.addItem("Btg"); horizon.addItem("Ah-Ap"); horizon.addItem("any");
		
		specialchar1.addItem("no"); specialchar1.addItem("fibric"); specialchar1.addItem("cryoturbated"); specialchar1.addItem("organic");
		specialchar1.addItem("gleyed"); specialchar1.addItem("mineral"); specialchar1.addItem("warm-soil"); specialchar1.addItem("clay-enriched");
		specialchar1.addItem("slickenslide");
		
		soil_forming.addItem("eluvial"); soil_forming.addItem("alluvial"); soil_forming.addItem("eolian"); soil_forming.addItem("volcanic");
		soil_forming.addItem("glacial"); soil_forming.addItem("climatic"); soil_forming.addItem("biogenic");
		
		organic.addItem("no"); organic.addItem("yes"); organic.addItem("yes-semi-decomposed"); organic.addItem("yes-decomposed");
		
		carbonate.addItem("no"); carbonate.addItem("yes");
		
		consistency.addItem("fine"); consistency.addItem("semi-fine"); consistency.addItem("semi-coarse"); consistency.addItem("coarse");
	} 
	
	/**
	 * Takes a soil great group as input and outputs the soil order
	 */
	public String OrderClassification(String greatgroup)
	{ 	
		if (greatgroup.contains("gray-brown")|| greatgroup.contains("gray"))
		{
			return "Luvisol" + end1 + "Main Characteristics: " + end1
			+ "Found in forested landscapes underlain by loamy tills derived \nfrom underlying sedimentary rock or clayey lacustrine"
			+ " deposits. \nParent materials include calcium and magneisum.\n Neutral/alkaline pH."; 
		}
		if (greatgroup.contains("melanic") || greatgroup.contains("eutric")
				 || greatgroup.contains("sombric")  || greatgroup.contains("dystric"))
		{
			return "Brunisol" + end1 + "Main Characteristics: " + end1
					+ "Found in forested landscapes that are not Podzols or Luvisols. \nAn evolutionary soil type found in drier conditions,"
					+ "\n and cool temperatures. Parent material may be igneous.\n Moderate/High acidic pH.";  
		}
		if (greatgroup.contains("brown") || greatgroup.contains("dark-brown")
				 || greatgroup.contains("black")  || greatgroup.contains("dark-gray"))
		{
			return "Chernozemic" + end1 + "Main Characteristics: " + end1
					+ "Found in praire landscapes with some organic matter. \n"
					+ "A darker soil type found in drier conditions, \n"
					+ "and cool temperatures. Parent material may be coarse sand/silt.\n "
					+ "Slight/Moderate acidic pH.";
		}
		if (greatgroup.contains("turbic") || greatgroup.contains("static")
				 || greatgroup.contains("organic"))
		{
			return "Cryosol" + end1 + "Main Characteristics: " + end1
					+ "Found in tundra landscapes with permafrost. \n"
					+ "A soil type found in dry conditions, \n"
					+ "and cold temperatures. Parent material may be fine clay/sand/silt.\n "
					+ "various levels of acidity.";
		}
		if (greatgroup.contains("luvic") || greatgroup.contains("humic_1")
				 || greatgroup.contains("gleysol"))
		{
			return "Gleysol" + end1 + "Main Characteristics: " + end1
					+ "Found in grassland/lowland landscapes with anaerobic conditions. \n"
					+ "A soil type found in watery conditions, \n"
					+ "and mild temperatures. Parent material may be organic/peat.\n "
					+ "Moderate/High acidic pH.";
		}
		if (greatgroup.contains("fibrisol") || greatgroup.contains("mesisol")
				 || greatgroup.contains("humisol")  || greatgroup.contains("folisol"))
		{
			return "Organic" + end1 + "Main Characteristics: " + end1
					+ "Found in forested/wetland landscapes with heavy organic matter. \n"
					+ "A dark soil type found in wet conditions, \n"
					+ "and variant temperatures. Parent material is fribric to humic organic matter.\n "
					+ "Moderate/High acidic pH.";
		}
		if (greatgroup.contains("humic_2") || greatgroup.contains("ferro-humic")
				 || greatgroup.contains("humo-ferric"))
		{
			return "Podzol" + end1 + "Main Characteristics: " + end1
					+ "Found in sandy landscapes (Canadian Shield) with glacial deposits. \n"
					+ "A light soil type found in wet conditions, \n"
					+ "and cold temperatures. Parent material is igneous.\n "
					+ "Moderate acidic pH."; 
		}
		if (greatgroup.contains("humic_3") || greatgroup.contains("vertisol"))
		{
			return "Vertisol" + end1 + "Main Characteristics: " + end1
					+ "Found in praire landscapes with lacustrine deposits. \n"
					+ "A light soil type found in dry conditions, \n"
					+ "and variable temperatures. Parent material is clay/sand.\n "
					+ "Slightly acidic pH."; 
		}
		if (greatgroup.contains("regosol") || greatgroup.contains("humic_3"))
		{
			return "Regosol" + end1 + "Main Characteristics: " + end1
					+ "Found in every landscape. Characterized by no B horizon. \n"
					+ "A variable soil type found in unstable conditions, \n"
					+ "and variable temperatures. Parent material is variable\n "
					+ "Slightly acidic pH.";  
		}
		if (greatgroup.contains("solonetz") || greatgroup.contains("solodized")
				 || greatgroup.contains("solod")  || greatgroup.contains("vertic"))
		{
			return "Solonetz" + end1 + "Main Characteristics: " + end1
					+ "Found in praire landscapes with some organic matter. \n"
					+ "Differs from Chernozemic due to high sodium. \n"
					+ "A darker soil type found in drier conditions, \n"
					+ "and cool temperatures. Parent material may be coarse sand/silt.\n "
					+ "Slight/Moderate acidic pH. Absent Ae horizon.";
		}
		else
			return "none"; 
	}
	
	/**
	 * Calls the Hoeffding Algorithm and calculates the great group
	 */
	public void calculate()
	{
		//clear the text area
		textArea.setText("");
		//get data from the combo boxes
		String biomeInput = (String) biome.getSelectedItem(); 
		String soilColour = (String) soil.getSelectedItem(); 
		String predHorizon = (String) horizon.getSelectedItem(); 
		String specialchar = (String) specialchar1.getSelectedItem(); 
		String soilProcess = (String) soil_forming.getSelectedItem(); 
		//get the acidity
		String acidityInput = acidity.getText(); 
		double acidityInt = -1; 
		//try the following to extract a number for the acidity
		try 
		{
			//parse the string 
			acidityInt = Double.parseDouble(acidityInput); 
			//make sure the value is in range of the pH scale
			if (acidityInt < 0 || acidityInt > 14)
			{
				throw new NumberFormatException(); 
			}
		}
		catch(NumberFormatException ex)
		{
			ex.printStackTrace();
			textArea.append("Error: Acidity Value incorrect." + end1);
		}
		//try the following to get the porosity
		String porosityInput = porosity.getText(); 
		double porosityInt = -1; 
		try 
		{
			//parse the string
			porosityInt = Double.parseDouble(porosityInput); 
			//ensure the value is in range 
			if (porosityInt < 0 || porosityInt > 100)
			{
				throw new NumberFormatException(); 
			}
		}
		catch(NumberFormatException ex)
		{
			ex.printStackTrace();
			textArea.append("Error: Porosity Value incorrect." + end1);
		}
		
		//get the soil consistency
		String consistencyInput = (String) consistency.getSelectedItem(); 
		//try the following to get the moisture of the soil
		String moistureInput = moisture.getText(); 
		double moistureDouble = 0; 
		try 
		{
			//try to parse the string
			moistureDouble = Double.parseDouble(moistureInput); 
			//ensure the value is in range 
			if (moistureDouble < 0.25 || moistureDouble > 2.50)
			{
				throw new NumberFormatException(); 
			}
		}
		catch(NumberFormatException ex)
		{
			ex.printStackTrace();
			textArea.append("Error: Moisture Value incorrect." + end1);
		}
		//get the thickness
		String thicknessInput = thickness.getText(); 
		double thicknessDouble = 0; 
		try 
		{
			//try to parse the string
			thicknessDouble = Double.parseDouble(thicknessInput); 
			//ensure the value is in range 
			if (thicknessDouble < 0.00 || thicknessDouble > 75.00)
			{
				throw new NumberFormatException(); 
			}
		}
		catch(NumberFormatException ex)
		{
			ex.printStackTrace();
			textArea.append("Error: Thickness Value incorrect." + end1);
		}
		//get the organic and carbonate inputs 
		String organicInput = (String) organic.getSelectedItem(); 
		String carbonateInput = (String) carbonate.getSelectedItem(); 
		
		try
		{
		  //get the source of the database 
	      DataSource source = new DataSource("src/dataset_full_compiled_rev_June29.arff");
	      Instances train = source.getDataSet();
	      train.setClassIndex(12);  
	      //build model
	      HoeffdingTree model = new HoeffdingTree(); 
	      //train the classifier 
	      model.buildClassifier(train);
	      //create a new decision tree and import the dataset 
	      HoeffdingTreeImpl decisionTree = new HoeffdingTreeImpl("src/dataset_full_compiled_rev_June29.arff"); 
			HoeffdingTree tree = decisionTree.performTraining(); 
			
			System.out.println(tree.toString());
			//get the test instances 
			Instance testInstance1 = decisionTree.getTestInstance(biomeInput, soilColour, predHorizon, specialchar, soilProcess, 
					acidityInt, porosityInt, consistencyInput, moistureDouble, thicknessDouble, 
					organicInput, carbonateInput); 
				
					//get the result 
					int result = (int) tree.classifyInstance(testInstance1);
					String results = decisionTree.trainingData.attribute(12).value(result);
					String order = OrderClassification(results); 
					textArea.append("Hoeffding Tree (VFDT). Split Confidence: 1.0E-7. Split Criteria: Info Gain Split." + end1);
					textArea.append("Leaf Prediction Strategy: Naive Bayes Adaptive." + end1);
					textArea.append("Great Group: " + results + " : " + "Soil Order: " + order + end1);
					
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 * The below is auto-generated 
	 */
	private void initialize() 
	{
		
		frmGeoClassifyCssc = new JFrame();
		frmGeoClassifyCssc.setResizable(false);
		frmGeoClassifyCssc.setTitle("Geo Classify CSSC Soil Classification System");
		frmGeoClassifyCssc.setBounds(100, 100, 775, 425);
		frmGeoClassifyCssc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmGeoClassifyCssc.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSaveResult = new JMenuItem("Save Result");
		mntmSaveResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//write the result of the text area to a file 
				String data = textArea.getText().trim(); 
				try 
				{
					PrintWriter out = new PrintWriter("cssc_result.txt");
					
					if (!data.equals(""))
					{
						out.println(textArea.getText()); 
						textArea.setText("");
						textArea.setText("File saved as: cssc_result.txt. ");
					}
					else
					{
						textArea.setText("");
						textArea.setText("Result not saved.");
					}
					out.close(); 
				} 
				catch (FileNotFoundException e1) 
				{
					textArea.setText("");
					textArea.setText("Result not saved.");
					e1.printStackTrace();
				} 	
			}
		});
		mnFile.add(mntmSaveResult);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		mntmReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//just resets each item in the main GUI
				biome.setSelectedIndex(0);
				soil.setSelectedIndex(0);
				horizon.setSelectedIndex(0);
				specialchar1.setSelectedIndex(0);
				soil_forming.setSelectedIndex(0);
				acidity.setText("");
				moisture.setText("");
				thickness.setText("");
				organic.setSelectedIndex(0);
				carbonate.setSelectedIndex(0);
			}
		});
		mnOptions.add(mntmReset);
		
		JMenuItem mntmCalculate = new JMenuItem("Calculate");
		mntmCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				calculate(); 
			}
		});
		mnOptions.add(mntmCalculate);
		
		JMenu mnInformation = new JMenu("Information");
		menuBar.add(mnInformation);
		
		JMenuItem mntmAstmInformation = new JMenuItem("ASTM Information");
		mntmAstmInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							astm window = new astm();
							window.frmAstmInformation.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		mnInformation.add(mntmAstmInformation);
		
		JMenuItem mntmCsscResources = new JMenuItem("CSSC Resources");
		mntmCsscResources.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							cssc window = new cssc();
							window.frmCsscResources.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}); 
			}
		});
		mnInformation.add(mntmCsscResources);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelpDocumentation = new JMenuItem("Help Documentation");
		mntmHelpDocumentation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Help Documentation for the application would go here.");
			}
		});
		mnHelp.add(mntmHelpDocumentation);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				biome.setSelectedIndex(0);
				soil.setSelectedIndex(0);
				horizon.setSelectedIndex(0);
				specialchar1.setSelectedIndex(0);
				soil_forming.setSelectedIndex(0);
				acidity.setText("");
				moisture.setText("");
				thickness.setText("");
				organic.setSelectedIndex(0);
				carbonate.setSelectedIndex(0);
			}
		});
		menuBar.add(btnReset);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 44, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmGeoClassifyCssc.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblStep = new JLabel("Step 1: ");
		GridBagConstraints gbc_lblStep = new GridBagConstraints();
		gbc_lblStep.fill = GridBagConstraints.VERTICAL;
		gbc_lblStep.anchor = GridBagConstraints.WEST;
		gbc_lblStep.insets = new Insets(0, 0, 5, 5);
		gbc_lblStep.gridx = 1;
		gbc_lblStep.gridy = 0;
		frmGeoClassifyCssc.getContentPane().add(lblStep, gbc_lblStep);
		
		JLabel lblNewLabel_1 = new JLabel("Step 8: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 0;
		frmGeoClassifyCssc.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Choose a biome:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frmGeoClassifyCssc.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		
		GridBagConstraints gbc_biome = new GridBagConstraints();
		gbc_biome.insets = new Insets(0, 0, 5, 5);
		gbc_biome.fill = GridBagConstraints.HORIZONTAL;
		gbc_biome.gridx = 3;
		gbc_biome.gridy = 1;
		frmGeoClassifyCssc.getContentPane().add(biome, gbc_biome);
		
		JLabel lblStep_1 = new JLabel("Pick the consistency:");
		GridBagConstraints gbc_lblStep_1 = new GridBagConstraints();
		gbc_lblStep_1.anchor = GridBagConstraints.EAST;
		gbc_lblStep_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStep_1.gridx = 5;
		gbc_lblStep_1.gridy = 1;
		frmGeoClassifyCssc.getContentPane().add(lblStep_1, gbc_lblStep_1);
		
		GridBagConstraints gbc_consistency = new GridBagConstraints();
		gbc_consistency.insets = new Insets(0, 0, 5, 5);
		gbc_consistency.fill = GridBagConstraints.HORIZONTAL;
		gbc_consistency.gridx = 7;
		gbc_consistency.gridy = 1;
		frmGeoClassifyCssc.getContentPane().add(consistency, gbc_consistency);
		
		JLabel lblStep_2 = new JLabel("Step 2: ");
		GridBagConstraints gbc_lblStep_2 = new GridBagConstraints();
		gbc_lblStep_2.anchor = GridBagConstraints.WEST;
		gbc_lblStep_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblStep_2.gridx = 1;
		gbc_lblStep_2.gridy = 3;
		frmGeoClassifyCssc.getContentPane().add(lblStep_2, gbc_lblStep_2);
		
		JLabel lblStep_8 = new JLabel("Step 9: ");
		GridBagConstraints gbc_lblStep_8 = new GridBagConstraints();
		gbc_lblStep_8.anchor = GridBagConstraints.WEST;
		gbc_lblStep_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblStep_8.gridx = 5;
		gbc_lblStep_8.gridy = 3;
		frmGeoClassifyCssc.getContentPane().add(lblStep_8, gbc_lblStep_8);
		
		JLabel lblChooseASoil = new JLabel("Choose a soil colour:");
		GridBagConstraints gbc_lblChooseASoil = new GridBagConstraints();
		gbc_lblChooseASoil.anchor = GridBagConstraints.EAST;
		gbc_lblChooseASoil.insets = new Insets(0, 0, 5, 5);
		gbc_lblChooseASoil.gridx = 1;
		gbc_lblChooseASoil.gridy = 4;
		frmGeoClassifyCssc.getContentPane().add(lblChooseASoil, gbc_lblChooseASoil);
		
		GridBagConstraints gbc_soil = new GridBagConstraints();
		gbc_soil.insets = new Insets(0, 0, 5, 5);
		gbc_soil.fill = GridBagConstraints.HORIZONTAL;
		gbc_soil.gridx = 3;
		gbc_soil.gridy = 4;
		frmGeoClassifyCssc.getContentPane().add(soil, gbc_soil);
		
		JLabel lblPickTheMoisture = new JLabel("Pick the moisture level:");
		GridBagConstraints gbc_lblPickTheMoisture = new GridBagConstraints();
		gbc_lblPickTheMoisture.anchor = GridBagConstraints.EAST;
		gbc_lblPickTheMoisture.insets = new Insets(0, 0, 5, 5);
		gbc_lblPickTheMoisture.gridx = 5;
		gbc_lblPickTheMoisture.gridy = 4;
		frmGeoClassifyCssc.getContentPane().add(lblPickTheMoisture, gbc_lblPickTheMoisture);
		
		moisture = new JTextField();
		moisture.setToolTipText("Measured in Inches/Foot of depth as available water capacity.");
		GridBagConstraints gbc_moisture = new GridBagConstraints();
		gbc_moisture.insets = new Insets(0, 0, 5, 5);
		gbc_moisture.fill = GridBagConstraints.HORIZONTAL;
		gbc_moisture.gridx = 7;
		gbc_moisture.gridy = 4;
		frmGeoClassifyCssc.getContentPane().add(moisture, gbc_moisture);
		moisture.setColumns(10);
		
		
		JLabel lblStep_3 = new JLabel("Step 3: ");
		GridBagConstraints gbc_lblStep_3 = new GridBagConstraints();
		gbc_lblStep_3.anchor = GridBagConstraints.WEST;
		gbc_lblStep_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblStep_3.gridx = 1;
		gbc_lblStep_3.gridy = 6;
		frmGeoClassifyCssc.getContentPane().add(lblStep_3, gbc_lblStep_3);
		
		JLabel lblStep_9 = new JLabel("Step 10:");
		GridBagConstraints gbc_lblStep_9 = new GridBagConstraints();
		gbc_lblStep_9.anchor = GridBagConstraints.WEST;
		gbc_lblStep_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblStep_9.gridx = 5;
		gbc_lblStep_9.gridy = 6;
		frmGeoClassifyCssc.getContentPane().add(lblStep_9, gbc_lblStep_9);
		
		JLabel lblNewLabel_2 = new JLabel("Choose the Predominant Horizon:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 7;
		frmGeoClassifyCssc.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		GridBagConstraints gbc_horizon = new GridBagConstraints();
		gbc_horizon.insets = new Insets(0, 0, 5, 5);
		gbc_horizon.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizon.gridx = 3;
		gbc_horizon.gridy = 7;
		frmGeoClassifyCssc.getContentPane().add(horizon, gbc_horizon);
		
		JLabel lblPickTheThickness = new JLabel("Pick the thickness:");
		lblPickTheThickness.setToolTipText(" (predominant horizon only)");
		GridBagConstraints gbc_lblPickTheThickness = new GridBagConstraints();
		gbc_lblPickTheThickness.anchor = GridBagConstraints.EAST;
		gbc_lblPickTheThickness.insets = new Insets(0, 0, 5, 5);
		gbc_lblPickTheThickness.gridx = 5;
		gbc_lblPickTheThickness.gridy = 7;
		frmGeoClassifyCssc.getContentPane().add(lblPickTheThickness, gbc_lblPickTheThickness);
		
		thickness = new JTextField();
		thickness.setToolTipText("Measured in centimetres of the predominant horizon.");
		GridBagConstraints gbc_thickness = new GridBagConstraints();
		gbc_thickness.insets = new Insets(0, 0, 5, 5);
		gbc_thickness.fill = GridBagConstraints.HORIZONTAL;
		gbc_thickness.gridx = 7;
		gbc_thickness.gridy = 7;
		frmGeoClassifyCssc.getContentPane().add(thickness, gbc_thickness);
		thickness.setColumns(10);
		
		JLabel lblStep_4 = new JLabel("Step 4: ");
		GridBagConstraints gbc_lblStep_4 = new GridBagConstraints();
		gbc_lblStep_4.anchor = GridBagConstraints.WEST;
		gbc_lblStep_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblStep_4.gridx = 1;
		gbc_lblStep_4.gridy = 9;
		frmGeoClassifyCssc.getContentPane().add(lblStep_4, gbc_lblStep_4);
		
		JLabel lblStep_10 = new JLabel("Step 11:");
		GridBagConstraints gbc_lblStep_10 = new GridBagConstraints();
		gbc_lblStep_10.anchor = GridBagConstraints.WEST;
		gbc_lblStep_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblStep_10.gridx = 5;
		gbc_lblStep_10.gridy = 9;
		frmGeoClassifyCssc.getContentPane().add(lblStep_10, gbc_lblStep_10);
		
		JLabel lblPickASpecial = new JLabel("Pick a special characteristic:");
		GridBagConstraints gbc_lblPickASpecial = new GridBagConstraints();
		gbc_lblPickASpecial.anchor = GridBagConstraints.EAST;
		gbc_lblPickASpecial.insets = new Insets(0, 0, 5, 5);
		gbc_lblPickASpecial.gridx = 1;
		gbc_lblPickASpecial.gridy = 10;
		frmGeoClassifyCssc.getContentPane().add(lblPickASpecial, gbc_lblPickASpecial);
		
		GridBagConstraints gbc_specialchar1 = new GridBagConstraints();
		gbc_specialchar1.insets = new Insets(0, 0, 5, 5);
		gbc_specialchar1.fill = GridBagConstraints.HORIZONTAL;
		gbc_specialchar1.gridx = 3;
		gbc_specialchar1.gridy = 10;
		frmGeoClassifyCssc.getContentPane().add(specialchar1, gbc_specialchar1);
		
		JLabel lblPickTheOrganic = new JLabel("Pick the organic content:");
		GridBagConstraints gbc_lblPickTheOrganic = new GridBagConstraints();
		gbc_lblPickTheOrganic.anchor = GridBagConstraints.EAST;
		gbc_lblPickTheOrganic.insets = new Insets(0, 0, 5, 5);
		gbc_lblPickTheOrganic.gridx = 5;
		gbc_lblPickTheOrganic.gridy = 10;
		frmGeoClassifyCssc.getContentPane().add(lblPickTheOrganic, gbc_lblPickTheOrganic);
		
		GridBagConstraints gbc_organic = new GridBagConstraints();
		gbc_organic.insets = new Insets(0, 0, 5, 5);
		gbc_organic.fill = GridBagConstraints.HORIZONTAL;
		gbc_organic.gridx = 7;
		gbc_organic.gridy = 10;
		frmGeoClassifyCssc.getContentPane().add(organic, gbc_organic);
		
		JLabel lblStep_5 = new JLabel("Step 5: ");
		GridBagConstraints gbc_lblStep_5 = new GridBagConstraints();
		gbc_lblStep_5.anchor = GridBagConstraints.WEST;
		gbc_lblStep_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblStep_5.gridx = 1;
		gbc_lblStep_5.gridy = 12;
		frmGeoClassifyCssc.getContentPane().add(lblStep_5, gbc_lblStep_5);
		
		JLabel lblStep_11 = new JLabel("Step 12: ");
		GridBagConstraints gbc_lblStep_11 = new GridBagConstraints();
		gbc_lblStep_11.anchor = GridBagConstraints.WEST;
		gbc_lblStep_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblStep_11.gridx = 5;
		gbc_lblStep_11.gridy = 12;
		frmGeoClassifyCssc.getContentPane().add(lblStep_11, gbc_lblStep_11);
		
		
		JLabel lblPickTheSoil = new JLabel("Pick the soil forming process:");
		GridBagConstraints gbc_lblPickTheSoil = new GridBagConstraints();
		gbc_lblPickTheSoil.anchor = GridBagConstraints.EAST;
		gbc_lblPickTheSoil.insets = new Insets(0, 0, 5, 5);
		gbc_lblPickTheSoil.gridx = 1;
		gbc_lblPickTheSoil.gridy = 13;
		frmGeoClassifyCssc.getContentPane().add(lblPickTheSoil, gbc_lblPickTheSoil);
		
		GridBagConstraints gbc_soil_forming = new GridBagConstraints();
		gbc_soil_forming.insets = new Insets(0, 0, 5, 5);
		gbc_soil_forming.fill = GridBagConstraints.HORIZONTAL;
		gbc_soil_forming.gridx = 3;
		gbc_soil_forming.gridy = 13;
		frmGeoClassifyCssc.getContentPane().add(soil_forming, gbc_soil_forming);
		
		JLabel lblDoesTheSoil = new JLabel("Does the soil contain carbonates:");
		GridBagConstraints gbc_lblDoesTheSoil = new GridBagConstraints();
		gbc_lblDoesTheSoil.anchor = GridBagConstraints.EAST;
		gbc_lblDoesTheSoil.insets = new Insets(0, 0, 5, 5);
		gbc_lblDoesTheSoil.gridx = 5;
		gbc_lblDoesTheSoil.gridy = 13;
		frmGeoClassifyCssc.getContentPane().add(lblDoesTheSoil, gbc_lblDoesTheSoil);
		carbonate.setToolTipText("The soil will react to HCI (Hydrochloric acid).");
		
		GridBagConstraints gbc_carbonate = new GridBagConstraints();
		gbc_carbonate.insets = new Insets(0, 0, 5, 5);
		gbc_carbonate.fill = GridBagConstraints.HORIZONTAL;
		gbc_carbonate.gridx = 7;
		gbc_carbonate.gridy = 13;
		frmGeoClassifyCssc.getContentPane().add(carbonate, gbc_carbonate);
		
		JLabel lblStep_6 = new JLabel("Step 6: ");
		GridBagConstraints gbc_lblStep_6 = new GridBagConstraints();
		gbc_lblStep_6.anchor = GridBagConstraints.WEST;
		gbc_lblStep_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblStep_6.gridx = 1;
		gbc_lblStep_6.gridy = 15;
		frmGeoClassifyCssc.getContentPane().add(lblStep_6, gbc_lblStep_6);
		
		JLabel lblResult = new JLabel("Result:");
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.anchor = GridBagConstraints.WEST;
		gbc_lblResult.insets = new Insets(0, 0, 5, 5);
		gbc_lblResult.gridx = 5;
		gbc_lblResult.gridy = 15;
		frmGeoClassifyCssc.getContentPane().add(lblResult, gbc_lblResult);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				calculate(); 
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 7;
		gbc_btnNewButton.gridy = 15;
		frmGeoClassifyCssc.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblPickTheAcidity = new JLabel("Pick the acidity level:");
		GridBagConstraints gbc_lblPickTheAcidity = new GridBagConstraints();
		gbc_lblPickTheAcidity.anchor = GridBagConstraints.EAST;
		gbc_lblPickTheAcidity.insets = new Insets(0, 0, 5, 5);
		gbc_lblPickTheAcidity.gridx = 1;
		gbc_lblPickTheAcidity.gridy = 16;
		frmGeoClassifyCssc.getContentPane().add(lblPickTheAcidity, gbc_lblPickTheAcidity);
		
		acidity = new JTextField();
		acidity.setToolTipText("Enter an integer between 0 and 14.");
		GridBagConstraints gbc_acidity = new GridBagConstraints();
		gbc_acidity.insets = new Insets(0, 0, 5, 5);
		gbc_acidity.fill = GridBagConstraints.HORIZONTAL;
		gbc_acidity.gridx = 3;
		gbc_acidity.gridy = 16;
		frmGeoClassifyCssc.getContentPane().add(acidity, gbc_acidity);
		acidity.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 5;
		gbc_scrollPane.gridy = 16;
		frmGeoClassifyCssc.getContentPane().add(scrollPane, gbc_scrollPane);
		
		scrollPane.setViewportView(textArea);
		
		JLabel lblStep_7 = new JLabel("Step 7: ");
		GridBagConstraints gbc_lblStep_7 = new GridBagConstraints();
		gbc_lblStep_7.anchor = GridBagConstraints.WEST;
		gbc_lblStep_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblStep_7.gridx = 1;
		gbc_lblStep_7.gridy = 18;
		frmGeoClassifyCssc.getContentPane().add(lblStep_7, gbc_lblStep_7);
		
		JLabel lblPickThePorosity = new JLabel("Pick the porosity:");
		GridBagConstraints gbc_lblPickThePorosity = new GridBagConstraints();
		gbc_lblPickThePorosity.anchor = GridBagConstraints.EAST;
		gbc_lblPickThePorosity.insets = new Insets(0, 0, 0, 5);
		gbc_lblPickThePorosity.gridx = 1;
		gbc_lblPickThePorosity.gridy = 19;
		frmGeoClassifyCssc.getContentPane().add(lblPickThePorosity, gbc_lblPickThePorosity);
		
		porosity = new JTextField();
		GridBagConstraints gbc_porosity = new GridBagConstraints();
		gbc_porosity.insets = new Insets(0, 0, 0, 5);
		gbc_porosity.fill = GridBagConstraints.HORIZONTAL;
		gbc_porosity.gridx = 3;
		gbc_porosity.gridy = 19;
		frmGeoClassifyCssc.getContentPane().add(porosity, gbc_porosity);
		porosity.setColumns(10);
	}
//end of file CSSC_App.java
}