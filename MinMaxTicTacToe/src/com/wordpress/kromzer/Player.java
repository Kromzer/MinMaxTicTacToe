package com.wordpress.kromzer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A tic tac toe player.
 */
public class Player {

	/** The mark of the player. */
	protected CellState mark;

	/** In reader. */
	// private Scanner in;

	/**
	 * Constructor.
	 * @param myMark player mark
	 */
	public Player(final CellState myMark) {
		this.mark = myMark;
	}

	/**
	 * Init method.
	 */
	public void init() {
		// this.in = new Scanner(System.in);
	}

	/**
	 * Play method.
	 * @param grid current grid
	 */
	public void play(final int[] grid) {
		// int number;
		// do {
		// number = this.in.nextInt();
		// }
		// while (grid[number] != CellState.EMPTY.ordinal());

		int randomNum = ThreadLocalRandom.current().nextInt(0, 9);

		while (grid[randomNum] != CellState.EMPTY.ordinal()) {
			randomNum = ThreadLocalRandom.current().nextInt(0, 9);
		}

		grid[randomNum] = this.mark.ordinal();
	}

	/**
	 * Release in.
	 */
	public void closeIn() {
		// this.in.close();
	}
}
