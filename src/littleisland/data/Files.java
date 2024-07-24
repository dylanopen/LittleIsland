package littleisland.data;

import littleisland.game.Game;
import littleisland.game.LittleIsland;

import java.io.*;
import java.util.Objects;

public class Files
{
	// https://stackoverflow.com/a/4716623
	public static String read(String filepath) throws IOException
	{
		InputStream stream = Objects.requireNonNull(LittleIsland.class.getClassLoader().getResourceAsStream(filepath));
		try(BufferedReader br = new BufferedReader(new FileReader(filepath)))
		{
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			return sb.toString();
		}
	}

	public static void write(String filepath, String content) throws IOException
	{
		FileWriter fileWriter = new FileWriter(filepath);
		fileWriter.write(content);
		fileWriter.close();
	}
}
