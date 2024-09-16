package text_editor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


/**
 * @author Libby
 *
 */
public class Templates extends GUIManipulator implements ActionListener{


	private JButton templates = newButton("Templates");
	private JFrame templateMenu = new JFrame("Templates");
	private JButton opt1 = newButton("Letter to Santa");
	private JButton opt2 = newButton("Dear Sir/Madam");
	
	
	
	/**
	 * @param textBox the GUI textbox
	 * @param frame the GUI frame
	 */
	public Templates(JTextArea textBox, JFrame frame) {
		super(textBox, frame);
		
		//adds new button to panel
		
		addTo(frame, templates);
		templateMenu.setLayout(new FlowLayout());
		templateMenu.setSize(250, 250);
		
		addToGUI();
		
	}
	
	protected void addToGUI() {
		addTo(templateMenu, opt1);
		addTo(templateMenu, opt2);
	}
	
	
	/**
	 * @return
	 */
	private String santa() {
		return """
				Dear Santa,
				
				  This year for Christmas I would like....
					
						Yours Sincerely,
					
				""";
	}
	
	/**
	 * @return
	 */
	private String letter() {
		return """
				Dear Sir/Madam
					
					
						Yours Sincerely,
					
				""";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == templates) {
			templateMenu.setVisible(true);
		}
		if(e.getSource() == opt1) {
			appendText(santa());
			templateMenu.dispose();
		}
		if(e.getSource() == opt2) {
			appendText(letter());
			templateMenu.dispose();
		}
	}

}
