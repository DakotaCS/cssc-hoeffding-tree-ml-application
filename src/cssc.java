//: src/cssc.java

/***********************************************************************
 * Class: cssc.java
 * 
 * Purpose: This contains the cssc resources window for the CSSC application. 
 * 
 * @author: Dakota Soares, and other sources. Sources are appropriately referenced in the comp495_cssc_app.docx. 
 * 
 * @date: July 14th, 2021 
 * 
 * Notes: see included documentation for test cases, parameters, etc. 
 */

//import required packages
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class cssc 
{
	JFrame frmCsscResources;

	/**
	 * Create the window.
	 */
	public cssc() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		//Initialize the JFrame and set its properties
		frmCsscResources = new JFrame();
		frmCsscResources.setTitle("CSSC Resources");
		frmCsscResources.setBounds(100, 100, 577, 320);
		frmCsscResources.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		frmCsscResources.getContentPane().setLayout(gridBagLayout);
		
		//Auto-generated code for layout
		
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmCsscResources.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Canadian System for Soil Classification Resources");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frmCsscResources.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		frmCsscResources.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JTextPane txtpnThereAreA = new JTextPane();
		txtpnThereAreA.setEditable(false);
		GridBagConstraints gbc_txtpnThereAreA = new GridBagConstraints();
		gbc_txtpnThereAreA.gridheight = 2;
		gbc_txtpnThereAreA.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnThereAreA.fill = GridBagConstraints.BOTH;
		gbc_txtpnThereAreA.gridx = 1;
		gbc_txtpnThereAreA.gridy = 3;
		frmCsscResources.getContentPane().add(txtpnThereAreA, gbc_txtpnThereAreA);
		
		JTextPane txtpnAstmDe = new JTextPane();
		txtpnAstmDe.setEditable(false);
		GridBagConstraints gbc_txtpnAstmDe = new GridBagConstraints();
		gbc_txtpnAstmDe.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnAstmDe.fill = GridBagConstraints.BOTH;
		gbc_txtpnAstmDe.gridx = 1;
		gbc_txtpnAstmDe.gridy = 5;
		frmCsscResources.getContentPane().add(txtpnAstmDe, gbc_txtpnAstmDe);
		
		JTextPane txtpnAstmDa = new JTextPane();
		txtpnAstmDa.setEditable(false);
		GridBagConstraints gbc_txtpnAstmDa = new GridBagConstraints();
		gbc_txtpnAstmDa.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnAstmDa.fill = GridBagConstraints.BOTH;
		gbc_txtpnAstmDa.gridx = 1;
		gbc_txtpnAstmDa.gridy = 6;
		frmCsscResources.getContentPane().add(txtpnAstmDa, gbc_txtpnAstmDa);
		
		JTextPane txtpnAstmD = new JTextPane();
		txtpnAstmD.setEditable(false);
		GridBagConstraints gbc_txtpnAstmD = new GridBagConstraints();
		gbc_txtpnAstmD.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnAstmD.fill = GridBagConstraints.BOTH;
		gbc_txtpnAstmD.gridx = 1;
		gbc_txtpnAstmD.gridy = 7;
		frmCsscResources.getContentPane().add(txtpnAstmD, gbc_txtpnAstmD);
		
		//Set the text informing the user as appropriate regarding various CSSC Soil Resource links: 
		
		txtpnThereAreA.setText("Agri-Food and Agriculture Canada (a Federal Department under the Minister of Agriculture) provides clear and comprehensive information on soil types. The following resources were used:");
		txtpnAstmDe.setText("Soils of Canada : Soil Map and Soil Order Description Home Page https://soilsofcanada.ca/\r\nNote: Detailed Descriptions for all soil orders used in the application are derived from the 10 Order pages found here: https://soilsofcanada.ca/orders/");
		txtpnAstmDa.setText("The Canadian System of Soil Classification : 3rd Edition, 1998 PDF Manual. Published by the Soil Classification Working Group : https://sis.agr.gc.ca/cansis/publications/manuals/1998-cssc-ed3/cssc3_manual.pdf");
		txtpnAstmD.setText("Government of Canada : CSSC 3rd Edition Table of Contents : https://sis.agr.gc.ca/cansis/taxa/cssc3/index.html");
		
	}
//end of cssc.java
}
