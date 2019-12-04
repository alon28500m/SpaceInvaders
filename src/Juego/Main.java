//falta el move de player
//computer action de player(dispara los dos misiles) o una funcion para cada uno?
//save command y files
// revisar update
//Como usar printerTypes en stringifier
//toString bomb y player


package Juego;

import java.util.Random;
import java.util.Scanner;

import Printer.BoardPrinter;


public class Main {
	public static void main(String[] args) {
		final int DIM_X = 9;
		final int DIM_Y = 8;
		int seed = 0;
		Level dif = Level.INSANE;
		Random rand;
		/*if(args.length > 0) {
			dif = Level.StringToLevel(args[0]);
			if(args.length > 1)
				seed = Integer.parseInt(args[1]);
			else
				System.out.println("You may choose a seed as well in the arguments");
		}
		else*/
			System.out.println("You should define the arguments to chose dificulty and seed");
		rand = new Random(seed);
		Game game = new Game(dif, rand);
		Scanner in = new Scanner(System.in);
		Board board = new Board(DIM_X, DIM_Y);
		BoardPrinter printer = new BoardPrinter(game, board);
		Controller ctlr = new Controller(in, printer);
		
		ctlr.execute(); 
	}
}

