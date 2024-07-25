package littleisland.game;

import littleisland.data.World;
import littleisland.node.Player;
import littleisland.node.TileHighlight;
import realms.node.TileWorldNode;
import realms.window.Realm;

public class Game
{
	public static final String INFO = "Little Island v0.0.3";
	public static final int WINDOW_WIDTH = 1600;
	public static final int WINDOW_HEIGHT = 900;
	public static final int TILE_SIZE = 64;
	public static final int PLAYER_SIZE = 48;
	public static final double PLAYER_SPEED = 5.0;
	public static final double PLAYER_SPRINT_MULTIPLIER = 3.0;

	public static Realm realm;
	public static World worldInfo;
	public static TileWorldNode tileWorld;
	public static Player player;
	public static TileHighlight tileHighlight;
}
