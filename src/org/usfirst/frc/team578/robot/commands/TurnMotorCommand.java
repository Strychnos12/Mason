package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnMotorCommand extends Command {

	public TurnMotorCommand() {
		System.err.println("Turn Motor Requires");
		requires(Robot.motorSubsystem);
	}

	@Override
	protected void initialize() {
		Robot.motorSubsystem.spinStop();
	}

	@Override
	protected void execute() {
		System.err.println("TM Forward");
		Robot.motorSubsystem.spinForward();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}
	
	@Override
	public void interrupted() {
		System.err.println("TM Interrupt");
		Robot.motorSubsystem.spinStop();
	}

}
