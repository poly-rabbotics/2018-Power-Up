package org.usfirst.frc.team7042.robot.choosers;

import org.usfirst.frc.team7042.robot.controllers.*;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ControlChooser extends SendableChooser<DriveController> {
	
	private final String NAME = "Control Chooser";
	
	public ControlChooser() {
		super();
		addDefault("Flight Stick", new FlightStickWrapper());
		
		SmartDashboard.putData(NAME, this);
	}

}
