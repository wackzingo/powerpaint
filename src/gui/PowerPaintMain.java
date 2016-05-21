/*
 * TCSS 305 - Assignment 3: powerpaint-b 
 */
package gui;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * 
 * @author Zachariah WIngo
 * @version 1.0
 */
public final class PowerPaintMain {

    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private PowerPaintMain() {
        throw new IllegalStateException();
    }

    /**
     * The main method, invokes the PowerPaint GUI. Command line arguments are
     * ignored.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs) {
        try {
        // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (final UnsupportedLookAndFeelException e) {
            System.err.println(e);
        } catch (final ClassNotFoundException e) {
            System.err.println(e);
        } catch (final InstantiationException e) {
            System.err.println(e);
        } catch (final IllegalAccessException e) {
            System.err.println(e);
        }
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PowerPaintGUI().startGUI();
            }
        });
    }
}
