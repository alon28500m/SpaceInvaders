package Juego;

public interface IPlayerController {
	// Player actions
	public boolean MovePlayer (boolean dir, int numCells);
	public boolean shootMissile();
	public boolean shockWave();
	// Callback
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();

}
