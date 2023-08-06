package game;

import java.awt.Color;

import draw.Window;
import world.Generation;
import world.World;

// This class contains the game loop and game initialising code.
public class Game
{

	public Window window;

	public World world;

	public Game()
	{
		// Create a new Window instance.
		// We will use this object every time we draw to the screen.
		Window window = new Window("Little Island", 1600, 900);
		window.fill(Color.WHITE);

		// Generate the world:
		Generation.genIsland();
	}

	public void loop()
	{

	}

}
