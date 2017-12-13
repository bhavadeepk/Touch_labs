package com.bhavadeep.gridanimationjava;

import java.util.Random;

import static com.bhavadeep.gridanimationjava.Main.RANDOM;

public class RandomActor extends Actor {
    private int maxWidth, maxHeight;

	RandomActor(int row, int column, int maxWidth, int maxHeight) {
		super(RANDOM, row, column, 0);
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
	}

    /**
     * Override moveDirection to move actor to random row and column position
     * @param movementDirection - {@Link MovementDirection} object to define Grid layout and movement in different directions
     */
	@Override
	public void moveDirection(MovementDirection movementDirection) {
		Random random = new Random();
		setRow(random.nextInt(maxWidth-1));
		setColumn(random.nextInt(maxHeight-1));
	}

}
