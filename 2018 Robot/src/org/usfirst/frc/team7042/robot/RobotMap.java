/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7042.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static Spark frontLeft = new Spark(0); //Test
	public static Spark backLeft = new Spark(1);
	public static Spark frontRight = new Spark(2);
	public static Spark backRight = new Spark(3);
	
	public static Joystick flightStick = new Joystick(0);
	public static Joystick logitech = new Joystick(1);
	
	public static Encoder leftEncoder = new Encoder(6,7);
	public static Encoder rightEncoder = new Encoder(8,9);
	public static Encoder liftEncoder = new Encoder(4,5);
	
	public static VictorSP rotatemotor = new VictorSP(4);
	public static VictorSP leftArmMotor = new VictorSP(5);
	public static VictorSP rightArmMotor = new VictorSP(6);

	
	public static Compressor comp = new Compressor();
    
    public static DoubleSolenoid grabSolenoid = new DoubleSolenoid(2,3);// what ports?

    //public static TalonSRX lift2 = new TalonSRX(1);
    public static final int ARM_WHEEL_1_PDP = 14;
    public static final int ARM_WHEEL_2_PDP = 0;


    public static PowerDistributionPanel pdp = new PowerDistributionPanel();
    
    public static AHRS ahrs = new AHRS(SPI.Port.kMXP);
    
}
