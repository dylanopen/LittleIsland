package littleisland.node;

import littleisland.res.Textures;
import realms.input.Keyboard;
import realms.node.Node;

import java.awt.event.KeyEvent;
import java.io.IOException;

public class KeyHandler extends Node
{
	public void update()
	{
		if (Keyboard.isDown(KeyEvent.VK_R)) {
			try
			{
				Textures.load();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
