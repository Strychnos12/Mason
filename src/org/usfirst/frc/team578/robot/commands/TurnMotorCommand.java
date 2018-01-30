package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnMotorCommand extends Command {

//	boolean isFinished = false;
//	boolean inCommand = false;
	int target;

	public TurnMotorCommand() {
		
//		double cur = Robot.motorSubsystem._talon.getSelectedSensorPosition(0);
		System.err.println("Turn Motor Requires : ");
		requires(Robot.motorSubsystem);
	}

	@Override
	protected void initialize() {
		Robot.motorSubsystem.spinStop();
	}

	@Override
	protected void execute() {
		this.target = Robot.motorSubsystem._talon.getSelectedSensorPosition(0) + (4096 * 2);
		System.err.println("TM " + target);
		Robot.motorSubsystem.moveToPosition(target);
	}

	@Override
	protected boolean isFinished() {
		return true;
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
