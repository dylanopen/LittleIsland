package littleisland.res;

import realms.data.Texture;
import realms.data.TextureSet;

import java.io.IOException;

public class Textures
{
	public static TextureSet tileSet;

	public static Texture[] playerUpFrames;
	public static Texture[] playerDownFrames;
	public static Texture[] playerLeftFrames;
	public static Texture[] playerRightFrames;

	public static Texture[] miningFrames;

	public static void load() throws IOException
	{
		loadTiles();
		loadPlayerSprites();
		loadMiningSprites();
	}

	public static void loadTiles() throws IOException
	{
		tileSet = new TextureSet(new Texture[]{
			new Texture("tile/0.png"),
			new Texture("tile/1.png"),
			new Texture("tile/2.png"),
			new Texture("tile/blank.png"),
			new Texture("tile/4.png"),
			new Texture("tile/5.png"),
			new Texture("tile/6.png"),
			new Texture("tile/7.png"),
			new Texture("tile/8.png"),
			new Texture("tile/9.png"),
			new Texture("tile/10.png"),
			new Texture("tile/11.png"),
			new Texture("tile/12.png"),
			new Texture("tile/13.png"),
			new Texture("tile/14.png"),
			new Texture("tile/15.png"),
			new Texture("tile/blank.png"),
			new Texture("tile/17.png"),
			new Texture("tile/18.png"),
			new Texture("tile/19.png"),
			new Texture("tile/20.png"),
			new Texture("tile/21.png"),
		});
	}

	public static void loadPlayerSprites() throws IOException
	{
		playerUpFrames = new Texture[]{
			new Texture("player/up1.png"),
			new Texture("player/up2.png"),
		};
		playerDownFrames = new Texture[]{
			new Texture("player/down1.png"),
			new Texture("player/down2.png"),
		};
		playerLeftFrames = new Texture[]{
			new Texture("player/left1.png"),
			new Texture("player/left2.png"),
		};
		playerRightFrames = new Texture[]{
			new Texture("player/right1.png"),
			new Texture("player/right2.png"),
		};
	}

	public static void loadMiningSprites() throws IOException
	{
		miningFrames = new Texture[]{
			new Texture("mining/0.png"),
			new Texture("mining/1.png"),
			new Texture("mining/2.png"),
			new Texture("mining/3.png"),
			new Texture("mining/4.png"),
			new Texture("mining/5.png"),
			new Texture("mining/6.png"),
			new Texture("mining/7.png"),
			new Texture("mining/8.png"),
			new Texture("mining/9.png"),
		};
	}
}
