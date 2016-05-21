/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package gui;

import actions.ColorAction;
import actions.ExitAction;
import actions.UndoAllAction;

import com.sun.glass.events.KeyEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * A menu bar for the Power Paint program.
 * @author Zachariah Wingo
 * @version 1.0
 *
 */
public class GUIMenuBar extends JMenuBar implements PropertyChangeListener {

    /** Constant representing the file menu. */
    public static final int FILE_MENU = 1;
    
    /** Constant representing the options menu. */
    public static final int OPTION_MENU = 2;
    
    /** Constant representing the tool menu. */
    public static final int TOOL_MENU = 3;
    
    /** Constant representing the help menu. */
    public static final int HELP_MENU = 4;
    
    /** About item text. */
    public static final String ABOUT_TEXT = "About…";

    /** Minimum Thickness. */
    private static final int MIN_THICKNESS = 0;
    
    /** Maximum Thickness. */
    private static final int MAX_THICKNESS = 20;
    
    /** Default Thickness. */
    private static final int DEFAULT_THICKNESS = 5;
    
    /** Major Tick Spacing. **/
    private static final int MAJOR_TICKS = 5;
    
    /** Minor Tick Spacing. **/
    private static final int MINOR_TICKS = 1;
    
    /** Auto generated serial version UID. */
    private static final long serialVersionUID = -8415608224405538966L;
    
    /** The View menu. */
    private final JMenu myFileMenu;
    
    /** The View menu. */
    private final JMenu myOptionsMenu;
    
    /** The View menu. */
    private final JMenu myToolMenu;
    
    /** The View menu. */
    private final JMenu myHelpMenu;
    
    /** Undo menu item. */
    private JMenuItem myUndoAllItem;
    
    /** A button group for radio buttons. */
    private final ButtonGroup myToolGroup;
    
    /**
     * Constructor for a menu bar.
     * @param theFrame is the frame that the menu bar will be added to.
     * @param theCanvas the canvas that actions may need to edit such as a clear/undo button.
     */
    public GUIMenuBar(final JFrame theFrame, final DrawingCanvas theCanvas) {
        super();
        myFileMenu    = new JMenu("File");

        myOptionsMenu = new JMenu("Options");

        myToolMenu    = new JMenu("Tools");

        myHelpMenu    = new JMenu("Help");

        myToolGroup   = new ButtonGroup();
        setMnemonics();
        setup(theFrame, theCanvas);
    }
    
    /**
     * Private helper method to set mnemonics.
     */
    private void setMnemonics() {
        myFileMenu.setMnemonic(KeyEvent.VK_F);
        myOptionsMenu.setMnemonic(KeyEvent.VK_O);
        myToolMenu.setMnemonic(KeyEvent.VK_T);
        myHelpMenu.setMnemonic(KeyEvent.VK_H);
    }
    
    /**
     * Sets up the menu bar.
     * @param theFrame the frame to use the menu bar.
     * @param theCanvas is needed for actions/buttons that modify the canvas such as undo all.
     */
    private void setup(final JFrame theFrame, final DrawingCanvas theCanvas) {
        // File Menu
        add(myFileMenu);
        myUndoAllItem = new JMenuItem(
                                  new UndoAllAction("Undo All Changes", theCanvas));
        myUndoAllItem.setEnabled(false);
        myFileMenu.add(myUndoAllItem);
        myFileMenu.addSeparator();
        myFileMenu.add(new JMenuItem(new ExitAction("Exit", theFrame)));

        // Options Menu
        add(myOptionsMenu);
        final JCheckBoxMenuItem squareCircleOnly = new JCheckBoxMenuItem("Square/Circle Only");
        squareCircleOnly.setMnemonic(KeyEvent.VK_S);
        squareCircleOnly.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                theCanvas.setSquareCircle(squareCircleOnly.isSelected());
            }
        });
        final JMenuItem chooseColor = new JMenuItem(new ColorAction(theCanvas));
        final JMenu thicknessMenu = new JMenu("Thickness");
        thicknessMenu.setMnemonic(KeyEvent.VK_T);
        
        // Slider setup
        final JSlider slider = new JSlider(SwingConstants.HORIZONTAL, MIN_THICKNESS,
                                                          MAX_THICKNESS,
                                                          DEFAULT_THICKNESS);
        slider.setMajorTickSpacing(MAJOR_TICKS);
        slider.setMinorTickSpacing(MINOR_TICKS);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                theCanvas.setMyStrokeWidth(slider.getValue());
                
            }
        });
        theCanvas.setMyStrokeWidth(slider.getValue());

        // Help Menu Items.
        final JMenuItem about = new JMenuItem(ABOUT_TEXT);
        about.setMnemonic(KeyEvent.VK_A);
        about.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(final ActionEvent theE) {
                JOptionPane.showMessageDialog(theFrame,  
                        "TCSS 305 PowerPaint\nWinter 2016\nZachariah Wingo",
                        ABOUT_TEXT,  JOptionPane.INFORMATION_MESSAGE,  
                        new ImageIcon("./images/uwlogo.png"));
                
            }
        });
        myHelpMenu.add(about);
        
        myOptionsMenu.add(squareCircleOnly);
        myOptionsMenu.addSeparator();
        myOptionsMenu.add(thicknessMenu);
        thicknessMenu.add(slider);
        myOptionsMenu.addSeparator();
        myOptionsMenu.add(chooseColor);
        
        // Tools Menu
        add(myToolMenu);
        
        // Help Menu
        add(myHelpMenu);
    }
    
    /** 
     * Creates buttons for the menu. 
     * @param theAction the action to add to the menu.
     * @param theMenu the menu where the button should be added.
     */
    public void createMenuButton(final Action theAction, final int theMenu) {
        
        switch (theMenu) {
            case FILE_MENU:
                final JMenuItem fileMenuItem = new JMenuItem(theAction);
                myFileMenu.add(fileMenuItem);
                
                break;
            case OPTION_MENU:
                final JMenuItem optionMenuItem = new JMenuItem(theAction);
                myOptionsMenu.add(optionMenuItem);
                break;
            case TOOL_MENU:
                final JRadioButtonMenuItem toolMenuItem = new JRadioButtonMenuItem(theAction);
                myToolGroup.add(toolMenuItem);
                myToolMenu.add(toolMenuItem);
                break;
            case HELP_MENU:
                final JMenuItem helpMenuItem = new JMenuItem(theAction);
                myHelpMenu.add(helpMenuItem);
                break;
            default:
                break;
        }

    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        
        if ("Undo All".equals(theEvent.getPropertyName())) {
            if ((boolean) theEvent.getNewValue()) {
                myUndoAllItem.setEnabled(true);
            } else {
                myUndoAllItem.setEnabled(false);
            }
        }
        
    }

}
