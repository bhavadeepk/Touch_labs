package com.bhavadeep.gridanimationjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    static final String LINEAR = "L";
    static final String STILL = "S";
    static final String RANDOM = "R";
    static final String VEERLEFT = "VL";
    static final String VEERRIGHT = "VR";

    private static final String COMMA = ",";

    static final int UP = 0;
    static final int UP_RIGHT = 1;
    static final int RIGHT = 2;
    static final int DOWN_RIGHT = 3;
    static final int DOWN = 4;
    static final int DOWN_LEFT = 5;
    static final int LEFT = 6;
    static final int UP_LEFT = 7;
    static final int NO_MOVEMENT = -1;

    private static int width = 0;
    private static int height = 0;

	public static void main(String[] args) {

        if (args.length != 4) {
            System.out.println(args.length);
            System.err.println("Invalid Number of Input Parameters");
            System.exit(1);
        }

        int frames = 0;

        FileParser fileParser = new FileParser(args[0]);
        List<String> inputListFromFile = fileParser.getActorsFromFile();

        try {
            width = Integer.parseInt(args[1]);
            height = Integer.parseInt(args[2]);
            frames = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // Setup the Grid and define the directions for actors
        MovementDirection movementDirection = new MovementDirection(width, height);

        List<Actor> inputActorsList = fillListOfActorsFromStrings(inputListFromFile);

       //Print the Output for each frame and move the actor for the next frame
        for(int i=0;i<frames;i++){
            for (Actor actor: inputActorsList)
            {
                printActorPosition(actor, String.valueOf(i));
                actor.moveDirection(movementDirection);
            }

        }
    }

    /**
     * Create Actors from the strings obtained from input file and list them
     * @param inputListFromFile - List of strings each representing an actor
     *
     */
    private static List<Actor> fillListOfActorsFromStrings(List<String> inputListFromFile) {
        List<Actor> inputActorsList = new ArrayList<>();
        for (String actorString : inputListFromFile) {
            String[] splitString = actorString.split(COMMA);
            String type = splitString[0];
            int row = 0;
            int column = 0;
            int direction = NO_MOVEMENT;
            if (!(type.equals(RANDOM))) { // Avoiding OutOfBoundException
                row = Integer.valueOf(splitString[1]);
                column = Integer.valueOf(splitString[2]);
                if (!(type.equals(STILL))) {
                    direction = Integer.valueOf(splitString[3]);
                }
            }
            Actor actor;
            switch (type) {
                case LINEAR: {
                    actor = new LinearActor(row, column, direction);
                    break;
                }
                case STILL: {
                    actor = new StillActor(row, column);
                    break;
                }
                case RANDOM: {
                    Random randomNumber = new Random();
                    actor = new RandomActor(randomNumber.nextInt(width), randomNumber.nextInt(height), width, height);
                    break;
                }
                case VEERRIGHT: {
                    actor = new VRActor(row, column, direction);
                    break;
                }
                case VEERLEFT: {
                    actor = new VLActor(row, column, direction);
                    break;
                }
                default: {
                    actor = new StillActor(row, column);
                    break;
                }
            }
            inputActorsList.add(actor);
        }

        return inputActorsList;
    }

    //Print the output
    private static void printActorPosition(Actor actor, String frame){
            System.out.println( frame + COMMA + actor.getType() + COMMA + actor.getRow() + COMMA + actor.getColumn());
        }


}
