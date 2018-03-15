package org.usfirst.frc.team7042.robot.commands.intake;

import org.usfirst.frc.team7042.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class PistonGrab extends InstantCommand {

    public PistonGrab() {
        super();
        requires(Robot.grabber);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.grabber.grab();
    }

}
