package StopWatch;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 
 * @author Amine.Hamdi
 * @since 03/12/2021
 *
 */
public class Stopwatch extends JFrame {
		// declare controls used
		// Instantiating buttons 
		JButton stopButton = new JButton();
		JButton startButton = new JButton();
		JButton exitButton = new JButton();
		// Instantiating labels
		JLabel startLabel = new JLabel();
		JLabel stopLabel = new JLabel();
		JLabel elapsedLabel = new JLabel();
		// Instantiating textfields
		JTextField startTextField = new JTextField();
		JTextField stopTextField = new JTextField();
		JTextField elapsedTextField = new JTextField();
		// declare class level variables
		long startTime;
		long stopTime;
		double elapsedTime;

	public static void main(String[] args) {
		
		//Construct Frame 
		new Stopwatch().show();
	}
	
	public Stopwatch() {
		//Frame Constructor
		//Frame Title
		setTitle("Stopwtch Application");

		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitForm(e);
			}
		});
		
		// settings the grid 
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gridConstraints = new GridBagConstraints();
		
		startButton.setText("Start Timming");
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		getContentPane().add(startButton,gridConstraints);
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startButtonActionPerformed(e);
				
			}
			
		});
		
		stopButton.setText("Stop Timming");
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 1;
		getContentPane().add(stopButton,gridConstraints);
		stopButton.setEnabled(false);
		stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stopButtonActionPerformed(e);
				
			}
			
		});
		exitButton.setText("Exit");
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 2;
		getContentPane().add(exitButton, gridConstraints);
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				exitButtonActionPerformed(e);
				
			}
			
		});
		
		startLabel.setText("Start Time");
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 0;
		getContentPane().add(startLabel, gridConstraints);
		
		stopLabel.setText("Stop Time");
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		getContentPane().add(stopLabel, gridConstraints);
		
		elapsedLabel.setText("Elapsed Time (sec)"); gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		getContentPane().add(elapsedLabel, gridConstraints);
		
		startTextField.setText("");
		startTextField.setColumns(15);
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 0;
		getContentPane().add(startTextField, gridConstraints);
		
		stopTextField.setText("");
		stopTextField.setColumns(15);
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 1;
		getContentPane().add(stopTextField, gridConstraints);
		
		elapsedTextField.setText("");
		elapsedTextField.setColumns(15);
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 2;
		getContentPane().add(elapsedTextField, gridConstraints); 
		pack();
		
	}
	/**
	 * 
	 * @param e
	 */
	private void startButtonActionPerformed(ActionEvent e) {
		//click of start timing button
		startTime = System.currentTimeMillis();
		startTextField.setText(String.valueOf(startTime));
		stopTextField.setText("");
		stopButton.setEnabled(true);
		elapsedTextField.setText("");
		
	}
	/**
	 * 
	 * @param e
	 */
	private void stopButtonActionPerformed(ActionEvent e) {
		//click for stop timing button
		stopTime = System.currentTimeMillis();
		stopTextField.setText(String.valueOf(stopTime));
		elapsedTime = (stopTime-startTime)/1000.0;
		elapsedTextField.setText(String.valueOf(elapsedTime));
		
	}
	/**
	 * 
	 * @param e
	 */
	private void exitButtonActionPerformed(ActionEvent e) {
		System.exit(0);
	}
	/**
	 * 
	 * @param e
	 */
	private void exitForm(WindowEvent e) {
		System.exit(0);
	}

}
