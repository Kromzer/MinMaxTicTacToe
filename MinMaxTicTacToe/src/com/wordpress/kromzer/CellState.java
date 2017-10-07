package com.wordpress.kromzer;

/**
 * CellState.
 */
public enum CellState {
	/** Empty cell. */
	EMPTY(0),
	/** Cell with a cross in it. */
	CROSS(1),
	/** Cell with a circle in it. */
	CIRCLE(2);

	/**
	 * default constructor
	 * @param myValue the value
	 */
	CellState(final int myValue) {
	}

	/**
	 * Get opposite mark
	 * @param myCellState the mark to get the opposite of
	 * @return the opposite of myCellState
	 */
	static public CellState getOpposite(final CellState myCellState) {
		if (CellState.CROSS.equals(myCellState)) {
			return CellState.CIRCLE;
		}
		else if (CellState.CIRCLE.equals(myCellState)) {
			return CellState.CROSS;
		}
		else {
			return CellState.EMPTY;
		}
	}

	/**
	 * Get sign of the cell
	 * @param cellState the given cell
	 * @return the sign
	 */
	static public String getValue(final int cellState) {
		switch (cellState) {
		case 0:
			return " ";
		case 1:
			return "X";
		case 2:
			return "O";
		default:
			return "";
		}
	}
}
