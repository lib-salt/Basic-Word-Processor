package text_editor;


import javax.swing.*;
import java.awt.*;


/**
 * @author Libby
 * 
 *
 */
public class TextBox extends JFrame{
	
	private JFrame frame;
	private JTextArea textBox;
	private JScrollPane scroll;
	
	
	
	public TextBox(){
		// --- GUI set up ---
		frame = new JFrame("Text Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setSize(1000, 900);
		frame.setLocationRelativeTo(null);
				
				
		// create text box that users can type in
		textBox = new JTextArea();
		// when text reaches the end of the box it will start a new line
		textBox.setLineWrap(true);
		textBox.setWrapStyleWord(true);
		textBox.setFont(new Font("Arial", Font.PLAIN, 25));
				
		// allows to scroll up and down on the text box
		scroll = new JScrollPane(textBox);
		scroll.setPreferredSize(new Dimension(950, 850));
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				
		
		// --- Menu Bar----
				JMenuBar menuBar;
				JMenu fileMenu;
				JMenuItem open;
				JMenuItem save;
				JMenuItem exit;
				
				menuBar = new JMenuBar();
				fileMenu = new JMenu("File");
				open = new JMenuItem("Open");
				save = new JMenuItem("Save");
				exit = new JMenuItem("Exit");
				
				fileMenu.add(open);
				fileMenu.add(save);
				fileMenu.add(exit);
				menuBar.add(fileMenu);
				
				// adds menu to GUI
				frame.setJMenuBar(menuBar);
				
				FileSave fileSave = new FileSave(textBox, frame);
				
				open.addActionListener(fileSave);
				save.addActionListener(fileSave);
				exit.addActionListener(fileSave);
		
		//---Character Index---
				new charIndex(textBox, frame);
		
						
		//---Templates---
				new Templates(textBox, frame);
				
		//---Style Text---
				new StyleText(textBox, frame);
		
				
		//---Copy/Paste---
				new CopyPaste(textBox, frame);
				
				
		//---Undo/Redo---
				new UndoRedo(textBox, frame);
				
				//adds text box to GUI
				frame.add(scroll);
				frame.setVisible(true);				
	
	}
}
/*
 *  I used code in the following resource to create this class:
 *  https://www.youtube.com/watch?v=NKjqAQAtq-g&t=1061s
 *  I did not copy the code verbatim, names were changed where appropriate
 *  I also put some of the code in a different class. Other changes were 
 *  made where appropriate.
 */

