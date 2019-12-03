package Juego;

import java.util.Random;
import java.util.Scanner;

import Commands.Command;
import Commands.CommandGenerator;

public class Controller {
	Game game;
	Level level;
	Scanner in;

	public Controller(Readable input) {
		in = new Scanner(input);
	}
	public void execute() {
		while (!game.isFinished()) {
			System.out.println(PROMPT);
			String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandGenerator.parseCommand(words);
			if (command != null)

				if (command.execute(game))
					System.out.println(game);
				else
					System.out.format(unknownCommandMsg);
		}
	}
}
