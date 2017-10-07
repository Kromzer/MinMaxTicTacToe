package com.wordpress.kromzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Node.
 */
public class Node {
	/** parent. */
	private Node parent;

	/** children. */
	private final List<Node> children;

	/** Int value. */
	private final List<Integer> values;

	/** Grid of this node. */
	private final int[] grid;

	/** Current mark. */
	private final CellState currentMark;

	/**
	 * Constructor used to construct the tree for the minmax algorithm
	 * @param myParent node parent
	 * @param myGrid node grid
	 * @param myCurrentMark current player mark
	 */
	public Node(final Node myParent, final int[] myGrid, final CellState myCurrentMark) {
		this.grid = myGrid;

		this.parent = myParent;

		this.currentMark = myCurrentMark;
		this.children = new ArrayList<>();
		this.values = new ArrayList<>();

		this.generateChildren();
	}

	/**
	 * Method generating this node children.
	 **/
	private void generateChildren() {
		final int winner = TicTacToe.returnWinner(this.grid);
		if (winner == -1) {
			// Create every possible child node
			for (int i = 0; i < 9; i++) {
				final int[] newGrid = this.grid.clone();

				if (newGrid[i] == CellState.EMPTY.ordinal()) {
					newGrid[i] = this.currentMark.ordinal();
					final CellState nextMark = (this.currentMark == CellState.CIRCLE ? CellState.CROSS
							: CellState.CIRCLE);
					this.getValues().add(new Integer(-1));
					this.children.add(new Node(this, newGrid, nextMark));
				}
			}
		}
	}

	/**
	 * Populate values of the tree.
	 * @param rootNode the root node
	 * @param playerMark the player mark (to compute scores)
	 */
	public static void populateValues(final Node rootNode, final CellState playerMark) {
		final int winner = TicTacToe.returnWinner(rootNode.getGrid());
		// If we are in an end state, we return the score from the player point of view
		if (winner != -1) {
			final int indexOfChild = rootNode.getParent().getChildren().indexOf(rootNode);
			if (winner == playerMark.ordinal()) {
				rootNode.getParent().getValues().set(indexOfChild, 100);
			}
			else if (winner == CellState.getOpposite(playerMark).ordinal()) {
				rootNode.getParent().getValues().set(indexOfChild, -100);
			}
			else {
				rootNode.getParent().getValues().set(indexOfChild, 0);
			}
		}
		// Else we compute the value for each child and we return the score from the
		// player point of view
		else {
			for (int i = 0; i < rootNode.getChildren().size(); i++) {
				populateValues(rootNode.getChildren().get(i), playerMark);
			}

			if (rootNode.getParent() != null) {
				final int indexOfChild = rootNode.getParent().getChildren().indexOf(rootNode);
				if (rootNode.getCurrentMark() == playerMark) {
					rootNode.getParent().getValues().set(indexOfChild, Collections.max(rootNode.getValues()));
				}
				else {
					rootNode.getParent().getValues().set(indexOfChild, Collections.min(rootNode.getValues()));
				}
			}
		}
	}

	/**
	 * Getter for grid.
	 * @return the grid
	 */
	public final int[] getGrid() {
		return this.grid;
	}

	/**
	 * Getter for children.
	 * @return the children
	 */
	public final List<Node> getChildren() {
		return this.children;
	}

	/**
	 * Getter for values.
	 * @return the values
	 */
	public final List<Integer> getValues() {
		return this.values;
	}

	/**
	 * Getter for parent.
	 * @return the parent
	 */
	public final Node getParent() {
		return this.parent;
	}

	/**
	 * Setter for parent.
	 * @param myParent the parent to set
	 */
	public final void setParent(final Node myParent) {
		this.parent = myParent;
	}

	/**
	 * @return the currentMark
	 */
	public final CellState getCurrentMark() {
		return this.currentMark;
	}
}
