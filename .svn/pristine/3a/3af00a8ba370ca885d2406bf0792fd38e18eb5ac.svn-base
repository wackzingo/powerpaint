/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;

/**
 * Exit action to be executed when closing the frame.
 * @author Zachariah Wingo
 * @version 1.0
 */
public class ExitAction  extends AbstractAction {

    /** Auto generated serial version UID. */
    private static final long serialVersionUID = -7851535565239689138L;
    /**
     * The frame to be closed when exiting.
     */
    private final JFrame myFrame;
    
    /**
     * The exit action.
     * @param theName the name of the exit item.
     * @param theFrame the frame to be closed by this action.
     */
    public ExitAction(final String theName, final JFrame theFrame) {
        super(theName);
        myFrame = theFrame;
        
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);
        
        putValue(Action.SHORT_DESCRIPTION, theName);
        
        putValue(Action.SELECTED_KEY, true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        
        myFrame.dispatchEvent(new WindowEvent(myFrame,
                                               WindowEvent.WINDOW_CLOSING));
    }

}