package com.bhavadeep.gridanimationjava;

/**
 * Abstract Actor class as a skeleton for different types of actors
 */
public abstract class Actor {


	private String type;
	private int row;
	private int column;
	private int direction;

    /**
     * Constructor
     * @param type - Defines type
     * @param row - Starting row
     * @param column - Starting column
     * @param direction - Direction to be moved
     */
	Actor(String type, int row, int column, int direction) {
		super();
		this.type = type;
		this.row = row;
		this.column = column;
		this.direction = direction;
	}

	String getType() {
		return type;
	}

	int getRow() {
		return row;
	}

	void setRow(int row) {
		this.row = row;
	}

	int getColumn() {
		return column;
	}

	void setColumn(int column) {
		this.column = column;
	}

	int getDirection() {
		return direction;
	}

	void setDirection(int direction) {
		this.direction = direction;
	}



    /**
     * Moving the actor in specified direction
     * @param movementDirection - {@Link MovementDirection} object to define Grid layout and movement in different directions
     */
	void moveDirection(MovementDirection movementDirection){

		switch(direction){
			case Main.UP:
				movementDirection.moveUp(this);
				break;
			case Main.UP_RIGHT:
				movementDirection.moveUpRight(this);
				break;
			case Main.RIGHT:
				movementDirection.moveRight(this);
				break;
			case Main.DOWN_RIGHT:
				movementDirection.moveDownRight(this);
				break;
			case Main.DOWN:
				movementDirection.moveDown(this);
				break;
			case Main.DOWN_LEFT:
				movementDirection.moveDownLeft(this);
				break;
			case Main.LEFT:
				movementDirection.moveLeft(this);
				break;
			case Main.UP_LEFT:
				movementDirection.moveUpLeft(this);
				break;
			default:
				//Still Actor
				break;
		}
	}
	
}
