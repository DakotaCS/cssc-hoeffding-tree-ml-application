//: src/astm.java

/***********************************************************************
 * Class: astm.java
 * 
 * Purpose: Purpose: This contains the astm resources window for the CSSC application. 
 * 
 * @author: Dakota Soares, and other sources. Sources are appropriately referenced in the comp495_cssc_app.docx. 

 * @date: July 14th, 2021 
 * 
 * Notes: see included documentation for test cases, parameters, etc. 
 */

//import required packages
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextPane;

public class astm {

	JFrame frmAstmInformation;

	/**
	 * Create the application.
	 */
	public astm() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		//Initialize the JFrame and set its properties
		frmAstmInformation = new JFrame();
		frmAstmInformation.setTitle("ASTM Information");
		frmAstmInformation.setBounds(100, 100, 642, 355);
		frmAstmInformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmAstmInformation.getContentPane().setLayout(gridBagLayout);
		
		//Auto-generated code for layout
		
		JLabel lblNewLabel = new JLabel("Association for Standards, Materials, and Testing Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frmAstmInformation.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		frmAstmInformation.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JTextPane txtpnThereAreA = new JTextPane();
		txtpnThereAreA.setEditable(false);
		GridBagConstraints gbc_txtpnThereAreA = new GridBagConstraints();
		gbc_txtpnThereAreA.gridheight = 2;
		gbc_txtpnThereAreA.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnThereAreA.fill = GridBagConstraints.BOTH;
		gbc_txtpnThereAreA.gridx = 1;
		gbc_txtpnThereAreA.gridy = 3;
		frmAstmInformation.getContentPane().add(txtpnThereAreA, gbc_txtpnThereAreA);
		
		JTextPane txtpnAstmDe = new JTextPane();
		txtpnAstmDe.setEditable(false);
		GridBagConstraints gbc_txtpnAstmDe = new GridBagConstraints();
		gbc_txtpnAstmDe.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnAstmDe.fill = GridBagConstraints.BOTH;
		gbc_txtpnAstmDe.gridx = 1;
		gbc_txtpnAstmDe.gridy = 5;
		frmAstmInformation.getContentPane().add(txtpnAstmDe, gbc_txtpnAstmDe);
		
		JTextPane txtpnAstmDa = new JTextPane();
		txtpnAstmDa.setEditable(false);
		GridBagConstraints gbc_txtpnAstmDa = new GridBagConstraints();
		gbc_txtpnAstmDa.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnAstmDa.fill = GridBagConstraints.BOTH;
		gbc_txtpnAstmDa.gridx = 1;
		gbc_txtpnAstmDa.gridy = 6;
		frmAstmInformation.getContentPane().add(txtpnAstmDa, gbc_txtpnAstmDa);
		
		JTextPane txtpnAstmD = new JTextPane();
		txtpnAstmD.setEditable(false);
		GridBagConstraints gbc_txtpnAstmD = new GridBagConstraints();
		gbc_txtpnAstmD.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnAstmD.fill = GridBagConstraints.BOTH;
		gbc_txtpnAstmD.gridx = 1;
		gbc_txtpnAstmD.gridy = 7;
		frmAstmInformation.getContentPane().add(txtpnAstmD, gbc_txtpnAstmD);
		
		JTextPane txtpnAstmD_1 = new JTextPane();
		txtpnAstmD_1.setEditable(false);
		GridBagConstraints gbc_txtpnAstmD_1 = new GridBagConstraints();
		gbc_txtpnAstmD_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnAstmD_1.fill = GridBagConstraints.BOTH;
		gbc_txtpnAstmD_1.gridx = 1;
		gbc_txtpnAstmD_1.gridy = 8;
		frmAstmInformation.getContentPane().add(txtpnAstmD_1, gbc_txtpnAstmD_1);
		
		//Set the text informing the user as appropriate regarding various ASTM soil standards: 
		
		txtpnAstmD_1.setText("ASTM D653-21 : Standard Terminology Relating to Soil, Rock, and Contained Fluids : https://www.astm.org/Standards/D653.htm");
		txtpnAstmD.setText("ASTM D4083-90 : Standard Practice for Description of Frozen Soils (Visual-Manual Procedure) : https://www.astm.org/Standards/D4083.htm");
		txtpnAstmDa.setText("ASTM D2488-09a : Standard Practice for Description and Identification of Soils (Visual-Manual Procedure) : https://socwisconsin.org/wp-content/uploads/2017/01/ASTM-D-2488-visual-USCS.pdf ");
		txtpnThereAreA.setText("There are a variety of ASTM standard practice and procedural documents that can be used to provide further clarification and/or analysis when examining soils. The following ASTM standards listed below are relevant to soil pedon analysis:\r\n\r\nNote: ASTM D2488 was used to identify soil attributes that could be easily analyzed as part of this project. ");
		txtpnAstmDe.setText("ASTM D2487-17e1 : Standard Practice for Classification of Soils for Engineering Purposes (USCS) : https://www.astm.org/Standards/D2487.htm");
		
	}
//end of file astm.java
}
