package main.controller;

import lejos.hardware.Sound;
import lejos.robotics.SampleProvider;
import main.resource.Constants;

/**
 * Created by JohnWu on 2017-03-12.
 */
public class OdometerCorrection extends Thread {

    // objects
    private Navigator navigator;
    private Odometer odometer;
    private SampleProvider leftSensor;
    private SampleProvider rightSensor;
    private Object lock;

    // variables
    private boolean running = true;
    private float[] leftSensorData;
    private  float[] rightSensorData;

    /**
     * Our main constructor method
     *
     * @param leftSensor
     * @param rightSensor
     */
    public OdometerCorrection( Navigator navigator, Odometer odometer, SampleProvider leftSensor, SampleProvider rightSensor ) {
        this.navigator = navigator;
        this.odometer = odometer;
        this.leftSensor = leftSensor;
        this.rightSensor = rightSensor;
        this.leftSensorData = new float[leftSensor.sampleSize()];
        this.rightSensorData = new float[rightSensor.sampleSize()];
    }

    /**
     * Main thread
     */
    public void run() {
        while ( true ) {
            if ( running ) {
                if ( isLineDetectedLeft() ) {
                    navigator.interrupt();
                    Sound.buzz();
                    navigator.stopMotors();
//                    while ( !isLineDetectedRight() ) {
//                        navigator.rotateRightMotorForward();
//                    }
//                    navigator.stopMotors();
//                    odometer.setTheta( Math.PI/2 );
                }
                if ( isLineDetectedRight() ) {
                    navigator.interrupt();
                    Sound.buzz();
                    navigator.stopMotors();
//                    while ( !isLineDetectedLeft() ) {
//                        navigator.rotateLeftMotorForward();
//                    }
//                    navigator.stopMotors();
//                    odometer.setTheta( Math.PI/2 );
                }
//                navigator.travelToPerpendicular( navigator.getTravellingToX(), navigator.getTravellingToY() );
            }
        }
    }

    /**
     * A method to determine if a line is detected or not for the left sensor
     *
     * @return
     */
    public boolean isLineDetectedLeft() {
        leftSensor.fetchSample(leftSensorData, 0);
        if( leftSensorData[0] < Constants.LOWER_LIGHT_THRESHOLD ) {
            return true;
        }
        return false;
    }

    /**
     * A method to determine if a line is detected or not for the right sensor
     *
     * @return
     */
    public boolean isLineDetectedRight() {
        rightSensor.fetchSample(rightSensorData, 0);
        if( rightSensorData[0] < Constants.LOWER_LIGHT_THRESHOLD ) {
            return true;
        }
        return false;
    }

    /**
     * A method that stops our thread
     */
    public void stopRunning() {
        running = false;
    }

}