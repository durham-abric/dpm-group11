package main;

import main.controller.Navigator;
import main.controller.Odometer;
import main.controller.OdometryDisplay;
import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import main.model.Parameters;
import main.wifi.WifiConnection;
import main.wifi.WifiProperties;

import java.util.Map;

/**
 * Main class for vehicle
 *
 * @author JohnWu
 */
public class FinalProject {

//    private static final EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(LocalEV3.get().getPort("A"));
//    private static final EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(LocalEV3.get().getPort("D"));

    private static Parameters parameters;

    private static int forwardTeam;
    private static int defenseTeam;
    private static int forwardCorner;
    private static int defenseCorner;
    private static int forwardLine;
    private static int[] defenderZone = new int[2];
    private static int[] ballDispenserPosition = new int[2];
    private static String ballDispenserOrientation;


    public static void main(String[] args) {

        @SuppressWarnings("main/resource")
        final TextLCD t = LocalEV3.get().getTextLCD();

        /**
         * Uncomment for wifi code
         */
        retrieveStartingParameters();
        t.drawString( Integer.toString( parameters.getForwardTeam() ), 0, 0);
        t.drawString( Integer.toString( parameters.getDefenseTeam() ), 0, 1);
        t.drawString( Integer.toString( parameters.getForwardCorner() ), 0, 2);
        t.drawString( Integer.toString( parameters.getDefenseCorner() ), 0, 3);
        t.drawString( Integer.toString( parameters.getForwardLine() ), 0, 4);
        t.drawString( Integer.toString( parameters.getDefenderZone()[0] ), 0, 5);
        t.drawString( Integer.toString( parameters.getDefenderZone()[1] ), 0, 6);
        t.drawString( Integer.toString( parameters.getBallDispenserPosition()[0] ) + "  " +Integer.toString( parameters.getBallDispenserPosition()[1] ) +
                " " + parameters.getBallDispenserOrientation(), 0, 7);
        int buttonChoice = Button.waitForAnyPress();



        /**
         * Uncomment for regular code without wifi.
         */
//        t.clear();
//        t.drawString("Hello World", 0, 0);
//        int buttonChoice = Button.waitForAnyPress();
//        if ( buttonChoice == Button.ID_UP ) {
//            Odometer o = new Odometer(leftMotor,rightMotor);
//            Navigator n = new Navigator(leftMotor,rightMotor,o);
//            OdometryDisplay odometryDisplay = new OdometryDisplay(o,t);
//            o.start();
//            odometryDisplay.start();
//            n.travelTo(0,30);
//            n.travelTo(30,0);
//        }
//        System.exit(0);
    }

    /**
     * A method to retrieve the starting parameters inputted by the server
     */
    private static void retrieveStartingParameters() {

        WifiConnection conn = new WifiConnection( WifiProperties.SERVER_IP, WifiProperties.TEAM_NUMBER,
                WifiProperties.ENABLE_DEBUG_WIFI_PRINT );
        parameters = new Parameters();

        try {
            Map data = conn.getData();
            parameters.setForwardTeam( ( (Long) data.get( "FWD_TEAM" ) ).intValue() );
            parameters.setDefenseTeam( ( (Long) data.get( "DEF_TEAM" ) ).intValue() );
            parameters.setForwardCorner( ( (Long) data.get( "FWD_CORNER" ) ).intValue() );
            parameters.setDefenseCorner( ( (Long) data.get( "DEF_CORNER" ) ).intValue() );
            parameters.setForwardLine( ( (Long) data.get( "d1" ) ).intValue() );
            parameters.setDefenderZone( new int[]{ ( (Long) data.get( "w1" ) ).intValue(), ( (Long) data.get( "w2" ) ).intValue() } );
            parameters.setBallDispenserPosition( new int[]{ ( (Long) data.get( "bx" )).intValue(), ( (Long) data.get( "by" )).intValue() });
            parameters.setBallDispenserOrientation( (String) data.get( "omega" ) );
        } catch ( Exception e ) {
            // Error occurred
        }
    }
}
