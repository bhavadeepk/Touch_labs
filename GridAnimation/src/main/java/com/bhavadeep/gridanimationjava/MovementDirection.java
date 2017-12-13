package com.bhavadeep.gridanimationjava;

class MovementDirection {

	private int height;
	private int width;

	/**
	 * Constructor to setup a grid layout
	 * @param width - Max width
	 * @param height - Max Height
	 */
	MovementDirection(int width, int height) {
		super();
		this.height = height;
		this.width = width;
	}
	
	int getHeight() {
		return height;
	}
	int getWidth() {
		return width;
	}

	//Moves actor to right one position
	void moveRight(Actor actor){
		if(actor.getColumn()<width-1){//If not on the last grid
			actor.setColumn(actor.getColumn()+1);
		}
	}

	//Moves actor down one position
	void moveDown(Actor actor){
		if(actor.getRow()< height-1) {//If not on the last grid
			actor.setRow(actor.getRow() + 1);
		}
	}

	//Moves actor to left one position
	void moveLeft(Actor actor){
		if(actor.getColumn()>0){//If not on the last grid
			actor.setColumn(actor.getColumn()-1);
		}
	}

	//Moves actor Up one position
	void moveUp(Actor actor){
		if(actor.getRow()>0){//If not on the last grid
			actor.setRow(actor.getRow()-1);
		}
	}

	//Moves actor to down-right one position
	void moveDownRight(Actor actor){
			moveDown(actor);
			moveRight(actor);
	}

	//Moves actor to down-left one position
	void moveDownLeft(Actor actor){
			moveDown(actor);
			moveLeft(actor);
	}

	//Moves actor to up-right one position
	void moveUpRight(Actor actor){
			moveUp(actor);
			moveRight(actor);
	}

	//Moves actor to up-left one position
	void moveUpLeft(Actor actor){
			moveUp(actor);
			moveLeft(actor);
	}
	
}
