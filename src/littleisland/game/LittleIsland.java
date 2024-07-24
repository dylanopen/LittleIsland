package littleisland.game;

import littleisland.data.World;
import littleisland.node.KeyHandler;
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
//		debugFixTiledMap();

		Game.realm = new Realm(Game.INFO, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
		Textures.load();
		Game.worldInfo = World.fromFile("world/town.liw");
		Game.tileWorld = Game.worldInfo.toTileWorld();
		Game.player = new Player();
		new KeyHandler();
		Game.player.displace(8, 8, 1);
		Game.tileHighlight = new TileHighlight();

		Game.realm.run(new Loop());
	}

//	public static void debugFixTiledMap() throws IOException
//	{
//		String oldData = Files.read("world/town.liw");
//		String newData = "300 200\n" + oldData.replace(",", " ");
//		Files.write("world/town.liw", newData);
//	}

	public static void main(String[] args) throws IOException
	{
		new LittleIsland();
	}
}
