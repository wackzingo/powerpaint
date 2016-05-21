/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * Creates a Line.
 * @author Zachariah Wingo
 * @version 1.0
 */
public class Line extends AbstractTool {

    /**
     * Constructs a Line.
     */
    public Line() {
        super("Line");
        setStartPoint(new Point(0, 0));
        setEndPoint(new Point(0, 0));
    }
    
    /**
     * Returns the shape of the line that has been drawn.
     * @return returns the shape of the line that has been drawn.
     */
    public Shape getShape() {
        
        return new Line2D.Double(getStartPoint(), getEndPoint());
    }
}
