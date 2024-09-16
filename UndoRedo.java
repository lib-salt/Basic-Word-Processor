package text_editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;


/**
 * @author Libby
 *
 */
public class UndoRedo extends GUIManipulator implements ActionListener,UndoableEditListener{

	private JButton undo;
	private JButton redo;
	private UndoManager undoManager;
	
	
	/**
	 * @param textBox the GUI textbox
	 * @param frame the GUI frame
	 */
	public UndoRedo(JTextArea textBox, JFrame frame) {
		super(textBox, frame);
		undo = newButton("Undo");
		redo = newButton("Redo");
		addToGUI();
		undoManager = new UndoManager();
		getTextBox().getDocument().addUndoableEditListener(this);
		
	}

	@Override
	protected void addToGUI() {
		addTo(frame, undo);
		addTo(frame, redo);
	}
	
	public void undoableEditHappened(UndoableEditEvent e) {
		undoManager.addEdit(e.getEdit());
        updateUndoRedoState();
    }

	private void undo() {
		try {
            undoManager.undo();
        } catch (CannotUndoException ex) {
            System.out.println("Unable to undo: " + ex);
            ex.printStackTrace();
        }
        updateUndoRedoState();
	}
	
	private void redo() {
		try {
            undoManager.redo();
        } catch (CannotRedoException ex) {
            System.out.println("Unable to redo: " + ex);
            ex.printStackTrace();
        }
        updateUndoRedoState();
	}
	
	private void updateUndoRedoState() {
        undo.setEnabled(undoManager.canUndo());
        redo.setEnabled(undoManager.canRedo());
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == undo) {
			 undo();
		}
		if(e.getSource() == redo) {
			 redo();
		}
	}

}
/* 
 * I used code in the following resource to create this class:
 * https://docs.oracle.com/javase/tutorial/uiswing/components/generaltext.html#undo
 * I did not copy the code verbatim, I used it as a resource to use the UndoableEditListener 
 * class and made changes to apply it to my code.
 */
