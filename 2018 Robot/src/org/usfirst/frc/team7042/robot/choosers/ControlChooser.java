package org.usfirst.frc.team7042.robot.choosers;

import org.usfirst.frc.team7042.robot.commands.*;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.TableEntryListener;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ControlChooser extends SendableChooser<Command> {
	
	private final String NAME = "Control";
	
	public ControlChooser() {
		super();
		
		addDefault("Flightstick", new FlightstickDrive());
		addObject("Xbox Controller", new LogitechDrive());
		
		SmartDashboard.putData(NAME, this);
		
		
		NetworkTableInstance.getDefault().getTable("SmartDashboard").getSubTable(NAME).getEntry("selected").addListener((notification)->{
			if(DriverStation.getInstance().isOperatorControl())
				getSelected().start();
		},TableEntryListener.kUpdate|TableEntryListener.kImmediate);
	}

}
