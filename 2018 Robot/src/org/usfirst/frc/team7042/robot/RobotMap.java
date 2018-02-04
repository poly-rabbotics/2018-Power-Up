/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7042.robot;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static Spark frontLeft = new Spark(0);
	public static Spark backLeft = new Spark(1);
	public static Spark frontRight = new Spark(2);
	public static Spark backRight = new Spark(3);
	
	public static Joystick flightStick = new Joystick(0);
	public static Joystick logitech = new Joystick(1);
	
	public static Encoder leftEncoder = new Encoder(0,1);
	public static Encoder rightEncoder = new Encoder(2,3);
	public static double driveTicksPerMeter = 10;
	public static double driveDistanceBetweenWheels = 0.5; // meters
	
    public static final double auto_speed = 0.25;
    
    public static DoubleSolenoid liftSolenoid = new DoubleSolenoid(0, 1);
    
    public static VictorSP liftMotor = new VictorSP(4); // Not on the robot yet
    public static Encoder liftEncoder = new Encoder(4,5); // Just for an example

}
