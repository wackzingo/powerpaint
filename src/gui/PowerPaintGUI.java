/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package gui;

import actions.ToolAction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import tools.Ellipse;
import tools.Line;
import tools.Pencil;
import tools.Rectangle;

/**
 * 
 * @author Zachariah WIngo
 * @version 1.0
 */
public final class PowerPaintGUI extends JFrame {

    /**
     * Serial version ID.
     */
    private static final long serialVersionUID = 702322619118744267L;
    
    /** JFrame Text. */
    private static final String APPLICATION_NAME = "PowerPaint";

    /** The default directory for images. */
    private static final String ICONS_DIR = "./images/";
    
    /** The area for the mouse demonstration. */
    private final DrawingCanvas myCanvas;
    
    /** List of tool actions. */
    private final List<Action> myToolActions;
    
    /** Tool bar. */
    private final GUIToolBar myTools;
     
    /**
     * Constructor - takes no arguments.
     */
    public PowerPaintGUI() {
        super();
        setTitle(APPLICATION_NAME);
        setIconImage(new ImageIcon(ICONS_DIR + "/uwlogo.png").getImage());
        myCanvas =  new DrawingCanvas(Color.WHITE);
        myToolActions = new ArrayList<Action>();
        myTools = new GUIToolBar();
    }
    
    /**
     * Initiate creation of GUI elements.
     */
    public void startGUI() {
        // Default Close Operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Initiates the creation and layout of GUI components.
        setUpComponents();
        
        //Display the window.
        pack();
        setVisible(true);    
    }
    
    
    /**
     * Lay out the components.
     */
    private void setUpComponents() {

        // Creates a menu bar.
        final GUIMenuBar menuBar = new GUIMenuBar(this, myCanvas);
        setJMenuBar(menuBar);
        myCanvas.addPropertyChangeListener(menuBar);
        
        // Creates all actions and adds them to their action lists.
        createActions();
        
        // Loops through the tool actions and adds them to the tools menu and toolbar.
        for (final Action toolAction : myToolActions) {
            menuBar.createMenuButton(toolAction, GUIMenuBar.TOOL_MENU);
            myTools.createToolBarButton(toolAction);
        }
        
        // Add the canvas and tool bar to the frame.
        add(myTools, BorderLayout.SOUTH);
        add(myCanvas, BorderLayout.CENTER);
        
    }
    
    /**
     * Helper method creates actions for tools and adds them to the toolActions list.
     */
    private void createActions() {
        myToolActions.add(new ToolAction(myCanvas, new Pencil()));
        myToolActions.add(new ToolAction(myCanvas, new Line()));
        myToolActions.add(new ToolAction(myCanvas, new Rectangle()));
        myToolActions.add(new ToolAction(myCanvas, new Ellipse()));
    }
}
