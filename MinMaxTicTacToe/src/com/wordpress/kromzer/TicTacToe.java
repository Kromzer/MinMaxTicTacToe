package com.wordpress.kromzer;

import java.io.IOException;

/**
 * Main class.
 */
public class TicTacToe {

	/** Player. */
	private final Player player;

	/** Computer. */
	private final ComputerPlayer computer;

	/** Current player. */
	private Player currentPlayer;

	/** Grid. */
	private final Grid grid;

	/** Number of games to play. */
	private static final int NB_GAMES = 1000;

	/** Default constructor. */
	public TicTacToe() {
		this.grid = new Grid();
		this.player = new Player(CellState.CIRCLE);
		this.player.init();
		this.computer = new ComputerPlayer(CellState.CROSS);

		// this.grid.getGrid()[0] = 2;
		// this.grid.getGrid()[1] = 0;
		// this.grid.getGrid()[2] = 1;
		// this.grid.getGrid()[3] = 1;
		// this.grid.getGrid()[4] = 0;
		// this.grid.getGrid()[5] = 0;
		// this.grid.getGrid()[6] = 1;
		// this.grid.getGrid()[7] = 2;
		// this.grid.getGrid()[8] = 2;

		this.currentPlayer = this.computer;
	}

	/**
	 * Method called to play the game.
	 * @throws IOException
	 */
	public void startGame() throws IOException {
		int computerWin = 0;
		int computerLose = 0;
		int computerDraw = 0;

		for (int i = 0; i < NB_GAMES; i++) {
			this.grid.resetGrid();

			while (returnWinner(this.grid.getGrid()) == -1) {

				if (this.currentPlayer == this.player) {
					this.currentPlayer.play(this.grid.getGrid());
					this.currentPlayer = this.computer;
				}
				else {
					this.currentPlayer.play(this.grid.getGrid());
					this.currentPlayer = this.player;
				}

			}

			if (returnWinner(this.grid.getGrid()) == CellState.CROSS.ordinal()) {
				computerWin++;
			}
			else if (returnWinner(this.grid.getGrid()) == CellState.CIRCLE.ordinal()) {
				computerLose++;
			}
			else {
				computerDraw++;
			}

			if ((i % 100) == 0) {
				System.out.println(i);
				System.out.println("WIN : " + computerWin);
				System.out.println("LOSE : " + computerLose);
				System.out.println("DRAW : " + computerDraw);
			}
		}

		System.out.println("WIN : " + computerWin);
		System.out.println("LOSE : " + computerLose);
		System.out.println("DRAW : " + computerDraw);
	}

	/**
	 * Check if there is a winner in the given grid.
	 * @param grid the grid to check
	 * @return the winner based on CellState.ordinal
	 */
	public static int returnWinner(final int[] grid) {
		if (((grid[0] == grid[1]) && (grid[0] == grid[2]) && (grid[0] != CellState.EMPTY.ordinal()))
				|| ((grid[0] == grid[3]) && (grid[0] == grid[6]) && (grid[0] != CellState.EMPTY.ordinal()))
				|| ((grid[0] == grid[4]) && (grid[0] == grid[8]) && (grid[0] != CellState.EMPTY.ordinal()))) {
			return grid[0];
		}

		if ((grid[3] == grid[4]) && (grid[3] == grid[5]) && (grid[3] != CellState.EMPTY.ordinal())) {
			return grid[3];
		}
		if ((grid[6] == grid[7]) && (grid[6] == grid[8]) && (grid[6] != CellState.EMPTY.ordinal())) {
			return grid[6];
		}

		if ((grid[1] == grid[4]) && (grid[1] == grid[7]) && (grid[1] != CellState.EMPTY.ordinal())) {
			return grid[1];
		}

		if ((((grid[2] == grid[4]) && (grid[2] == grid[6])) && (grid[2] != CellState.EMPTY.ordinal()))
				|| ((grid[2] == grid[5]) && (grid[2] == grid[8]) && (grid[2] != CellState.EMPTY.ordinal()))) {
			return grid[2];
		}

		for (int i = 0; i < 9; i++) {
			if (grid[i] == CellState.EMPTY.ordinal()) {
				return -1;
			}
		}

		return 0;
	}

	/**
	 * Main method.
	 * @param args unused
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException {
		final TicTacToe ticTacToeGame = new TicTacToe();
		ticTacToeGame.startGame();
	}
}
