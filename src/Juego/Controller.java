package Juego;


import java.util.Scanner;

import Commands.Command;
import Commands.CommandGenerator;
import Exceptions.CommandExecuteException;
import Exceptions.CommandParseException;
import Printer.GamePrinter;
import Printer.PrinterTypes;

public class Controller {
	GamePrinter printer;
	PrinterTypes generator;
	Game game;
	Scanner in;
	private static final String unknownCommandMsg = "Error. The command does not exist";
	private static final String PROMPT = ">";
	public Controller(Game game) {
		this.game = game;
		in = new Scanner(System.in);
	}
	public void execute() {
		
		//
		//
		//FORMA CORRECTA DE CONSEGUIR EL PRINTER
		PrinterTypes enumerado = PrinterTypes.BOARDPRINTER;
		printer = enumerado.getObject(game);
		
		game.initGame();
		//AHORA TE ESTA PETANDO PORQUE NO INICIALIZAS TODAS LAS COSAS QUE 
		//UTILIZA EL PRINTER COMO LA PUNTUACION. TODAS ESAS COSAS SE DEBEN INICIALIZAR O PONER 
		//A CERO EN EL INITGAME QUE NI SIQUIERA LLAMABAS. pIENSA QUE ES IGUAL QUE EN LA OTRA.
		//INICIAMOS LA PARTIDA Y LUEGO PINTAMOS.
	
		//UNA VES QUE ARREGLES EL INITGAME TE DEBERIA PINTAR SIN PROBLEMA
		
		
		System.out.println(printer.toString(game));
		while (!game.isFinished()){
			System.out.print(PROMPT);
			String[] words = in.nextLine().trim(). split ("\\s+");
			try {
				Command command = CommandGenerator.parseCommand(words);
			if (command != null)
				if (command.execute(game)) {
					System.out.println(printer.toString(game));
					game.update();
				}
				else
				System.out.println(unknownCommandMsg);
				}
			catch (CommandParseException /* | CommandExecuteException  */ex) {
				System.err.format(ex.getMessage() + "%n%n");
			}
	}
	}

}