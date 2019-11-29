package Juego;

import java.util.Random;
import java.util.Scanner;

import Commands.Command;
import Commands.CommandGenerator;

public class Controller {
	Game game;
	Level level;
	Scanner in;
	public Controller(Random rand) {
		game = new Game(level, rand);
		in = new Scanner();
	}
	
	while(!game.isFinished()){
		System.out.println(PROMPT);
		String[] words = in.nextLine().toLowerCase().trim().split ("\\s+");
		Command command = CommandGenerator.parse(words);
		if (command != null)
			
		if (command.execute(game))
			System.out.println(game);
		else
			System.out.format(unknownCommandMsg);
	}
}
