package com.bhavadeep.gridanimationjava;

import static com.bhavadeep.gridanimationjava.Main.UP;
import static com.bhavadeep.gridanimationjava.Main.UP_LEFT;
import static com.bhavadeep.gridanimationjava.Main.VEERLEFT;

public class VLActor extends Actor {

	private int turnState;
	VLActor(int row, int column, int direction) {
		super(VEERLEFT, row, column, direction);
		turnState =0;
	}

	@Override
	public void moveDirection(MovementDirection movementDirection) {
		if(turnState ==0)
		{
		    int direction = getDirection();
		    if(direction<=UP){
                direction = UP_LEFT+1;
            }
			setDirection((direction-1)%8);
			turnState =1;
		}
		else
		{
			turnState =0;
		}
		super.moveDirection(movementDirection);
	}


}
