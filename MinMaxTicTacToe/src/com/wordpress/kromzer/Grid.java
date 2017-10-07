package com.wordpress.kromzer;

/**
 * The tic tac toe grid.
 */
public class Grid {

	/** The actual grid. */
	private int[] grid;

	/**
	 * Default grid constructor.
	 */
	public Grid() {
		this.grid = new int[9];
	}

	/**
	 * Display the grid.
	 */
	public void displayGrid() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(CellState.getValue(this.grid[(i * 3) + j]));
				if (j != 2) {
					System.out.print(" | ");
				}
			}
			System.out.println("\n----------");
		}

		System.out.println("\n\n");
	}

	/**
	 * Getter for grid.
	 * @return the grid
	 */
	public int[] getGrid() {
		return this.grid;
	}

	/**
	 * Reset the grid.
	 */
	public void resetGrid() {
		this.grid = new int[9];
	}
}
