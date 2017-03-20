package main.object;

/**
 * An object which represents the characteristics of each square on our field
 */
public class Square {

    private int[] squarePosition;
    private boolean allowed;
    private boolean obstacle = false;
    private boolean ballDisp = false;
    private boolean ballDispApproach = false;
    private boolean shootingPosition = false;
    private double[] centerCoordinate;
    private double northLine;
    private double southLine;
    private double eastLine;
    private double westLine;

    public Square(int xSqr, int ySqr) {
        this.squarePosition = new int[2];
        this.squarePosition[0] = xSqr;
        this.squarePosition[1] = ySqr;

        this.centerCoordinate =  new double[2];
        this.centerCoordinate[0] = (squarePosition[0]-0.5)* SQUARE_LENGTH;
        this.centerCoordinate[1] = (squarePosition[1]-0.5)* SQUARE_LENGTH;

        this.northLine = squarePosition[0]* SQUARE_LENGTH;
        this.southLine = (squarePosition[0]-1)* SQUARE_LENGTH;

        this.eastLine = squarePosition[1]* SQUARE_LENGTH;
        this.westLine = (squarePosition[1]-1)* SQUARE_LENGTH;
    }

    public int getX() {
        return squarePosition[0];
    }

    public int getY() {
        return squarePosition[1];
    }

    public double getXcm() {
        return centerCoordinate[0];
    }

    public double getYcm() {
        return centerCoordinate[1];
    }

    public boolean isAllowed() {
        return allowed;
    }

    public void containsObstacle(){
        this.obstacle = true;
        this.allowed = false;
    }

    public void setBallDispApproach() {
        this.ballDispApproach = true;
    }

    public void constainsBallDispenser(){
        this.ballDisp = true;
    }
    public void setShootingPosition(){
        this.shootingPosition = true;
    }

    public boolean isObstacle(){
        return obstacle;
    }

    public boolean isBallDisp(){
        return ballDisp;
    }

    public boolean isBallDispApproach() {
        return ballDispApproach;
    }

    public boolean isShootingPosition(){
        return shootingPosition;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public double getNorthLine() {
        return northLine;
    }

    public double getSouthLine() {
        return southLine;
    }

    public double getEastLine() {
        return eastLine;
    }

    public double getWestLine() {
        return westLine;
    }


}
