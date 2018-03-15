package org.usfirst.frc.team7042.robot.choosers;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class TargetChooser extends SendableChooser<Target> {
	public TargetChooser() {
		super();
		addObject("Switch", Target.SWITCH);
		addObject("Scale", Target.SCALE);
		addDefault("Fallback", Target.FAILSAFE);
	}
}
