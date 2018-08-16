package sortVisualiser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;
import sortVisualiser.algorithms.BubbleSort;

/**
 * Canvas where the sortable array is drawn
 * @author Matt Hopson
 */ 
public class ArrayCanvas extends JPanel {
    public static final int WIN_WIDTH = 1280;
    public static final int WIN_HEIGHT = 720;
    private static final int BAR_WIDTH = 8;
    private static final int NUM_BARS = WIN_WIDTH / BAR_WIDTH;
    
    private SortArray array;
    
    /**
     * Creates and sets the values of the array
     */
    public ArrayCanvas() {
        setBackground(Color.darkGray);
        array = new SortArray(NUM_BARS, this);
    }
    
    public void run() {
        new BubbleSort().runSort(array);
    }
    
    /**
     * Draws the array
     * @param g The graphics device for drawing
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);
       
        graphics.setColor(Color.white);
        for (int x = 0; x < NUM_BARS; x++) {
            int height = array.getValue(x) * 3;
            int xBegin = x + (BAR_WIDTH - 1) * x;
            int yBegin = WIN_HEIGHT - height;
            
            graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);
        }
    }
    
    /**
     * Gets the canvas size
     * @return size
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT);
    }
}