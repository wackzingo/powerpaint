/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package gui;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Creates a tool bar.
 * @author Zachariah Wingo
 * @version 1.0
 *
 */
public class GUIToolBar extends JToolBar {


    /** Auto generated serial version UID. */
    private static final long serialVersionUID = -6969282661802905468L;
    
    /** A button group for the mutually exclusive tool bar buttons. */ 
    private final ButtonGroup myGroup;

    
    /**
     * Construct the ToolBar.
     */
    public GUIToolBar() {
        super();
        myGroup = new ButtonGroup();
    }

    
    /**
     * Create a JToggleButton for the ToolBar.
     * 
     * @param theAction to associate with the created JToggleButton
     */
    public void createToolBarButton(final Action theAction) {
        
        final JToggleButton toggleButton = new JToggleButton(theAction);
        
        if ("Pencil".equals(theAction.getValue("Name"))) {
            theAction.setEnabled(true);
            toggleButton.setSelected(true);
        }
        
        myGroup.add(toggleButton);     
        add(toggleButton);
    }

}