/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package actions;

import gui.DrawingCanvas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import tools.AbstractTool;
import tools.Tool;

/**
 * Creates a tool action.
 * @author Zachariah Wingo
 * @version 1.0
 */
public class ToolAction extends AbstractAction {

    /** Auto generated serial version UID. */
    private static final long serialVersionUID = -8911393007431277586L;

    /**
     * The canvas for drawing on.
     */
    private final DrawingCanvas myCanvas;
    
    /**
     * The tool to be created.
     */
    private final Tool myTool;
    
    /**
     * Constructor for a tool action.
     * @param theCanvas the canvase to be drawn upon.
     * @param theTool the tool to draw on the canvas.
     */
    public ToolAction(final DrawingCanvas theCanvas, final AbstractTool theTool) {
        super(theTool.getDescription());
        myCanvas = theCanvas;
        myTool = theTool;
        putValue(Action.LARGE_ICON_KEY, theTool.getToolIcon());
        
        putValue(Action.MNEMONIC_KEY,
                 KeyEvent.getExtendedKeyCodeForChar(theTool.getDescription().charAt(0)));
        
        putValue(Action.SHORT_DESCRIPTION, theTool.getDescription() + " tool");
        
        putValue(Action.SELECTED_KEY, true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myCanvas.setToolTipText(myTool.getDescription());
        myCanvas.setTool(myTool);

    }

}
