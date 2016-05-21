/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package tools;

import java.awt.BasicStroke;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Path2D;

/**
 * Creates a Pencil.
 * @author Zachariah Wingo
 * @version 1.0
 */
public class Pencil extends AbstractTool {

    /**
     * Stores the current path being drawn.
     */
    private Path2D.Double myPath;
    
    /**
     * Constructs a pencil.
     */
    public Pencil() {
        super("Pencil");
        myPath = new Path2D.Double();
    }
    
    @Override
    public void setStartPoint(final Point theStartPoint) {
        myPath = new Path2D.Double();
        myPath.moveTo(theStartPoint.getX(), theStartPoint.getY());
    }
    
    @Override
    public void setEndPoint(final Point theEndPoint) {
        myPath.lineTo(theEndPoint.getX(), theEndPoint.getY());
    }
    
    @Override
    public void setBasicStroke(final float theStrokeWidth) {
        myStrokeType = new BasicStroke(theStrokeWidth, 
                                       BasicStroke.CAP_SQUARE,
                                       BasicStroke.JOIN_BEVEL);
    }
    
    @Override
    public Stroke getBasicStroke() {
        return myStrokeType;
    }

    /**
     * Gets the shape of the path.
     * @return returns the shape of the path that has been drawn.
     */
    public Shape getShape() {
        return myPath;
    }
}
