package org.usfirst.frc.team7042.robot.commands.autonomous;

import org.usfirst.frc.team7042.robot.choosers.StartPos;
import org.usfirst.frc.team7042.robot.choosers.Target;
import org.usfirst.frc.team7042.robot.commands.lift.ZeroLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSequencer extends CommandGroup {

    public AutoSequencer(Target target, TargetPosition side, StartPos start) {
    	addSequential(new ZeroLift());
    	
    	switch(start) {
    	case LEFT: // start pos
    		switch(target) {
            case SWITCH: // target
            	switch(side) {
            	case LEFT: // target side
            		addSequential(new TurnDegrees(90));
            		addSequential(new MoveDistance(1.0668));
            		addSequential(new TurnDegrees(-90));
            		addSequential(new MoveDistance(2.5908));
            		//lift up + eject
            		break;
            	case RIGHT:
            		addSequential(new MoveDistance(5.9436));
            		addSequential(new TurnDegrees(90));
            		addSequential(new MoveDistance(4.9784));
            		addSequential(new TurnDegrees(90));
            		addSequential(new MoveDistance(1.5748));
            		addSequential(new TurnDegrees(90));
            		addSequential(new MoveDistance(0.2032));
            		//lift up + eject
            		break;
            	}
            	break;
            case SCALE:
            	switch(side) {
            	case LEFT:
            		//addSequential(new MoveDistance());
            		//lift up + eject?
            		break;
            	case RIGHT:
//            		addSequential(new MoveDistance());
//            		addSequential(new TurnDegrees(90));
//            		addSequential(new MoveDistance());
//            		addSequential(new TurnDegrees(-90));
//            		addSequential(new MoveDistance());
            		//lift up + eject
            		break;
            	}
            	break;
            default:
            	addSequential(new FailsafeAuto());
            	break;
            }
    		break;
    	case MIDDLE:
    		switch(target) {
            case SWITCH:
            	switch(side) {
            	case LEFT:
            		addSequential(new TurnDegrees(-90));
            		addSequential(new MoveDistance(1.9812));
            		addSequential(new TurnDegrees(90));
            		addSequential(new MoveDistance(2.5908));
            		break;
            	case RIGHT:
            		addSequential(new TurnDegrees(90));
            		addSequential(new MoveDistance(0.762));
            		addSequential(new TurnDegrees(-90));
            		addSequential(new MoveDistance(2.5908));
            		break;
            	}
            	break;
            case SCALE:
            	switch(side) {
            	case LEFT:
            		
            		break;
            	case RIGHT:
            		
            		break;
            	}
            	break;
            default:
            	addSequential(new FailsafeAuto());
            	break;
            }
    		break;
    	case RIGHT:
    		switch(target) {
            case SWITCH:
            	switch(side) {
            	case LEFT:
            		addSequential(new MoveDistance(5.9436));
            		addSequential(new TurnDegrees(-90));
            		addSequential(new MoveDistance(4.9784));
            		addSequential(new TurnDegrees(-90));
            		addSequential(new MoveDistance(1.5748));
            		addSequential(new TurnDegrees(-90));
            		addSequential(new MoveDistance(0.2032));
            		break;
            	case RIGHT:
            		addSequential(new TurnDegrees(-90));
            		addSequential(new MoveDistance(1.0668));
            		addSequential(new TurnDegrees(90));
            		addSequential(new MoveDistance(2.5908));
            		break;
            	}
            	break;
            case SCALE:
            	switch(side) {
            	case LEFT:
            		
            		break;
            	case RIGHT:
            		
            		break;
            	}
            	break;
            default:
            	addSequential(new FailsafeAuto());
            	break;
            }
    		break;
    	}
        
    }
}
