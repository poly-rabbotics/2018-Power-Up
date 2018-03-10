/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7042.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team7042.robot.choosers.ControlChooser;
import org.usfirst.frc.team7042.robot.commands.TeleopNoPID;
import org.usfirst.frc.team7042.robot.commands.autonomous.MoveDistance;
import org.usfirst.frc.team7042.robot.commands.autonomous.TurnDegrees;
import org.usfirst.frc.team7042.robot.subsystems.*;
import org.usfirst.frc.team7042.utils.PolyPrefs;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static final DriveSystem driveSystem = new DriveSystem();
	public static final Lift lift = new Lift();
	public static final LiftSlider slider = new LiftSlider();
	public static OI m_oi;
	public static ControlChooser controlChooser = new ControlChooser();
	public static final ArmWheels intake = new ArmWheels();
	public static final Grab grabber = new Grab();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();

		RobotMap.leftEncoder.setDistancePerPulse(1/PolyPrefs.getEncTicks());
		RobotMap.rightEncoder.setDistancePerPulse(1/PolyPrefs.getEncTicks());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		System.out.println(DriverStation.getInstance().getGameSpecificMessage());
		
		//option 3R
		TurnDegrees turn = new TurnDegrees(-90);
		MoveDistance move = new MoveDistance(0.6096);
		TurnDegrees turn1 = new TurnDegrees(90);
		MoveDistance move1 = new MoveDistance(2.7867);
		

	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
 	}

	@Override
	public void teleopInit() {
		TeleopNoPID teleopNoPID = new TeleopNoPID();
		teleopNoPID.start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
//		System.out.format("DISTANCE: L:%.2f R:%.2f\n", RobotMap.leftEncoder.getDistance(), RobotMap.rightEncoder.getDistance());
//		System.out.format("ANGLE Displacement:%.2f Rate:%.2f\n",RobotMap.ahrs.getAngle(),RobotMap.ahrs.getRate());
//		System.out.format("AHRS Pitch:%2f Roll:%.2f\n", RobotMap.ahrs.getPitch(), RobotMap.ahrs.getRoll());
		Scheduler.getInstance().run();
		SmartDashboard.putData(RobotMap.pdp);
		
//		if(RobotMap.flightStick.getRawButton(11))
//			RobotMap.armWheels1.set(ControlMode.PercentOutput, 1);
	}

	@Override
	public void testInit() {
	}
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		//System.out.format("Angle:%.2f Rate:%.2f Pitch:%.2f Roll:%.2f xV:%.2f yV:%.2f\n", RobotMap.pi.getAngle(), RobotMap.pi.getRate(), RobotMap.pi.getPitch(), RobotMap.pi.getRoll(), RobotMap.pi.getXVelocity(), RobotMap.pi.getYVelocity());
		
		Robot.driveSystem.driveDisplacementPID();
		System.out.format("MOVE Enabled:%s Current:%.2f Setpoint:%.2f Output:%.2f\n", Boolean.toString(driveSystem.movePID.isEnabled()), (RobotMap.leftEncoder.getDistance() + RobotMap.rightEncoder.getDistance()) / 2, driveSystem.movePID.getSetpoint(), driveSystem.movePID.get());
		System.out.format("TURN Enabled:%s Current:%.2f Setpoint:%.2f Output:%.2f\n", Boolean.toString(driveSystem.turnPID.isEnabled()), RobotMap.ahrs.getAngle(), driveSystem.turnPID.getSetpoint(), driveSystem.turnPID.get());
		System.out.format("TILT Enabled:%s Current:%.2f Setpoint:%.2f Output:%.2f\n", Boolean.toString(driveSystem.pitchPID.isEnabled()), RobotMap.ahrs.getRoll(), driveSystem.pitchPID.getSetpoint(), driveSystem.pitchPID.get());
		System.out.println("-------------------");

		if(RobotMap.flightStick.getRawButton(12)) {
			RobotMap.leftEncoder.reset();
			RobotMap.rightEncoder.reset();
		}
	}
}
