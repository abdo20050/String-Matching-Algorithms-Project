import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class projGUI extends JFrame {

	private JPanel contentPane;
	private final JLabel Title = new JLabel("String Matching Algorithms Project");
	SwingAction action = new SwingAction();
	private JSpinner spinner;
	private JCheckBox chkBox;
	private final Action ButtonAction = new SwingAction_1();
	private JFormattedTextField fNameTextField;
	private JFormattedTextField STMtxtfld;
	private JComboBox comboBox;
	private JTextPane txtpnOutput;
	private JFormattedTextField oFNametxtFld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					projGUI frame = new projGUI();
					frame.setVisible(true);
					//my code
					//end
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public projGUI() {
		setTitle("String Matching Algorithms Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("RUN!");
		btnNewButton.setAction(ButtonAction);
		btnNewButton.setBounds(192, 249, 85, 21);
		contentPane.add(btnNewButton);
		Title.setFont(new Font("Tahoma", Font.BOLD, 16));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(90, 10, 346, 30);
		contentPane.add(Title);
		
		JLabel lblNewLabel = new JLabel("Number of Chars");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 62, 130, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Test File Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 117, 130, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Choose the algorithm");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 148, 130, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JList list = new JList();
		list.setBounds(230, 212, 120, -50);
		contentPane.add(list);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 10));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Brute Force", "Knuth-Morris-Pratt\u2019s", "Boyer-Moore's "}));
		comboBox.setBounds(169, 149, 146, 21);
		contentPane.add(comboBox);
		
		fNameTextField = new JFormattedTextField();
		fNameTextField.setText("F1");
		fNameTextField.setBounds(169, 119, 114, 19);
		contentPane.add(fNameTextField);
		
		JLabel lblNewLabel_1_2 = new JLabel(".txt");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(284, 117, 31, 21);
		contentPane.add(lblNewLabel_1_2);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(100, 100, 10000, 100));
		spinner.setBounds(169, 64, 146, 20);
		contentPane.add(spinner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(341, 62, 175, 192);
		contentPane.add(scrollPane);
		
		txtpnOutput = new JTextPane();
		scrollPane.setViewportView(txtpnOutput);
		txtpnOutput.setText("OUTPUT.....");
		txtpnOutput.setEditable(false);
		
		chkBox = new JCheckBox("Auto increment");
		chkBox.setAction(action);
		chkBox.setBounds(169, 90, 146, 21);
		contentPane.add(chkBox);
		
		JLabel lblNewLabel_1_3 = new JLabel("String To Match");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(10, 179, 130, 21);
		contentPane.add(lblNewLabel_1_3);
		
		STMtxtfld = new JFormattedTextField();
		STMtxtfld.setText("lol");
		STMtxtfld.setBounds(169, 181, 146, 19);
		contentPane.add(STMtxtfld);
		
		JLabel lblNewLabel_1_4 = new JLabel("Results File Name");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(10, 210, 130, 21);
		contentPane.add(lblNewLabel_1_4);
		
		oFNametxtFld = new JFormattedTextField();
		oFNametxtFld.setText("o1");
		oFNametxtFld.setBounds(169, 212, 114, 19);
		contentPane.add(oFNametxtFld);
		
		JLabel lblNewLabel_1_2_1 = new JLabel(".csv");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(284, 210, 31, 21);
		contentPane.add(lblNewLabel_1_2_1);
	}
	public void actionPerformed(ActionEvent e) {
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Auto increment");
			putValue(SHORT_DESCRIPTION, "It will auto test from 100 to 10,000 number of elements");
		}
		public void actionPerformed(ActionEvent e) {
			if(getChkBox().isSelected()) {
				getSpinner().setEnabled(false);
			}else {
				getSpinner().setEnabled(true);
			}
		}
	}
	public JSpinner getSpinner() {
		return spinner;
	}
	public JCheckBox getChkBox() {
		return chkBox;
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Run!");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			TestClass.algorithm inAlgo;
			TestClass testObj = new TestClass();
			OpenCSVFileWriter csvFile = new OpenCSVFileWriter();
			switch(comboBox.getSelectedIndex()) {
			case 0:
				inAlgo = TestClass.algorithm.bruteForce;
				break;
			case 1:
				inAlgo = TestClass.algorithm.knuthMorris;
				break;
			case 2:
				inAlgo = TestClass.algorithm.boyerMoors;
				break;
			default:
				inAlgo = TestClass.algorithm.bruteForce;
				break;
			}
			String fName = getFNameTextField().getText();
			String oFName = getOFNametxtFld().getText();
			String stm = getSTMtxtfld().getText();
			String output = "";
			if(chkBox.isSelected()) {
				for(int i = 100; i<=10000; i+= 100) {
					output = output + "@ " + Integer.toString(i) + " number of elements\n";
					long avg = testObj.performTest(inAlgo,i,fName,stm,5);
					float avgD= (float)avg/1000.0f;
					output= output + "average execution time using "+ comboBox.getSelectedItem().toString() + " algorithm is "+Float.toString(avgD)+" us\n\n";
					csvFile.addData(Integer.toString(i),Float.toString(avgD));
				}
			}
			else 
			{
				int i = (int) getSpinner().getValue();
				output = output + "@ " + Integer.toString(i) + " number of elements\n";
				long avg=0;
				avg = testObj.performTest(inAlgo,i,fName,stm,5);
				float avgD= (float)avg/1000.0f;
				output= output + "average execution time using "+ comboBox.getSelectedItem().toString() + " algorithm is "+Float.toString(avgD)+" us\n\n";
				csvFile.addData(Integer.toString(i),Float.toString(avgD));
			}
			getOutputTxtpn().setText(output);
			csvFile.creatCSVFile(oFName);
		}
	}
	public JFormattedTextField getFNameTextField() {
		return fNameTextField;
	}
	public JFormattedTextField getSTMtxtfld() {
		return STMtxtfld;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public JTextPane getOutputTxtpn() {
		return txtpnOutput;
	}

	public JFormattedTextField getOFNametxtFld() {
		return oFNametxtFld;
	}
}
