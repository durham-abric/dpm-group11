package main.util;

import main.Parameters;
import main.object.Square;
import main.resource.Constants;

/**
 * A utility class that creates a mapping of our field based on its parameters
 *
 * @author JohnWu
 */
public class FieldMapper {

    // properties
    private Square[][] squares;
    private Parameters parameters;

    /**
     * Main intialization method
     *
     * @param parameters the given to the robot
     */
    public FieldMapper( Parameters parameters ) {
        this.parameters = parameters;
        this.squares = new Square[12][12];
        mapField();
    }

    public void mapField(){
        for ( int i = 0; i < 12; i++ ) {
            for (int k = 0; k < 12; k++) {
                Square square = new Square(i,k);
                if (!isInDefenseRegion( i, k ) && !isGoal( i, k ) && !isInGoalRegion(i,k)) {
                    square.setAllowed((parameters.getForwardTeam() == 11));
                } else if (!isInOffenseRegion( i, k ) && !isGoal( i, k ) && !isInGoalRegion(i,k)) {
                    square.setAllowed(!(parameters.getForwardTeam() == 11));
                } else {
                    square.setAllowed(false);
                }

                squares[i][k] = square;
            }
        }

        //recognize square ball dispenser is in and the square we must reach to access it
        squares[parameters.getBallDispenserPosition()[0]][parameters.getBallDispenserPosition()[1]].constainsBallDispenser();
        String dispDir = parameters.getBallDispenserOrientation();

        if (dispDir.equals("N")){
            squares[parameters.getBallDispenserPosition()[0]][parameters.getBallDispenserPosition()[1]+1].setBallDispApproach();
        } else if (dispDir.equals("S")){
            squares[parameters.getBallDispenserPosition()[0]][parameters.getBallDispenserPosition()[1]-1].setBallDispApproach();
        } else if (dispDir.equals("E")){
            squares[parameters.getBallDispenserPosition()[0]+1][parameters.getBallDispenserPosition()[1]].setBallDispApproach();
        }else if (dispDir.equals("W")){
            squares[parameters.getBallDispenserPosition()[0]-1][parameters.getBallDispenserPosition()[1]].setBallDispApproach();
        }
    }

    /**
     * A method that determines if a square is part of the goal region
     *
     * @param i i coordinate in the double matrix mapping
     * @param k k coordinate in the double matrix mapping
     * @return whether square is in goal region
     */
    public boolean isInGoalRegion( int i, int k ) {
        int left = (( 12 - parameters.getDefenderZone()[0] ) / 2)-1;
        int right = (left + 1) + parameters.getDefenderZone()[0];
        int up = 11;
        int down = 10 - parameters.getDefenderZone()[1];

        if ( i > down && i < up && k > left && k < right ) {
            return false;
        }
        return true;
    }

    /**
     * A method that determines if a square is part of the offense region
     *
     * @param i i coordinate in the double matrix mapping
     * @param k k coordinate in the double matrix mapping
     * @return whether square is in offense
     */
    public boolean isInOffenseRegion( int i, int k ) {
        int left = 1 ;
        int right = 10;
        int up = 11 - parameters.getForwardLine();
        int down = 0;
        if ( i > down && i < up && k > left && k < right ) {
            return true;
        }
        return false;
    }

    /**
     * A method that determines if a square is part of the defense region
     *
     * @param i i coordinate in the double matrix mapping
     * @param k k coordinate in the double matrix mapping
     * @return whether square is in defense
     */
    public boolean isInDefenseRegion( int i, int k ) {
        int left = 1 ;
        int right = 10;
        int up = 11;
        int down = 10 - parameters.getForwardLine();

        if ( i > down && i < up && k > left && k < right ) {
            return true;
        }
        return false;
    }

    /**
     * A method that determines if a square is part of the goal
     *
     * @param i i coordinate in the double matrix mapping
     * @param k k coordinate in the double matrix mapping
     * @return whether square is the goal
     */
    public boolean isGoal( int i, int k ) {
        if ( i == 11 && ( k == 5 || k == 6 ) ) {
            return true;
        }
        return false;
    }

    /**
     * A method to retrieve the mapping
     *
     * @return double matrix mapping of field
     */
    public Square[][] getMapping() {
        return squares;
    }

}
