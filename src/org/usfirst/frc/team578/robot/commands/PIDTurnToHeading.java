package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;

/*
 * Experimental class not currently in use.
 * Can we use this to turn better?
 * Do PIDs need a longer flow to really work well?
 */

public class PIDTurnToHeading extends PIDCommand {

	private final double heading;

	private static final double kP = 0.04;
	private static final double kI = 0.00;
	private static final double kD = 0.075;

	private final double kToleranceDegrees = 5.f;

	private boolean hasRunReturnPidInputAtLeastOnce;

	public PIDTurnToHeading(double heading) {
		super("turn to " + heading, kP, kI, kD);
		// requires(Robot.driveSubsystem);
		this.heading = heading;
		getPIDController().setInputRange(0.f, 360.f);
		getPIDController().setOutputRange(-1., 1.);
		getPIDController().setAbsoluteTolerance(kToleranceDegrees);
		getPIDController().setContinuous(true);
		setSetpoint(heading);
	}

	@Override
	protected void initialize() {
		hasRunReturnPidInputAtLeastOnce = false;
	}

	@Override
	protected boolean isFinished() {
		return this.getPIDController().onTarget() && hasRunReturnPidInputAtLeastOnce && Math.abs(Robot.gyroSubsystem.getRate()) <= 0.3;
	}

	@Override
	protected double returnPIDInput() {
		if (!hasRunReturnPidInputAtLeastOnce)
			hasRunReturnPidInputAtLeastOnce = true;
		return Robot.gyroSubsystem.getHeading();
	}

	@Override
	protected void usePIDOutput(double output) {
	
		System.err.println("Drive : " + output);
		
		// Robot.driveSubsystem.(0, 0, output, Robot.driveSubsystem.getAngle());
	}
}
