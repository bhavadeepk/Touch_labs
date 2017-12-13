package com.bhavadeep.gridanimationjava;

import static com.bhavadeep.gridanimationjava.Main.UP;
import static com.bhavadeep.gridanimationjava.Main.UP_LEFT;
import static com.bhavadeep.gridanimationjava.Main.VEERRIGHT;

public class VRActor extends Actor {

	private int turnState;
	VRActor(int row, int column, int direction) {
		super(VEERRIGHT, row, column, direction);
		turnState =0;
	}

	@Override
	public void moveDirection(MovementDirection movementDirection) {
		if(turnState ==0)
		{
			int direction =getDirection();
			if(direction>=UP_LEFT)
				direction = UP -1;
			setDirection((direction+1)%8);
			turnState =1;
		}
		else
		{
			turnState =0;
		}
		super.moveDirection(movementDirection);
	}
	

}
