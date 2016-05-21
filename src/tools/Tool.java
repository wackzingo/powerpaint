/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;

/**
 * Interface for drawing tools.
 * @author Zachariah Wingo
 * @version 1.0
 */
public interface Tool {

    /**
     * The short name of the tool.
     * @return the name of the tool.
     */
    String getDescription();
    
    /**
     * The shape of the tool.
     * @return returns the shape of the tool that has been drawn.
     */
    Shape getShape();
    
    /**
     * Sets the starting point of the shape to be drawn.
     * @param theStartPoint the starting point of the shape to be drawn.
     */
    void setStartPoint(Point theStartPoint);
    
    /**
     * Sets the ending point of the shape to be drawn.
     * @param theEndPoint sets the ending point of the shape to be drawn.
     */
    void setEndPoint(Point theEndPoint);
    
    /**
     * Sets the stroke width of the shape to be drawn.
     * @param theStrokeWidth sets the stroke width of the shape to be drawn.
     */
    void setBasicStroke(float theStrokeWidth);
    
    /**
     * Gets the stroke the shape should be drawn with.
     * @return returns a basic stroke the shape should be drawn with.
     */
    Stroke getBasicStroke();
}
