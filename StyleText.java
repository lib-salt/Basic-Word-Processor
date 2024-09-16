package text_editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



/**
 * @author Libby
 *
 */
public class StyleText extends GUIManipulator implements StyleInterface, ActionListener {

	private JSpinner fontSizeSpinner;
	private JLabel sizeLabel;
	private JComboBox<String> fontChooser;
	JButton colourButton;
	private JButton boldButton;
	private JButton italicsButton;
	private JButton underlineButton;
	private JButton plainButton;
	
	/**
	 * @param textBox the GUI textbox
	 * @param frame the GUI frame
	 */
	public StyleText(JTextArea textBox, JFrame frame) {
		super(textBox, frame);
		// TODO Auto-generated constructor stub
		styleText();
	}

	@Override
	public void styleText() {
		
		//---Size---
		sizeLabel = new JLabel("size:");
		
		
		fontSizeSpinner = new JSpinner();
		fontSizeSpinner.setPreferredSize(new Dimension(50,25));
		fontSizeSpinner.setValue(25);
		fontSizeSpinner.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					getTextBox().setFont(new Font(getTextBox().getFont().getFamily(), Font.PLAIN, (int) fontSizeSpinner.getValue()));
				}
		});
		
		
		//---Font---
		String[]fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(null);
		fontChooser = new JComboBox<String>(fonts);
		fontChooser.addActionListener(this);
		fontChooser.setSelectedItem("Arial");
		
		
		//---Colour---
		colourButton = newButton("Colour");
		
		//---Bold---
		boldButton = newButton("Bold");
		
		//---Italics---
		italicsButton = newButton("Italics");
		
		//---Underline---
		underlineButton = newButton("Underline");
		
		//---Plain---
		plainButton = newButton("Plain");
		
		addToGUI();
	}

	@Override
	protected void addToGUI() {
		// TODO Auto-generated method stub
		addTo(frame, sizeLabel);
		addTo(frame, fontSizeSpinner);
		addTo(frame, fontChooser);
		addTo(frame, colourButton);
		addTo(frame, boldButton);
		addTo(frame, italicsButton);
		addTo(frame, underlineButton);
		addTo(frame, plainButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == fontChooser) {
			getTextBox().setFont(new Font((String)fontChooser.getSelectedItem(), Font.PLAIN, getTextBox().getFont().getSize()));
		}
		if(e.getSource() == colourButton) {
			JColorChooser colourChooser = new JColorChooser();
			
			Color colour = colourChooser.showDialog(null, "Colour Picker",Color.black );
			getTextBox().setForeground(colour);
		}
		if(e.getSource() == boldButton) {
			getTextBox().setFont(new Font(getTextBox().getFont().getFamily(), Font.BOLD, (int) fontSizeSpinner.getValue()));
		}
		if(e.getSource() == italicsButton) {
			getTextBox().setFont(new Font(getTextBox().getFont().getFamily(), Font.ITALIC, (int) fontSizeSpinner.getValue()));

		}
		if(e.getSource() == plainButton) {
			getTextBox().setFont(new Font(getTextBox().getFont().getFamily(), Font.PLAIN, (int) fontSizeSpinner.getValue()));
		}
		if(e.getSource() == underlineButton) {
			Map<TextAttribute, Object> attributes = new HashMap<>();
            attributes.put(TextAttribute.UNDERLINE,
                    TextAttribute.UNDERLINE_ON.equals(getTextBox().getFont().getAttributes().get(TextAttribute.UNDERLINE))
                            ? null : TextAttribute.UNDERLINE_ON);

            Font newFont = getTextBox().getFont().deriveFont(attributes);
            getTextBox().setFont(newFont);
        
		}
	}

}
/* I used code in the following resource to create this class:
*  https://www.youtube.com/watch?v=NKjqAQAtq-g&t=1061s
*  I did not copy this code verbatim, I changed some of the naming and made alterations to 
*  more practically suit my code.
*  This is a resource I used to further progress my understanding of java code:
*  https://stackoverflow.com/questions/10336899/what-is-a-question-mark-and-colon-operator-used-for
*  It was not copied verbatim.
*/
