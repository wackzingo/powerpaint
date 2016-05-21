/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package actions;

import gui.ColorIcon;
import gui.DrawingCanvas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JColorChooser;


/**
 * Creates a color action for color chooser.
 * @author Zachariah Wingo
 * @version 1.0
 */
public class ColorAction extends AbstractAction {
    
    /** Auto generated serial version UID. */
    private static final long serialVersionUID = 7925646546182490140L;
    
    /** Size of color icon. */
    private static final int SMALL_ICON_SIZE = 16;
    /** Canvas for drawing. */
    private final DrawingCanvas myCanvas;
    
    /** Icon shows currently selected color. */
    private Color myIconColor;
    
    
    /**
     * Constructor for color action.
     * @param theCanvas the canvas on which shapes can be drawn.
     */
    public ColorAction(final DrawingCanvas theCanvas) {
        super("Color…");
        myCanvas = theCanvas;
        myIconColor = Color.decode("#4b2e83");
        myCanvas.setMyColor(myIconColor);
        putValue(Action.SMALL_ICON, new ColorIcon(SMALL_ICON_SIZE, myIconColor));
        putValue(Action.MNEMONIC_KEY,
                 KeyEvent.getExtendedKeyCodeForChar(KeyEvent.VK_C));
        
        putValue(Action.SHORT_DESCRIPTION, "Color");
        
        putValue(Action.SELECTED_KEY, true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Color result = JColorChooser.showDialog(null, "Choose Color...", myIconColor);
        myIconColor = result;
        putValue(Action.SMALL_ICON, new ColorIcon(SMALL_ICON_SIZE, myIconColor));
        myCanvas.setMyColor(myIconColor);
    }
}
