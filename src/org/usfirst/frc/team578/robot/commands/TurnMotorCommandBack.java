package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnMotorCommandBack extends Command {

	public TurnMotorCommandBack() {
		System.err.println("Turn MotorBack Back reqires");
		requires(Robot.motorSubsystem);
	}

	@Override
	protected void initialize() {
		Robot.motorSubsystem.spinStop();
	}

	@Override
	protected void execute() {
		System.err.println("TM Forward");
		Robot.motorSubsystem.spinBackwards();
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
