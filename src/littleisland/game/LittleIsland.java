package littleisland.game;

import littleisland.data.World;
import littleisland.node.KeyHandler;
import littleisland.node.Mining;
import littleisland.node.Player;
import littleisland.node.TileHighlight;
import littleisland.res.Textures;
import realms.window.Loop;
import realms.window.Realm;

import java.io.IOException;

public class LittleIsland
{
	public LittleIsland() throws IOException
	{

		Game.realm = new Realm(Game.INFO, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
		Textures.load();
		Game.worldInfo = World.fromFile("world/town.liw");
		Game.tileWorld = Game.worldInfo.toTileWorld();
		Game.player = new Player();
		new KeyHandler();
		Game.player.setPosition(24, 16);
		Game.tileHighlight = new TileHighlight();
		Game.mining = new Mining();

		Game.realm.run(new Loop());
	}

	public static void main(String[] args) throws IOException
	{
		new LittleIsland();
	}
}
