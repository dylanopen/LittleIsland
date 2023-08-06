package draw;

import javax.swing.JFrame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

// This class spawns a new game window.
// This window can be used to add sprites, text, etc.
// Note: do not call GameWindow directly, create an object instance first.
public class Window
{

	public JFrame frame;
	public Container pane;
	public Canvas canvas;
	public Graphics canvasGraphics;

	// Constructor to create a new window:
	public Window(String title, int width, int height)
	{
		// Create the main frame and get its content pane
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
		pane = frame.getContentPane();

		canvas = new Canvas();
		canvasGraphics = canvas.getGraphics();

		// Add the canvas to the frame:
		frame.add(canvas);
		frame.pack();
	}

	// Fill the screen with a specific colour:
	public void fill(Color colour)
	{
		pane.setBackground(colour);
	}

}
