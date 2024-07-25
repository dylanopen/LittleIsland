package littleisland.tile;

import littleisland.game.Game;

public class TileInfo
{
	public static int[] barrierTiles = {1, 21};

	public static double minReach = 0.0;
	public static double maxReach = 4.0;

	public static double distanceFromPlayer(int tileX, int tileY)
	{
		int playerTileX = (int) (Game.realm.getWindow().getWidth()/2 + Game.realm.cameraX) / Game.TILE_SIZE;
		int playerTileY = (int) (Game.realm.getWindow().getHeight()/2 + Game.realm.cameraY) / Game.TILE_SIZE;
		int dx = playerTileX - tileX;
		int dy = playerTileY - tileY;

		return Math.sqrt(
			Math.pow(dx, 2)
			+ Math.pow(dy, 2)
		);
	}

	// TODO: check for obstructions in path to reach tile (hard)
	public static boolean playerCanReach(int tileX, int tileY)
	{
		if (distanceFromPlayer(tileX, tileY) > maxReach)
			return false;
		if (distanceFromPlayer(tileX, tileY) < minReach)
			return false;
		return true;
	}
}
