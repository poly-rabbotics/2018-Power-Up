package org.usfirst.frc.team7042.robot.commands.autonomous;

import org.usfirst.frc.team7042.robot.PolyPrefs;
import org.usfirst.frc.team7042.robot.Robot;
import org.usfirst.frc.team7042.robot.RobotMap;
import org.usfirst.frc.team7042.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveDistance extends Command {
	
	private Encoder left = RobotMap.leftEncoder;
	private Encoder right = RobotMap.rightEncoder;
	
	
	private PIDController distanceController;
	
	private double distance;
	DriveWithAngleCorrection drv;
	
	static class AvgEncoderOutput implements PIDSource {
		
		private Encoder left, right;
		
		private PIDSourceType sourcetype = PIDSourceType.kDisplacement;
		
		public AvgEncoderOutput(Encoder left, Encoder right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			sourcetype = pidSource;
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return sourcetype;
		}

		@Override
		public double pidGet() {
			switch(sourcetype) {
			case kRate:
				return (left.getRate() + right.getRate()) / 2;
			case kDisplacement:
			default:
				return (left.getDistance() + right.getDistance()) / 2;
			}
		}
		
	}
	
	static class DriveWithAngleCorrection implements PIDOutput {
		private double angleOffset = 0;
		private final double moveErrGain = 0.1;
		
		private double getAngle() {
	    	return -(RobotMap.ahrs.getAngle() - angleOffset);
	    }
		
		public void resetAngle() {
			angleOffset = RobotMap.ahrs.getAngle();
		}

		@Override
		public void pidWrite(double output) {
			Robot.drive.arcadeDrive(output, getAngle() * moveErrGain, PolyPrefs.getAutoSpeed());
		}
		
	}

    public MoveDistance(double distance) {
    	requires(Robot.drive);
    	this.distance = distance;
    	drv = new DriveWithAngleCorrection();
    	distanceController = new PIDController(
    			PolyPrefs.getMoveP(),
    			PolyPrefs.getMoveI(),
    			PolyPrefs.getMoveD(),
    			new AvgEncoderOutput(left, right),
    			drv
    			);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	distanceController.setSetpoint(((left.getDistance() + right.getDistance()) / 2) + distance);
    	drv.resetAngle();
    	distanceController.enable();
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return distanceController.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	distanceController.disable();
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	distanceController.disable();
    	Robot.drive.stop();
    }
}
