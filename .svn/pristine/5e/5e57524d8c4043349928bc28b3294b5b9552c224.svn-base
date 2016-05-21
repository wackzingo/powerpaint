/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


/**
 * Creates a Ellipse.
 * @author Zachariah Wingo
 * @version 1.0
 */
public class Ellipse extends Rectangle {

    /** Flag for circle. */
    private boolean myCircle;
    
    /**
     * Constructs a Ellipse.
     */
    public Ellipse() {
        super("Ellipse");
        setStartPoint(new Point());
        setEndPoint(new Point());
    }

    /**
     * Sets circle flag.
     * @param theFlag set True for circle only. False for ellipse.
     */
    public void setCircle(final boolean theFlag) {
        myCircle = theFlag;
    }
    
    /**
     * Draws an Ellipse.
     * @return returns an Ellipse2D shape.
     */
    public Shape getShape() {
        
        final Rectangle2D.Double rect = (Rectangle2D.Double) super.getShape();
        Ellipse2D.Double ellipse;
        
        if (myCircle) {
            ellipse = new Ellipse2D.Double(rect.getX(), 
                                           rect.getY(), 
                                           rect.getWidth(), 
                                           rect.getWidth());
        } else {
            ellipse = new Ellipse2D.Double(rect.getX(), 
                                           rect.getY(), 
                                           rect.getWidth(), 
                                           rect.getHeight());
        }
        
        return ellipse;
    }
}
