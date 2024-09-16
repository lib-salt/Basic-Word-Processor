package text_editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;



/**
 * @author Libby
 *
 */
public class FileSave extends GUIManipulator implements ActionListener, DocumentListener{
	
	private boolean isModified = false;
	
	/**
	 * @param textBox  the GUI textbox
	 * @param frame the GUI frame
	 */
	public FileSave(JTextArea textBox, JFrame frame) {
		super(textBox, frame);
		textBox.getDocument().addDocumentListener(this);
	}


	protected void addToGUI() {
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		
		if("Open".equals(command)){
			openFile();
			}
		
		if("Save".equals(command)){
			saveFile();
		}
		
		if("Exit".equals(command)) {
			
			exit();
		}
		
	}
	//---Save File---
		private void saveFile() {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(".txt"));
			
			String text = getText();
			
			int userSelection = fileChooser.showSaveDialog(null);
			if(userSelection == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				
				if (!file.getName().toLowerCase().endsWith(".txt")) {
		            file = new File(file.getAbsolutePath() + ".txt");
		        }
				
				if (file.exists()) {
	                int response = JOptionPane.showConfirmDialog(null,
	                        "The file exists, overwrite?", "Existing file",
	                        JOptionPane.YES_NO_OPTION);
	                switch (response) {
	                case JOptionPane.YES_OPTION:
	                    break;
	                    
	                case JOptionPane.NO_OPTION:
	                case JOptionPane.CLOSED_OPTION:
	                    return;
	                }
	            }
				
				
				
				PrintWriter fileOut = null;
				try {
					fileOut = new PrintWriter(file);
					fileOut.println(text);
				} 
				catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					fileOut.close();
					isModified = false;
				}
			}
		}
		
	//---Open File ---
		private void openFile() {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
			fileChooser.setFileFilter(filter);
			
			int response = fileChooser.showOpenDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				Scanner fileIn = null;
				
				try {
					fileIn = new Scanner(file);
					if(file.isFile()) {
						while(fileIn.hasNextLine()) {
							String line = fileIn.nextLine() + "\n";
							appendText(line);
						}
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					fileIn.close();
					
				}
			}
		}
		
	//---exit---
		private void exit() {
			if(isModified == true) {
				int option = JOptionPane.showConfirmDialog(null, "You have some unsaved changes. Do you wish to save these changes?", "Unsaved Changes", JOptionPane.YES_NO_CANCEL_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					saveFile();
					System.exit(0);
				}
				else if(option == JOptionPane.CANCEL_OPTION) {
					return;
				}
				else if(option == JOptionPane.NO_OPTION) {
					System.exit(0);
				}
			}
			System.exit(0);
		}
	
	
		
	
	//---Unsaved Changes---
	
		public void changedUpdate(DocumentEvent e) {
           isModified = true;                
		}

		public void insertUpdate(DocumentEvent e) {
			isModified = true;                
		}
			
		public void removeUpdate(DocumentEvent e) {
			isModified = true;                
		}            
}
/*  
 *  I used code in the following resource to create this class:
 *  https://www.youtube.com/watch?v=NKjqAQAtq-g&t=1061s
 *  I did not copy the code verbatim, some variable names were changed
 *  and separate methods where created in a different class. Also made
 *  further changes where appropriate.
 */
