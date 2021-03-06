package main.object;

/**
 * An object which represents the characteristics of each square on our field
 */
public class Square {

    private int x;
    private int y;
    private boolean allowed;
    private double northPosition;
    private double southPosition;
    private double eastPosition;
    private double westPosition;

    public Square() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public double getNorthPosition() {
        return northPosition;
    }

    public void setNorthPosition(double northPosition) {
        this.northPosition = northPosition;
    }

    public double getSouthPosition() {
        return southPosition;
    }

    public void setSouthPosition(double southPosition) {
        this.southPosition = southPosition;
    }

    public double getEastPosition() {
        return eastPosition;
    }

    public void setEastPosition(double eastPosition) {
        this.eastPosition = eastPosition;
    }

    public double getWestPosition() {
        return westPosition;
    }

    public void setWestPosition(double westPosition) {
        this.westPosition = westPosition;
    }

}
