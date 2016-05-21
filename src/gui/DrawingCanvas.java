/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import tools.DrawnShapes;
import tools.Ellipse;
import tools.Pencil;
import tools.Rectangle;
import tools.Tool;


/**
 * Creates a blank canvas for drawing.
 *  @author Zachariah Wingo
 *  @version 1.0
 */
public class DrawingCanvas extends JPanel {
    
    /**  A generated serial version UID for object Serialization. */
    private static final long serialVersionUID = 8211830013025253612L;

    /** The default width value. */
    private static final int WIDTH = 500; 
    
    /** The default height value. */
    private static final int HEIGHT = 400;
    
    /** Default Start when not in use. */
    private static final int DEFAULT_START = -100;
    
    /** Minimum stroke width. */
    private static final float MIN_STROKE = 0.5f;
    
    /** The minimum size this component should be. */
    private static final Dimension MIN_SIZE = new Dimension(WIDTH, HEIGHT);
    
    /** Undo all item name. */
    private static final String UNDO_ALL = "Undo All";
    
    /** Current Tool. */
    private Tool myTool;
    
    /** Current Color. */
    private Color myColor;
    
    /** Stroke width. */
    private float myStrokeWidth;
    
    /** List of drawn shapes. */
    private final List<DrawnShapes> myShapes;
    
    /** Canvas clear status. */
    private boolean myClearStatus;
    
    /** Is square / circle checked. */
    private boolean mySquareCircle;
    
    /**
     * Constructs a BlankArea given the color.
     * 
     * @param theColor the color to set this area to
     */
    public DrawingCanvas(final Color theColor) {
        super();
        setBackground(theColor);
        setOpaque(true);
        myShapes = new ArrayList<DrawnShapes>();
        final MouseInputAdapter mia = new MyMouseInputAdapter();
        addMouseListener(mia);
        addMouseMotionListener(mia);
        myTool = new Pencil();
        myClearStatus = false;
    }
 
    
    /**
     * Get minimum size.
     */
    @Override
    public Dimension getMinimumSize() {
        return MIN_SIZE;
    }
 
    
    /**
     * Get preferred size.
     */
    @Override
    public Dimension getPreferredSize() {
        return MIN_SIZE;
    }
    
    @Override
    public void paintComponent(final Graphics theG) {
        super.paintComponent(theG);
        final Graphics2D g2d = (Graphics2D) theG;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias!
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (!myShapes.isEmpty()) {
            for (final DrawnShapes s : myShapes) {
                g2d.setStroke(s.getStroke());
                g2d.setColor(s.getColor());
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias!
                                     RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.draw(s.getShape());
            }
            myClearStatus = true;
        }
        if (myTool.getShape() != null && (Math.abs(0 - myStrokeWidth) > MIN_STROKE)) {
            g2d.setColor(myColor);
            g2d.setStroke(myTool.getBasicStroke());
            g2d.draw(myTool.getShape());
        }
        
        
    }
    
    
    /**
     * Sets the current tool.
     * @param theTool the tool being used to draw on canvas.
     */
    public void setTool(final Tool theTool) {
        myTool = theTool;
    }
    
    /**
     * Sets the current color.
     * @param theColor the current color.
     */
    public void setMyColor(final Color theColor) {
        myColor = theColor;
    }

    
    /**
     * Sets the stroke for the shape to be drawn.
     * @param theStrokeWidth an integer representing the stroke width;
     */
    public void setMyStrokeWidth(final int theStrokeWidth) {
        myStrokeWidth = theStrokeWidth;
    }
    
    
    /**
     * Set the stroke width.
     */
    public void setMyStroke() {
        myTool.setBasicStroke(myStrokeWidth);
    }
    
    /**
     * Sets flag for squareCircle.
     * @param theFlag set True for square/circle and false for rectangle/ellipse.
     */
    public void setSquareCircle(final boolean theFlag) {
        mySquareCircle = theFlag;
    }
    
    /**
     * Returns the status of the square circle flag.
     * @return returns the status of the square and circle flag.
     */
    public boolean isSqureCircle() {
        return mySquareCircle;
    }
    
    /**
     * Clears the Canvas.
     */
    public void clearCanvas() {
        myShapes.clear();
        myClearStatus = false;
        repaint();
        firePropertyChange(UNDO_ALL, null, myClearStatus);
    }
    
    /**
     * Inner class for mouse listeners.
     * @author Zachariah Wingo
     *
     */
    private class MyMouseInputAdapter extends MouseInputAdapter {

        /**
         * Constructor needed to set cursor.
         */
        MyMouseInputAdapter() {
            super();
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
        
        @Override
        public void mousePressed(final MouseEvent thePressedEvent) {
            setMyStroke();
            myTool.setStartPoint(thePressedEvent.getPoint());
            myTool.setEndPoint(thePressedEvent.getPoint());
            myClearStatus = true;
            if (myTool instanceof Rectangle || myTool instanceof Ellipse) {
                ((Rectangle) myTool).setSquare(isSqureCircle());
            }
            firePropertyChange(UNDO_ALL, null, myClearStatus);
        }
     
        @Override
        public void mouseDragged(final MouseEvent theDraggedEvent) {
            myTool.setEndPoint(theDraggedEvent.getPoint());
            repaint();
        }
       
        @Override
        public void mouseReleased(final MouseEvent theReleasedEvent) {
            myTool.setEndPoint(theReleasedEvent.getPoint());
            
            // Only save the shape if the stroke with is great than the minimum.
            if (Math.abs(0 - myStrokeWidth) > MIN_STROKE) {
                myShapes.add(new DrawnShapes(myColor, myTool.getShape(), 
                                             myTool.getBasicStroke()));
            }
            myTool.setStartPoint(new Point(DEFAULT_START, DEFAULT_START));
            myTool.setEndPoint(new Point(DEFAULT_START, DEFAULT_START));

        }
    
    }

}