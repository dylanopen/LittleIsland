package littleisland.node;

import littleisland.game.Game;
import littleisland.tile.TileInfo;
import realms.data.Colour;
import realms.input.Mouse;
import realms.node.Node;
import realms.node.RectangleNode;
import realms.node.RectangleOutlineNode;

public class TileHighlight extends Node
{
	public static Colour fillColour = new Colour(255, 255, 255, 32);
	public static Colour outlineColour = new Colour(255, 255, 255);

	private final RectangleNode fill;
	private final RectangleOutlineNode outline;

	public TileHighlight()
	{
		super(0, 0, Game.TILE_SIZE, Game.TILE_SIZE);
		fill = new RectangleNode(0, 0, Game.TILE_SIZE, Game.TILE_SIZE, TileHighlight.fillColour);
		outline = new RectangleOutlineNode(0, 0, Game.TILE_SIZE, Game.TILE_SIZE, TileHighlight.outlineColour);
		addChild(fill);
		addChild(outline);
	}

	public void update()
	{
		super.update();
		int tileX = TileInfo.getTileXOnScreen(Mouse.x);
		int tileY = TileInfo.getTileYOnScreen(Mouse.y);
		x = tileX * Game.TILE_SIZE;
		y = tileY * Game.TILE_SIZE;

		// only show if in reach
		visible = TileInfo.playerCanReach(tileX, tileY);
	}
}
