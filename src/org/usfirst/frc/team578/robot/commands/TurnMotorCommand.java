package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnMotorCommand extends Command {

	public TurnMotorCommand() {
		requires(Robot.motorSubsystem);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.motorSubsystem.spinForward();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	public void interrupted() {
		Robot.motorSubsystem.spinStop();

	}

}
