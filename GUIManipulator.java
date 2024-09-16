package text_editor;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;




/**
 * @author Libby
 *
 */
public abstract class GUIManipulator {
	
	private JTextArea textBox;
	protected JFrame frame;
	
	
	/**
	 * @param textBox
	 * @param frame
	 */
	public GUIManipulator(JTextArea textBox, JFrame frame) {
		this.textBox = textBox;
		this.frame = frame;
	}
	
	/**
	 * @return
	 */
	public JTextArea getTextBox() {
        return textBox;
    }
	
	/**
	 * @return
	 */
	public String getText() {
		return textBox.getText();
	}
	
	
	 /**
	 * @param textToAppend
	 */
	public void appendText(String textToAppend) {
	        textBox.append(textToAppend);
	    }
	 
	 /**
	 * @param name
	 * @return
	 */
	public JButton newButton(String name) {
		 JButton button = new JButton(name);
		 button.addActionListener((ActionListener) this);
		 return button;
	 }
	 
	/**
	 * @param a
	 * @param b
	 */
	public void addTo(Container a, Component b) {
		a.add(b);
	}
	 
	protected abstract void addToGUI();
	
}
