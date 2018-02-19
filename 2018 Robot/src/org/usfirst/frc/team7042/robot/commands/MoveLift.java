package org.usfirst.frc.team7042.robot.commands;

import org.usfirst.frc.team7042.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class MoveLift extends InstantCommand {

    public MoveLift() {
        super();
        requires(Robot.slider);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	if(Robot.slider.getOut()) {
    		Robot.slider.putIn();
    	} else {
    		Robot.slider.putOut();
    	}
    }

}
