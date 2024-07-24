package littleisland.tile;

import littleisland.game.Game;

import java.util.stream.IntStream;

public class TileEvent
{
	public static void touch(int tileType)
	{
		IntStream barrierTilesStream = IntStream.of(TileInfo.barrierTiles);

		if (barrierTilesStream.anyMatch(barrierTile -> barrierTile == tileType))
			Game.player.canMove = false;
	}
}
