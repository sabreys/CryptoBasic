package kriptoproje;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;

public class MainGui {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	File f=null;
	String path=null;
	JOptionPane x=new JOptionPane();
	 String tempDir;
	 
	 static File theDir = new File("C:\\CryptoBasic");
	 
	 JFileChooser fileChooser=new JFileChooser(theDir);
	 
	public static void main(String[] args) {
		
		if (!theDir.exists()) {
		    System.out.println("creating directory: " + theDir.getName());
		    boolean result = false;

		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		        //handle it
		    }        
		    if(result) {    
		        System.out.println("DIR created");  
		    }
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
			
			
			
		});
	}

	
	public MainGui() {
		
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 410, 242);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDone = new JLabel("");
		lblDone.setHorizontalAlignment(SwingConstants.CENTER);
		lblDone.setForeground(new Color(34, 139, 34));
		lblDone.setBounds(0, 145, 394, 14);
		frame.getContentPane().add(lblDone);
		
		JButton btnCrypt = new JButton("Encrypt");
		btnCrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deneme.Key=textField_1.getText();
				System.out.println(deneme.Key);
				deneme.cho=true;
				 deneme.crpyto();
				 lblDone.setText("DONE!");
			}
		});
		btnCrypt.setBounds(85, 165, 89, 23);
		frame.getContentPane().add(btnCrypt);
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deneme.Key=textField_1.getText();
				System.out.println(deneme.Key);
				deneme.cho=false;
				System.out.println(deneme.cho+"");
				 deneme.crpyto();
				 lblDone.setText("DONE!");
				 
			}
		});
		btnDecrypt.setBounds(220, 165, 89, 23);
		frame.getContentPane().add(btnDecrypt);
		
		JLabel lblFilePath = new JLabel("File Path");
		lblFilePath.setBounds(10, 45, 80, 14);
		frame.getContentPane().add(lblFilePath);
		
		
		fileChooser.setCurrentDirectory(theDir);
	
		
		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			

				 
				    fileChooser.setDialogTitle("choice a file or path");
				 fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				 fileChooser.showOpenDialog(fileChooser);
				 deneme.Dosya=fileChooser.getSelectedFile();
				 path=deneme.Dosya.getAbsolutePath();
				
				 textField.setText(path);
			}
		
		});
		
		
		textField = new JTextField();
		textField.setBounds(100, 42, 254, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		 textField.setText(theDir.getAbsolutePath());
		
		JLabel lblKey = new JLabel("Key");
		lblKey.setBounds(10, 86, 46, 14);
		frame.getContentPane().add(lblKey);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 83, 254, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel labe2 = new JLabel("CrpytoBasic ");
		labe2.setHorizontalAlignment(SwingConstants.CENTER);
		labe2.setFont(new Font("Tahoma", Font.BOLD, 15));
		labe2.setBounds(0, 98, 394, 54);
		frame.getContentPane().add(labe2);
		
		
		

		button.setVerticalAlignment(SwingConstants.BOTTOM);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(354, 42, 32, 20);
		frame.getContentPane().add(button);
	}
	
	
}
