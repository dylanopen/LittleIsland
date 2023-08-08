package draw;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Sprite
{

	private ImageIcon imageIcon;
	private Image image;

	public Sprite(Window window, String imagePath)
	{

		imageIcon = new ImageIcon(imagePath);
		image = imageIcon.getImage();
	}

	public void draw()
	{
		System.out.println(image.toString());
	}
	
}
