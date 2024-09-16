package text_editor;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


/**
 * @author Libby
 *
 */
public class CopyPaste extends GUIManipulator implements ActionListener{

	private JButton copy;
	private JButton paste;
	
	
	
	/**
	 * @param textBox the GUI textbox
	 * @param frame the GUI frame
	 */
	public CopyPaste(JTextArea textBox, JFrame frame) {
		super(textBox, frame);
		copy = newButton("Copy");
		paste = newButton("Paste");
		addToGUI();
		
	}

	
	protected void addToGUI() {
		addTo(frame, copy);
		addTo(frame, paste);
	}

	private void copy() {
		String str = getText();
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection copyText = new StringSelection(str);
	        clip.setContents(copyText, copyText);
	        
	}
	
	private void paste() {
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		try {
            
            String clipboardContent = (String) clip.getData(DataFlavor.stringFlavor);

            
            appendText(clipboardContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == copy) {
			copy();
		}
		if(e.getSource() == paste) {
			paste();
		}
	}

}
/* I used code in the following resource to create this class:
*  https://www.geeksforgeeks.org/how-to-copy-text-to-the-clipboard-in-java/
*  I did not copy this code verbatim, I changed some of the variable names
*  and made other changes where appropriate.
*/
