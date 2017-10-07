package com.wordpress.kromzer;

import java.util.Collections;

/**
 * ComputerPlayer.
 */
public class ComputerPlayer extends Player {

	/**
	 * Constructor.
	 * @param myMark player mark
	 */
	public ComputerPlayer(final CellState myMark) {
		super(myMark);
	}

	/** {@inheritDoc} */
	@Override
	public void play(final int[] grid) {
		final Node node = new Node(null, grid, this.mark);
		Node.populateValues(node, this.mark);

		for (int i = 0; i < node.getChildren().size(); i++) {
			if (node.getValues().get(i) == Collections.max(node.getValues())) {
				for (int j = 0; j < 9; j++) {
					grid[j] = node.getChildren().get(i).getGrid()[j];
				}
			}
		}
	}
}
