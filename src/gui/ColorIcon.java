/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;

/**
 * Creates an icon for the current color.
 * 
 * @author Zachariah Wingo
 * 
 * This code was an inner class copied and modified
 * from a larger class found on Stack Overflow.
 * 
 * @author trashGod (StackOverflow)
 * {@link} http://stackoverflow.com/a/3072979
 * 
 * @version 1.0
 */
public class ColorIcon implements Icon {

    /** The size of the icon. */
    private final int mySize;
    
    /** The currently selected color. */
    private final Color myColor;

    /**
     * Constructs a square color icon with a given size and color.
     * @param theSize the size of the icon.
     * @param theColor the color of the icon.
     */
    public ColorIcon(final int theSize, final Color theColor) {
        mySize = theSize;
        myColor = theColor;
    }

    @Override
    public void paintIcon(final Component theC, 
                          final Graphics theG, 
                          final int theX, 
                          final int theY) {
        
        final Graphics2D g2d = (Graphics2D) theG;
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(myColor);
        g2d.fillRect(theX, theY, mySize, mySize);
    }

    @Override
    public int getIconWidth() {
        return mySize;
    }

    @Override
    public int getIconHeight() {
        return mySize;
    }

}