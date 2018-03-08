package org.usfirst.frc.team7042.robot.commands;

import org.usfirst.frc.team7042.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Grabber extends Command {

    public Grabber() {
    	super();
    	requires(Robot.grabber);
    }

    protected void initialize() {
    	if(Robot.grabber.getOut())
    		Robot.grabber.putOut();
    	else
    		Robot.grabber.putIn();
    }
    
}
