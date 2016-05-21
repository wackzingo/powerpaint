/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package tools;

import java.awt.BasicStroke;
import java.awt.Point;
import java.awt.Stroke;

import javax.swing.ImageIcon;

/**
 * Abstract superclass for all tools. 
 * @author Zachariah Wingo
 * @version 1.0
 */
public abstract class AbstractTool implements Tool {

    /**
     * Default Starting point.
     * 
     */
    public static final int DEFAULT_START = -100;
    
    /**
     * Default Stroke Width.
     */
    public static final int DEFAULT_STROKE_WIDTH = 5;
    
    /**
     * The type of stroke.  
     */
    protected BasicStroke myStrokeType;
    
    /**
     * The description of this tool (will be used on buttons).
     */
    private final String myDescription;
    
    /**
     * The icon for this tool.
     */
    private final ImageIcon myToolIcon;
    
    /**
     * Starting point.
     */
    private Point myStartPoint;

    /**
     * Ending point.
     */
    private Point myEndPoint;
    
    /**
     * Constructs a tool with the specified description.
     * 
     * @param theDescription The description.
     */
    public AbstractTool(final String theDescription) {
        super();
        myDescription = theDescription;
        myToolIcon = new ImageIcon("./images/" + getClass().getSimpleName() + "_bw.gif");
        myStartPoint = new Point(DEFAULT_START, DEFAULT_START);
        myEndPoint = new Point(DEFAULT_START, DEFAULT_START);
        myStrokeType = new BasicStroke(DEFAULT_STROKE_WIDTH);
    }
    
    /**
     * Returns the text description of this tool.
     * 
     * @return the text description of this tool
     */
    @Override
    public String getDescription() {
        return myDescription;
    }
    
    /**
     * Returns image icon for tool.
     * 
     * @return the image icon of this tool.
     */
    public ImageIcon getToolIcon() {
        return myToolIcon;
    }
    
    /**
     * Sets the starting point of the shape.
     * @param theStartPoint the starting point for the shape.
     */
    public void setStartPoint(final Point theStartPoint) {
        myStartPoint = new Point(theStartPoint.x, theStartPoint.y);
    }
    
    /**
     * Sets the ending point of the shape.
     * 
     * @param theEndPoint sets the ending point for the shape.
     */
    public void setEndPoint(final Point theEndPoint) {
        myEndPoint = new Point(theEndPoint.x, theEndPoint.y);
    }
    
    /**
     * Sets the stroke width.
     * @param theStrokeWidth takes a float representing the stroke width.
     */
    public void setBasicStroke(final float theStrokeWidth) {
        myStrokeType = new BasicStroke(theStrokeWidth);
    }
    
    /**
     * Gets a BasicStroke for the tool.
     * @return returns a new BasicStroke for the tool.
     */
    public Stroke getBasicStroke() {
        return myStrokeType;
    }
    
    /**
     * Gets the starting point of the shape.
     * @return returns the starting point of the shape.
     */
    public Point getStartPoint() {
        return new Point(myStartPoint.x, myStartPoint.y);
    }
    
    /**
     * Gets the ending point of the shape.
     * @return returns the ending point of the shape.
     */
    public Point getEndPoint() {
        return new Point(myEndPoint.x, myEndPoint.y);
    }

}