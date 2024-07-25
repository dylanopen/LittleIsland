package littleisland.node;

import littleisland.game.Game;
import littleisland.res.Textures;
import littleisland.tile.TileInfo;
import realms.data.Time;
import realms.input.Mouse;
import realms.node.Node;
import realms.node.SpriteNode;

public class Mining extends Node
{
	private int tileX = -1;
	private int tileY = -1;
	private double miningProgress = 0.0;
	private final SpriteNode miningIndicator;

	public Mining()
	{
		super();
		miningIndicator = new SpriteNode(
			tileX*Game.TILE_SIZE, tileY*Game.TILE_SIZE,
			Game.TILE_SIZE+1, Game.TILE_SIZE+1,
			Textures.miningFrames[0]
		);
	}

	public static void mine(int tileX, int tileY)
	{
		Game.tileWorld.set(tileX, tileY, 0); // set to grass
	}

	public void update()
	{
		super.update();

		// TODO: mining animation using 10 transparent PNGs.

		if (Mouse.isDown)
		{
			int oldTileX = tileX;
			int oldTileY = tileY;
			tileX = TileInfo.getTileXOnScreen(Mouse.x);
			tileY = TileInfo.getTileYOnScreen(Mouse.y);

			miningIndicator.x = tileX * Game.TILE_SIZE;
			miningIndicator.y = tileY * Game.TILE_SIZE;

			if (oldTileX != tileX || oldTileY != tileY)
				miningProgress = 0.0;

			int tileType = Game.tileWorld.get(tileX, tileY);

			// TODO: use TileInfo to adjust speed based on equipped tool.
			miningProgress += TileInfo.miningSpeed(tileType) * Time.delta;

			if (miningProgress >= 1.0)
			{
				Mining.mine(tileX, tileY);
				miningProgress = 0.0;
			}

			int animationFrame = (int) (miningProgress/0.1);
			miningIndicator.texture = Textures.miningFrames[animationFrame];
		}
		else
		{
			miningIndicator.x = -Game.TILE_SIZE;
			miningIndicator.y = -Game.TILE_SIZE;
		}
	}
}
