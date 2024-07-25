package littleisland.node;

import littleisland.game.Game;
import littleisland.res.Textures;
import littleisland.tile.TileEvent;
import realms.data.Direction;
import realms.data.Time;
import realms.input.Keyboard;
import realms.node.DirectionAnimatedSpriteNode;
import realms.node.Node;

import java.awt.event.KeyEvent;
import java.util.stream.IntStream;

public class Player extends Node
{
	public static double initialX = Game.WINDOW_WIDTH / 2.0 - Game.PLAYER_SIZE/2.0;
	public static double initialY = Game.WINDOW_HEIGHT / 2.0 - Game.PLAYER_SIZE/2.0;
	public static int animationFrequency = 45;

	public DirectionAnimatedSpriteNode sprite;
	private double velocityX, velocityY;
	public boolean canMove;
	private double playerSpeed;

	public Player()
	{
		super();
		sprite = new DirectionAnimatedSpriteNode(
			Player.initialX, Player.initialY, Game.PLAYER_SIZE, Game.PLAYER_SIZE,
			Textures.playerUpFrames, Textures.playerDownFrames, Textures.playerLeftFrames, Textures.playerRightFrames,
			Player.animationFrequency
		);
	}

	public void update()
	{
		updateVelocity();
		displace(velocityX, velocityY, playerSpeed * Time.delta);
		handleCollisions();
		if (!canMove)
			displace(-velocityX, -velocityY, playerSpeed * Time.delta);
	}

	public void displace(double velocityX, double velocityY, double speedModifier)
	{
		double dispX = velocityX * speedModifier * Game.TILE_SIZE;
		double dispY = velocityY * speedModifier * Game.TILE_SIZE;

		Game.realm.cameraX += dispX;
		Game.realm.cameraY += dispY;
		sprite.x += dispX;
		sprite.y += dispY;
	}

	public void setPosition(double tileX, double tileY)
	{
		Game.realm.cameraX = tileX * Game.TILE_SIZE - Game.realm.getWindow().getWidth()/2.0;
		Game.realm.cameraY = tileY * Game.TILE_SIZE - Game.realm.getWindow().getHeight()/2.0;
		sprite.x = tileX * Game.TILE_SIZE + Player.initialX - Game.realm.getWindow().getWidth()/2.0;
		sprite.y = tileY * Game.TILE_SIZE + Player.initialY - Game.realm.getWindow().getHeight()/2.0;
	}

	private void updateVelocity()
	{
		playerSpeed = Game.PLAYER_SPEED;

		velocityX = 0;
		velocityY = 0;

		if (Keyboard.isDown(KeyEvent.VK_QUOTE))
			playerSpeed *= Game.PLAYER_SPRINT_MULTIPLIER;

		if (Keyboard.isDown(KeyEvent.VK_W))
			velocityY -= 1.0;
		if (Keyboard.isDown(KeyEvent.VK_S))
			velocityY += 1.0;
		if (Keyboard.isDown(KeyEvent.VK_A))
			velocityX -= 1.0;
		if (Keyboard.isDown(KeyEvent.VK_D))
			velocityX += 1.0;

		sprite.direction = Direction.Down;
		if (velocityY < 0.0)
			sprite.direction = Direction.Up;
		if (velocityX < 0.0)
			sprite.direction = Direction.Left;
		if (velocityX > 0.0)
			sprite.direction = Direction.Right;

		if (velocityX != 0 && velocityY != 0)
		{
			// Pythagoras - Fix diagonal movement
			velocityX *= Math.sqrt(2) * 0.5;
			velocityY *= Math.sqrt(2) * 0.5;
		}
	}

	private void handleCollisions()
	{
		canMove = true; // default, may be reassigned.

		int playerTopLeftTilePos = Game.tileWorld.getAtPixel(
			sprite.getX(),
			sprite.getY()
		);
		int playerTopRightTilePos = Game.tileWorld.getAtPixel(
			sprite.getX() + sprite.width,
			sprite.getY()
		);
		int playerBottomLeftTilePos = Game.tileWorld.getAtPixel(
			sprite.getX(),
			sprite.getY() + sprite.height
		);
		int playerBottomRightTilePos = Game.tileWorld.getAtPixel(
			sprite.getX() + sprite.width,
			sprite.getY() + sprite.height
		);

		int[] playerTilePositions = new int[]{
			playerTopLeftTilePos, playerTopRightTilePos, playerBottomLeftTilePos, playerBottomRightTilePos
		};

		if (IntStream.of(playerTilePositions).noneMatch(x -> x < 0))
		{
			int[] tilesTouching = {
				Game.tileWorld.get(playerTopLeftTilePos),
				Game.tileWorld.get(playerTopRightTilePos),
				Game.tileWorld.get(playerBottomLeftTilePos),
				Game.tileWorld.get(playerBottomRightTilePos)
			};


			for (int tileType : tilesTouching)
			{
				TileEvent.touch(tileType);
			}
		}

	}
}
