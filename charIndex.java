package text_editor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;



/**
 * @author Libby
 *
 */
public class charIndex extends GUIManipulator{
	

	private JLabel charIndex;
	private int charNum; 
	
	
	/**
	 * @param textBox the GUI textbox
	 * @param frame the GUI frame
	 */
	public charIndex(JTextArea textBox, JFrame frame) {
		super(textBox, frame);
		

		
		Thread indexThread = new Thread(() ->{
		
		while(true) {
			charNum = getText().length();
			
			SwingUtilities.invokeLater(() -> {
                charIndex.setText("Character Index: " + charNum);
            });

			
			try {
				// run thread once every second
                Thread.sleep(1000); 
            } 
			catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
		});
		indexThread.setDaemon(true);
		indexThread.start();
		addToGUI();
		
	}
	
	protected void addToGUI() {
		charIndex = new JLabel("Character Index: "  + charNum);
		addTo(frame, charIndex);
	}
	
}
/* I used code in the following resource to create this class:
*  https://alvinalexander.com/java/java-8-lambda-thread-runnable-syntax-examples/
*  I did not use the code verbatim, I used it as a resource to to learn about running
*  threads and their syntax.
*/
