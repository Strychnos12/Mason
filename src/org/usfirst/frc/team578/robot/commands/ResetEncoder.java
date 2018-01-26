package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetEncoder extends Command {

	
	@Override
	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		System.err.println("Reset");
		Robot.motorSubsystem.resetEncoder();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
