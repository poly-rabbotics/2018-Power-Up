package org.usfirst.frc.team7042.robot.commands.autonomous;

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
	
	private double ticksPerMeter = 10;
	
	private PIDController distanceController;
	
	private double distance;
	
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
		private DriveSystem output;
		private Encoder left, right;
		private double lStart, rStart;
		
		private final double distanceBetweenWheels = 0.5; // meters
		private final double moveErrGain = 0.1;
		
		public DriveWithAngleCorrection(DriveSystem output, Encoder left, Encoder right) {
			this.output = output;
			this.left = left;
			this.right = right;
			this.lStart = left.getDistance();
			this.rStart = right.getDistance();
		}
		
		 private double getAngle() { // Positive is clockwise. Returns drift angle, multiply by -1 to get correction
	    	return (((left.getDistance() - lStart) - (right.getDistance() - rStart))/distanceBetweenWheels) * 360;
	    }

		@Override
		public void pidWrite(double output) {
			this.output.arcadeDrive(output, getAngle() * moveErrGain, RobotMap.auto_speed);
		}
		
	}

    public MoveDistance(double distance) {
    	requires(Robot.drive);
    	distanceController = new PIDController(
    			0.2,
    			0,
    			0.01,
    			new AvgEncoderOutput(left, right),
    			new DriveWithAngleCorrection(Robot.drive, left, right)
    			);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	left.setDistancePerPulse(1/ticksPerMeter);
    	right.setDistancePerPulse(1/ticksPerMeter);
    	distanceController.setSetpoint(((left.getDistance() + right.getDistance()) / 2) + distance);
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	distanceController.disable();
    }
}
