package main.model;

/**
 * An object that represents input paramters from the server.
 */
public class Parameters {

    private int forwardTeam;
    private int defenseTeam;
    private int forwardCorner;
    private int defenseCorner;
    private int forwardLine;
    private int[] defenderZone;
    private int[] ballDispenserPosition;
    private String ballDispenserOrientation;

    public Parameters() {
        defenderZone = new int[2];
        ballDispenserPosition = new int[2];
    }

    public int getForwardTeam() {
        return forwardTeam;
    }

    public void setForwardTeam(int forwardTeam) {
        this.forwardTeam = forwardTeam;
    }

    public int getDefenseTeam() {
        return defenseTeam;
    }

    public void setDefenseTeam(int defenseTeam) {
        this.defenseTeam = defenseTeam;
    }

    public int getForwardCorner() {
        return forwardCorner;
    }

    public void setForwardCorner(int forwardCorner) {
        this.forwardCorner = forwardCorner;
    }

    public int getDefenseCorner() {
        return defenseCorner;
    }

    public void setDefenseCorner(int defenseCorner) {
        this.defenseCorner = defenseCorner;
    }

    public int getForwardLine() {
        return forwardLine;
    }

    public void setForwardLine(int forwardLine) {
        this.forwardLine = forwardLine;
    }

    public int[] getDefenderZone() {
        return defenderZone;
    }

    public void setDefenderZone(int[] defenderZone) {
        this.defenderZone = defenderZone;
    }

    public int[] getBallDispenserPosition() {
        return ballDispenserPosition;
    }

    public void setBallDispenserPosition(int[] ballDispenserPosition) {
        this.ballDispenserPosition = ballDispenserPosition;
    }

    public String getBallDispenserOrientation() {
        return ballDispenserOrientation;
    }

    public void setBallDispenserOrientation(String ballDispenserOrientation) {
        this.ballDispenserOrientation = ballDispenserOrientation;
    }
}
