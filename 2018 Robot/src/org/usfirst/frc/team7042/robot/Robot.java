/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7042.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team7042.robot.choosers.ControlChooser;
import org.usfirst.frc.team7042.robot.choosers.StartChooser;
import org.usfirst.frc.team7042.robot.choosers.TargetChooser;
import org.usfirst.frc.team7042.robot.commands.RunElbow;
import org.usfirst.frc.team7042.robot.commands.TeleopNoPID;
import org.usfirst.frc.team7042.robot.commands.autonomous.FailsafeAuto;
import org.usfirst.frc.team7042.robot.subsystems.*;
import org.usfirst.frc.team7042.utils.PolyPrefs;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static DriveSystem driveSystem = new DriveSystem();
	public static OI m_oi;
	public static ControlChooser controlChooser = new ControlChooser();
	public static TargetChooser target = new TargetChooser();
	public static StartChooser start = new StartChooser();
	public static Elbow elbow = new Elbow();
	public static ArmWheels arms = new ArmWheels();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();

		RobotMap.leftEncoder.setDistancePerPulse(1/PolyPrefs.getEncTicks());
		RobotMap.rightEncoder.setDistancePerPulse(1/PolyPrefs.getEncTicks());
		
		//CameraServer.getInstance().startAutomaticCapture();
		
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
		/*System.out.println(DriverStation.getInstance().getGameSpecificMessage());
		
		new FailsafeAuto().start();
		
		String fieldPos = DriverStation.getInstance().getGameSpecificMessage();
		TargetPosition switchPos, scalePos;
		
		Command autoCommand;
		if(fieldPos.length() >= 2) {
			switchPos = posFromChar(fieldPos.charAt(0));
			scalePos = posFromChar(fieldPos.charAt(1));
			if(switchPos == null || scalePos == null) {
				System.out.format("Recieved invalid data from FMS: \"%s\"\n", fieldPos);
				autoCommand = new FailsafeAuto();
				autoCommand.start();
				return;
			}
		} else {
			System.out.format("Recieved invalid data from FMS: \"%s\"\n", fieldPos);
			autoCommand = new FailsafeAuto();
			autoCommand.start();
			return;
		}
		
		switch(target.getSelected()) {
		case SWITCH:
			autoCommand = new AutoSequencer(Target.SWITCH, switchPos, start.getSelected());
			return;
		case SCALE:
			autoCommand = new AutoSequencer(Target.SCALE, scalePos, start.getSelected());
			return;
		case FAILSAFE:
			autoCommand = new FailsafeAuto();
			return;
		}
		
	}
	
	private TargetPosition posFromChar(char pos) {
		if(pos == 'L')
			return TargetPosition.LEFT;
		else if(pos == 'R')
			return TargetPosition.RIGHT;
		else
			System.out.format("Recieved invalid input \"%c\"\n", pos);
		return null;*/
		new FailsafeAuto().start();
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
 	}

	@Override
	public void teleopInit() {
		Scheduler.getInstance().removeAll();
		new RunElbow().start();
		new TeleopNoPID().start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		//System.out.format("M:%.2f T:%.2f\n", RobotMap.logitech.getRawAxis(1), RobotMap.logitech.getRawAxis(4));
		Scheduler.getInstance().run();
	}

	@Override
	public void testInit() {
	}
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
