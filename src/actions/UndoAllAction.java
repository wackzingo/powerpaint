/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package actions;

import gui.DrawingCanvas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 * Action for undo all button.
 * @author Zachariah Wingo
 * @version 1.0
 *
 */
public class UndoAllAction extends AbstractAction {

    
    /** Auto generated serial version UID. */
    private static final long serialVersionUID = 8105312389143008118L;
    
    /**
     * The canvas to draw upon.
     */
    private final DrawingCanvas myCanvas;
    
    /**
     * Constructor.
     * 
     * @param theName of the undo all button.
     * @param theCanvas the canvas to be cleared.
     */
    public UndoAllAction(final String theName, final DrawingCanvas theCanvas) {
        super(theName);
        
        myCanvas = theCanvas;
        
        putValue(Action.MNEMONIC_KEY, KeyEvent.getExtendedKeyCodeForChar(theName.charAt(0)));
        
        putValue(Action.SHORT_DESCRIPTION, theName);
        
        putValue(Action.SELECTED_KEY, true);
    }
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myCanvas.clearCanvas();
    }

}
