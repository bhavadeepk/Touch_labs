package com.bhavadeep.gridanimationjava;

import static com.bhavadeep.gridanimationjava.Main.NO_MOVEMENT;
import static com.bhavadeep.gridanimationjava.Main.STILL;

public class StillActor extends Actor {

	StillActor(int row, int column) {
		super(STILL, row, column, NO_MOVEMENT);
	}

	@Override
	public void moveDirection(MovementDirection movementDirection) {
		// No movement
	}

}
