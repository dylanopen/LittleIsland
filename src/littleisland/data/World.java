package littleisland.data;

import littleisland.game.Game;
import littleisland.game.LittleIsland;
import littleisland.res.Textures;
import realms.node.TileWorldNode;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class World
{
	public static World fromFile(String filepath)
	{
		World world = new World();
		List<Integer> ints = readFileInts(filepath);
		world.columns = ints.get(0);
		world.rows = ints.get(1);
		world.tiles = ints.subList(2, ints.size());
		return world;
	}

	private static List<Integer> readFileInts(String filepath)
	{
		ArrayList<Integer> ints = new ArrayList<>();

		InputStream stream = Objects.requireNonNull(LittleIsland.class.getClassLoader().getResourceAsStream(filepath));
		Scanner fileReader = new Scanner(stream);

		while (fileReader.hasNextInt())
		{
			ints.add(fileReader.nextInt());
		}

		return ints;
	}

	public int columns;
	public int rows;
	public List<Integer> tiles;

	public TileWorldNode toTileWorld()
	{
		return new TileWorldNode(
			0, 0, Game.worldInfo.columns, Game.worldInfo.rows,
			Game.TILE_SIZE, Game.TILE_SIZE,
			Textures.tileSet, tiles
		);
	}
}
