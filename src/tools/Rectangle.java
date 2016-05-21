/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package tools;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * Creates a Rectangle.
 * @author Zachariah Wingo
 * @version 1.0
 */
public class Rectangle extends AbstractTool {
    
    /**
     * Sets rectangle to produce only squares.
     */
    private boolean mySquare;
    
    /**
     * Constructs a rectangle.
     */
    public Rectangle() {
        super("Rectangle");
    }
    
    /**
     * Constructor.
     * @param theName name of the type of rectangle.
     */
    public Rectangle(final String theName) {
        super(theName);
    }
    
    /**
     * Sets square flag.
     * @param theFlag true sets rectangle to produce a square. False produces rectangle.
     */
    public void setSquare(final boolean theFlag) {
        mySquare = theFlag;
    }
    /**
     * Draws and returns a rectangle.
     * @return return a rectangle shape.
     */
    public Shape getShape() {
        
        final Double startX = getStartPoint().getX();
        final Double startY = getStartPoint().getY();
        final Double endX = getEndPoint().getX();
        final Double endY = getEndPoint().getY();
        
        Rectangle2D.Double rect;

        if (mySquare) {
            final double size = Math.min(Math.abs(startX - endX), Math.abs(startY - endY));
            if (endX < startX && endY < startY) {
                rect = new Rectangle2D.Double(startX - size, startY - size, size, size);
            } else if (endX < startX && endY > startY) {
                rect = new Rectangle2D.Double(startX - size, startY, size, size);
            } else if (startX < endX && startY < endY) {
                rect = new Rectangle2D.Double(startX, startY, size, size);
            } else {
                rect = new Rectangle2D.Double(startX, startY - size, size, size);
            }
        } else {
            if (endX < startX && endY < startY) {
                rect = new Rectangle2D.Double(endX, endY, 
                           Math.abs(startX - endX), Math.abs(startY - endY));
            } else if (endX < startX && endY > startY) {
                rect = new Rectangle2D.Double(endX, startY, 
                           Math.abs(startX - endX), Math.abs(startY - endY));
            } else if (startX < endX && startY < endY) {
                rect = new Rectangle2D.Double(startX, startY, 
                           Math.abs(endX - startX), Math.abs(endY - startY));
            } else {
                rect = new Rectangle2D.Double(startX, endY, 
                           Math.abs(endX - startX), Math.abs(endY - startY));
            }
        }
        
        return rect;
    }
}
